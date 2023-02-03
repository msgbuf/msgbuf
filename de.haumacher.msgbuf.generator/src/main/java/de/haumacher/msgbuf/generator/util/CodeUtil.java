/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.util;

import java.util.regex.Pattern;

/**
 * Utilities for code generation.
 */
public class CodeUtil {
	
	private static final String QUOTE = "\"";

	private static final Pattern NAME_PART_PATTERN = Pattern.compile(
		"(?<=\\p{javaLowerCase})(?=\\p{javaUpperCase})" + "|" + 
		"(?<=\\p{javaLetter})(?=\\p{javaDigit})" + "|" + 
		"(?<=\\p{javaDigit})(?=\\p{javaLetter})" + "|" + 
		"_+");

	/**
	 * Converts the given '_' separated string to <code>CamelCase</code>.
	 */
	public static String camelCase(String name) {
		StringBuilder result = new StringBuilder();
		for (String part : name.split("_+")) {
			result.append(firstUpperCase(part));
		}
		return result.toString();
	}

	/**
	 * Converts a camel-case name to a name where parts are separated by '_'.
	 */
	public static String underscored(String name) {
		StringBuilder result = new StringBuilder();
		for (String part : name.split("(?<=\\p{javaLowerCase})(?=\\p{javaUpperCase})")) {
			if (result.length() > 0) {
				result.append('_');
			}
			result.append(part.toLowerCase());
		}
		return result.toString();
	}
	
	/**
	 * Makes the first character upper-case in the given string.
	 */
	public static String firstUpperCase(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	/**
	 * Converts a <code>CamelCase</code> name into a '_' separated name in all upper case.
	 */
	public static String allUpperCase(String name) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (String part : NAME_PART_PATTERN.split(name)) {
			if (first) {
				first = false;
			} else {
				result.append('_');
			}
			result.append(part.toUpperCase());
		}
		return result.toString();
	}
	
	/**
	 * Converts a <code>CamelCase</code> name into a '-' separated name in all lower case.
	 */
	public static String xmlName(String name) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (String part : NAME_PART_PATTERN.split(name)) {
			if (first) {
				first = false;
			} else {
				result.append('-');
			}
			result.append(part.toLowerCase());
		}
		return result.toString();
	}

	/**
	 * Makes the first character lower-case in the given string.
	 */
	public static String firstLowerCase(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}

	/** 
	 * A Java string literal with the given value.
	 */
	public static String stringLiteral(String str) {
		return QUOTE + str.replace("\\", "\\\\").replace(QUOTE, "\\" + QUOTE) + QUOTE;
	}

}
