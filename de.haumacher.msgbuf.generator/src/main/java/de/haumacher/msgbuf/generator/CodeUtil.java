/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.regex.Pattern;

/**
 * Utilities for code generation.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class CodeUtil {
	
	private static final Pattern NAME_PART_PATTERN = Pattern.compile(
		"(?<=\\p{javaLowerCase})(?=\\p{javaUpperCase})" + "|" + 
		"(?<=\\p{javaLetter})(?=\\p{javaDigit})" + "|" + 
		"(?<=\\p{javaDigit})(?=\\p{javaLetter})" + "|" + 
		"_+");


	public static String camelCase(String name) {
		StringBuilder result = new StringBuilder();
		for (String part : name.split("_+")) {
			result.append(firstUpperCase(part));
		}
		return result.toString();
	}

	public static String firstUpperCase(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

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

	public static String firstLowerCase(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}

}
