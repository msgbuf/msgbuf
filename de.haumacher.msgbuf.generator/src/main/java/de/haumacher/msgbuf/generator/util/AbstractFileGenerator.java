/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.util;

import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Base class for code generators.
 */
public abstract class AbstractFileGenerator implements FileGenerator {

	private static final String NL;

	private static final String INDENT = "\t";
	
	static {
		StringWriter out = new StringWriter();
		try (PrintWriter p = new PrintWriter(out)) {
			p.println();
		}
		NL = out.toString();
	}
	
	private Appendable _out;
	
	private int _indent = 0;

	@Override
	public void generate(Appendable out) {
		_out = out;
		try {
			generate();
		} finally {
			_out = null;
		}
	}
	
	/**
	 * Generates the contents as inner class of the given outer generator.
	 */
	public void generateInner(AbstractFileGenerator outer) {
		setIndent(outer.getIndent());
		generate(outer._out);
	}

	/**
	 * The current indentation level.
	 */
	public int getIndent() {
		return _indent;
	}
	
	private void setIndent(int indent) {
		_indent = indent;
	}

	protected abstract void generate();
	
	protected abstract void docComment(String comment);

	protected void line(String line) {
		lineStart(line);
		nl();
	}

	protected void lineStart(String line) {
		int closing = countClose(line);
		int delta = countDelta(line);
		
		_indent += closing;
		for (int n = 0; n < _indent; n++) {
			internalAppend(INDENT);
		}
		_indent += delta - closing;
		internalAppend(line);
	}

	protected void append(String part) {
		internalAppend(part);
		_indent+=countDelta(part);
	}
	
	private void internalAppend(String part) {
		try {
			_out.append(part);
		} catch (IOException ex) {
			throw new IOError(ex);
		}
	}

	private int countDelta(String line) {
		int result = 0;
		for (int n = 0, cnt = line.length(); n < cnt; n++) {
			switch (line.charAt(n)) {
			case '(':
			case '[':
			case '{':
				result++;
				break;
			case ')':
			case ']':
			case '}':
				result--;
				break;
			}
		}
		return result;
	}

	private int countClose(String line) {
		int result = 0;
		for (int n = 0, cnt = line.length(); n < cnt; n++) {
			switch (line.charAt(n)) {
			case ')':
			case ']':
			case '}':
				result--;
				break;
			case '(':
			case '[':
			case '{':
				return result;
			}
		}
		return result;
	}
	
	protected void nl() {
		internalAppend(NL);
	}
}
