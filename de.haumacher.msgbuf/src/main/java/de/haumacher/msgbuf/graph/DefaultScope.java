/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

/**
 * The default {@link Scope} of an {@link AbstractSharedGraphNode}.
 * 
 * <p>
 * After adding this instance as {@link SharedGraphNode#registerListener(Listener) listener} to a node, the node is
 * observed for changes. Changes can be externalized to a {@link #createPatch(JsonWriter) patch} and transmitted over
 * network to another {@link DefaultScope} containing a corresponding instance of the node. There, the patch an be
 * {@link #applyChanges(JsonReader) applied} bringing both shared object graphs in sync.
 * </p>
 */
public class DefaultScope implements Listener, ScopeMixin {

	private static final Function<? super SharedGraphNode, ? extends Map<String, Command>> NEW_MAP = x -> new LinkedHashMap<>();

	private Map<SharedGraphNode, Map<String, Command>> _changes = new LinkedHashMap<>();

	private Map<Object, SharedGraphNode> _index = new HashMap<>();

	private final ChangeExtractor _extractor = new ChangeExtractor();

	private final ChangeApplicator _applicator = new ChangeApplicator();

	private int _nextId;

	private int _totalParticipants;

	/**
	 * Whether changes are currently applied. While applying changes, no changes are recorded.
	 */
	private boolean _applying;

	/**
	 * Creates a {@link DefaultScope}.
	 * 
	 * @param totalParticipants
	 *        The total number of participants operating on the shared graph.
	 * @param participantId
	 *        The ID of this participant.
	 */
	public DefaultScope(int totalParticipants, int participantId) {
		_totalParticipants = totalParticipants;
		_nextId = 1 + participantId;
	}

	/**
	 * Creates a {@link DefaultScope} for the server, where the graph is only shared between two participants, the
	 * {@link #newClientInstance() client} and the server.
	 */
	public static DefaultScope newServerInstance() {
		return new DefaultScope(2, 0);
	}

	/**
	 * Creates a {@link DefaultScope} for the client , where the graph is only shared between two participants, the
	 * {@link #newClientInstance() client} and the {@link #newServerInstance() server}.
	 */
	public static DefaultScope newClientInstance() {
		return new DefaultScope(2, 1);
	}

	@Override
	public void beforeSet(Observable obj, String property, Object value) {
		if (_applying) {
			return;
		}
		AbstractSharedGraphNode node = (AbstractSharedGraphNode) obj;
		changes(node).put(property, SetProperty.create().setNode(node).setId(id(node)).setProperty(property));
	}

	@Override
	public void beforeAdd(Observable obj, String property, int index, Object element) {
		if (_applying) {
			return;
		}
		AbstractSharedGraphNode node = (AbstractSharedGraphNode) obj;
		Map<String, Command> changes = changes(node);
		InsertElement insert = InsertElement.create();
		insert.setElement(element).setIndex(index).setNode(node).setId(id(node)).setProperty(property);

		putUpdate(changes, property, insert);
	}

	@Override
	public void afterRemove(Observable obj, String property, int index, Object element) {
		if (_applying) {
			return;
		}
		AbstractSharedGraphNode node = (AbstractSharedGraphNode) obj;
		Map<String, Command> changes = changes(node);
		RemoveElement remove = RemoveElement.create();
		remove.setIndex(index).setNode(node).setId(id(node)).setProperty(property);

		putUpdate(changes, property, remove);
	}

	private static void putUpdate(Map<String, Command> changes, String property,
			ListUpdate update) {
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
				return SetProperty.create().setNode(update.getNode())
						.setProperty(update.getProperty());
			}
			current = next;
		}
		current.setNext(update);
		return clash;
	}
	
	/** 
	 * Checks whether there are changes to create a patch.
	 */
	public boolean hasChanges() {
		return !_changes.isEmpty();
	}

	/** 
	 * Removes all recorded changes.
	 */
	public void dropChanges() {
		_changes.clear();
	}

	/**
	 * Exports recorded changes to the given {@link JsonWriter}.
	 * 
	 * <p>
	 * The recored changes are reset when this method completes.
	 * </p>
	 * 
	 * <p>
	 * The patch is a list containing an entry for each command. Each entry is a
	 * list with the command configuration at position 0 followed by optional
	 * additional arguments for the command.
	 * </p>
	 * 
	 * @see #applyChanges(JsonReader)
	 * @see #hasChanges()
	 */
	public void createPatch(JsonWriter json) throws IOException {
		json.beginArray();
		foreachCommand(command -> {

			json.beginArray();
			command.writeTo(json);
			command.visit(_extractor, json);
			json.endArray();

		});
		json.endArray();

		dropChanges();
	}

	/**
	 * Applies changes read from the given {@link JsonReader}.
	 * 
	 * <p>
	 * It is expected that the patch has the format as in
	 * {@link #createPatch(JsonWriter)}.
	 * </p>
	 * 
	 * @see #createPatch(JsonWriter)
	 */
	public void applyChanges(JsonReader json) throws IOException {
		boolean before = _applying;
		_applying = true;
		try {
			json.beginArray();
			while (json.hasNext()) {
				json.beginArray();
				Command command = Command.readCommand(json);
				command.visit(_applicator, json);
				json.endArray();
			}
			json.endArray();
		} finally {
			_applying = before;
		}
	}
	
	@Override
	public void enter(SharedGraphNode node, int id) {
		ScopeMixin.super.enter(node, id);

		node.registerListener(this);
	}
	
	@Override
	public void readData(SharedGraphNode node, int id, JsonReader in) throws IOException {
		boolean before = _applying;
		_applying = true;
		try {
			ScopeMixin.super.readData(node, id, in);
		} finally {
			_applying = before;
		}
	}

	final class ChangeExtractor implements Command.Visitor<Void, JsonWriter, IOException> {
		@Override
		public Void visit(SetProperty self, JsonWriter arg) throws IOException {
			String property = self.getProperty();
			SharedGraphNode node = self.getNode();
			node.writeFieldValue(DefaultScope.this, arg, property);
			return null;
		}

		@Override
		public Void visit(InsertElement self, JsonWriter arg)
				throws IOException {
			self.getNode().writeElement(DefaultScope.this, arg,
					self.getProperty(), self.getElement());
			return null;
		}

		@Override
		public Void visit(RemoveElement self, JsonWriter arg)
				throws IOException {
			return null;
		}
	}

	final class ChangeApplicator implements Command.Visitor<Void, JsonReader, IOException> {
		@Override
		public Void visit(SetProperty self, JsonReader arg) throws IOException {
			SharedGraphNode target = resolveTarget(self);
			target.readField(DefaultScope.this, arg, self.getProperty());
			return null;
		}

		@Override
		public Void visit(InsertElement self, JsonReader arg)
				throws IOException {
			SharedGraphNode target = resolveTarget(self);
			Object element = target.readElement(DefaultScope.this, arg,
					self.getProperty());
			List<Object> value = listValue(self, target);
			value.add(self.getIndex(), element);
			return null;
		}

		@Override
		public Void visit(RemoveElement self, JsonReader arg)
				throws IOException {
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
	public int id(SharedGraphNode node) {
		return ((AbstractSharedGraphNode) node).id();
	}

	@Override
	public void initId(SharedGraphNode node, int id) {
		((AbstractSharedGraphNode) node).initId(id);
	}

	@Override
	public int newId() {
		int result = _nextId;
		_nextId += _totalParticipants;
		return result;
	}

	@Override
	public Map<Object, SharedGraphNode> index() {
		return _index;
	}

}
