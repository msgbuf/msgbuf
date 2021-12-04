/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import de.haumacher.msgbuf.graph.cmd.Command;
import de.haumacher.msgbuf.graph.cmd.InsertElement;
import de.haumacher.msgbuf.graph.cmd.ListUpdate;
import de.haumacher.msgbuf.graph.cmd.RemoveElement;
import de.haumacher.msgbuf.graph.cmd.SetProperty;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;
import de.haumacher.msgbuf.observer.Listener;
import de.haumacher.msgbuf.observer.Observable;

public class GraphObserver implements Listener, ScopeMixin {
	
	private static final Function<? super SharedGraphNode, ? extends Map<String, Command>> NEW_MAP = x -> new HashMap<>();

	private Map<SharedGraphNode, Map<String, Command>> _changes = new HashMap<>();

	private Map<Object, SharedGraphNode> _index = new HashMap<>();

	private Map<Object, Consumer<SharedGraphNode>> _references = new HashMap<>();

	private final ChangeExtractor _extract = new ChangeExtractor();
	private final ChangeApplicator _apply = new ChangeApplicator();

	private int _nextId = 1;

	@Override
	public void beforeSet(Observable obj, String property, Object value) {
		SharedGraphNode node = (SharedGraphNode) obj;
		changes(node).put(property, SetProperty.create().setNode(node).setId(node.id()).setProperty(property));
	}

	@Override
	public void beforeAdd(Observable obj, String property, int index, Object element) {
		SharedGraphNode node = (SharedGraphNode) obj;
		Map<String, Command> changes = changes(node);
		InsertElement insert = InsertElement.create();
		insert.setElement(element).setIndex(index).setNode(node).setId(node.id()).setProperty(property);

		putUpdate(changes, property, insert);
	}
	
	@Override
	public void afterRemove(Observable obj, String property, int index, Object element) {
		SharedGraphNode node = (SharedGraphNode) obj;
		Map<String, Command> changes = changes(node);
		RemoveElement remove = RemoveElement.create();
		remove.setIndex(index).setNode(node).setId(node.id()).setProperty(property);

		putUpdate(changes, property, remove);
	}

	private static void putUpdate(Map<String, Command> changes, String property, ListUpdate update) {
		Command clash = changes.put(property, update);
		if (clash != null) {
			if (clash instanceof SetProperty) {
				// Revert, complete value is updated.
				changes.put(property, clash);
			} else {
				changes.put(property, append((ListUpdate) clash, update));
			}
		}
	}
	
	private static Command append(final ListUpdate clash, ListUpdate update) {
		ListUpdate current = clash;
		ListUpdate next;
		int cnt = 1;
		while (true) {
			next = current.getNext();
			if (next == null) {
				break;
			}
			cnt++;
			if (cnt > 10) {
				// Too many changes, create complete update.
				return SetProperty.create().setNode(update.getNode()).setProperty(update.getProperty());
			}
			current = next;
		}
		current.setNext(update);
		return clash;
	}

	public void writeChanges(JsonWriter json) throws IOException {
		json.beginArray();
		json.beginArray();
		foreachCommand(command -> command.writeTo(json));
		json.endArray();
		
		json.beginArray();
		foreachCommand(command -> command.visit(_extract, json));
		json.endArray();
		json.endArray();
		
		_changes.clear();
	}

	public void readChanges(JsonReader json) throws IOException {
		List<Command> commands = new ArrayList<>(); 
		json.beginArray();
		json.beginArray();
		while (json.hasNext()) {
			commands.add(Command.readCommand(json));
		}
		json.endArray();
		
		json.beginArray();
		for (Command command : commands) {
			command.visit(_apply, json);
		}
		json.endArray();
		json.endArray();
	}

	@Override
	public void enter(AbstractSharedGraphNode node, int id) {
		ScopeMixin.super.enter(node, id);
		
		node.registerListener(this);
	}
	
	/**
	 * TODO
	 */
	final class ChangeExtractor implements Command.Visitor<Void, JsonWriter, IOException> {
		@Override
		public Void visit(SetProperty self, JsonWriter arg) throws IOException {
			String property = self.getProperty();
			SharedGraphNode node = self.getNode();
			node.writeFieldValue(GraphObserver.this, arg, property);
			return null;
		}
		
		@Override
		public Void visit(InsertElement self, JsonWriter arg) throws IOException {
			self.getNode().writeElement(GraphObserver.this, arg, self.getProperty(), self.getElement());
			return null;
		}

		@Override
		public Void visit(RemoveElement self, JsonWriter arg) throws IOException {
			return null;
		}
	}

	final class ChangeApplicator implements Command.Visitor<Void, JsonReader, IOException> {
		@Override
		public Void visit(SetProperty self, JsonReader arg) throws IOException {
			SharedGraphNode target = resolveTarget(self);
			target.readField(GraphObserver.this, arg, self.getProperty());
			return null;
		}

		@Override
		public Void visit(InsertElement self, JsonReader arg) throws IOException {
			SharedGraphNode target = resolveTarget(self);
			Object element = target.readElement(GraphObserver.this, arg, self.getProperty());
			List<Object> value = listValue(self, target);
			value.add(self.getIndex(), element);
			return null;
		}

		@Override
		public Void visit(RemoveElement self, JsonReader arg) throws IOException {
			SharedGraphNode target = resolveTarget(self);
			List<Object> value = listValue(self, target);
			value.remove(self.getIndex());
			return null;
		}

		private SharedGraphNode resolveTarget(Command self) {
			return resolveOrFail(self.getId());
		}

		private List<Object> listValue(ListUpdate self, SharedGraphNode node) {
			@SuppressWarnings("unchecked")
			List<Object> value = (List<Object>) node.get(self.getProperty());
			return value;
		}
	}

	interface Transmission {
		void process(Command command) throws IOException;
	}
	
	private void foreachCommand(Transmission fun) throws IOException {
		for (Map<String, Command> perObject : _changes.values()) {
			for (Command first : perObject.values()) {
				Command command = first;
				fun.process(command);
				if (command instanceof ListUpdate) {
					ListUpdate next = ((ListUpdate) command).getNext();
					while (next != null) {
						fun.process(next);
						next = next.getNext();
					}
				}
			}
		}
	}

	private Map<String, Command> changes(SharedGraphNode obj) {
		return _changes.computeIfAbsent(obj, NEW_MAP);
	}

	@Override
	public int newId() {
		return _nextId++;
	}
	
	@Override
	public Map<Object, SharedGraphNode> index() {
		return _index;
	}

	@Override
	public Map<Object, Consumer<SharedGraphNode>> references() {
		return _references;
	}

}
