/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.common;

/**
 * Utility for processing JavaDoc-style inline tags (<code>{@literal {@tag content}}</code>) in
 * documentation comments of protocol definitions.
 */
public class DocTags {

	/**
	 * Callback computing the replacement of an inline tag.
	 */
	public interface TagReplacement {

		/**
		 * Computes the replacement text for an inline tag.
		 *
		 * @param tag
		 *        The tag name without <code>@</code>, e.g. <code>link</code>.
		 * @param content
		 *        The text after the tag name, with surrounding white space removed.
		 * @return The replacement text, or <code>null</code> to keep the tag unchanged.
		 */
		String replace(String tag, String content);
	}

	/**
	 * Replaces all inline tags in the given comment.
	 *
	 * <p>
	 * Braces within the tag content are matched, so <code>{@literal {@code {a: 1}}}</code> is a
	 * single tag. An unterminated tag is kept unchanged.
	 * </p>
	 */
	public static String replaceInlineTags(String comment, TagReplacement replacement) {
		if (comment == null || comment.indexOf("{@") < 0) {
			return comment;
		}
		StringBuilder result = new StringBuilder();
		int pos = 0;
		int length = comment.length();
		while (pos < length) {
			int start = comment.indexOf("{@", pos);
			if (start < 0) {
				break;
			}
			int end = closingBrace(comment, start);
			if (end < 0) {
				break;
			}
			result.append(comment, pos, start);

			int nameStart = start + 2;
			int nameEnd = nameStart;
			while (nameEnd < end && Character.isLetterOrDigit(comment.charAt(nameEnd))) {
				nameEnd++;
			}
			String tag = comment.substring(nameStart, nameEnd);
			String content = comment.substring(nameEnd, end).trim();
			String replaced = tag.isEmpty() ? null : replacement.replace(tag, content);
			result.append(replaced == null ? comment.substring(start, end + 1) : replaced);

			pos = end + 1;
		}
		result.append(comment, pos, length);
		return result.toString();
	}

	private static int closingBrace(String comment, int start) {
		int depth = 0;
		for (int n = start, cnt = comment.length(); n < cnt; n++) {
			char ch = comment.charAt(n);
			if (ch == '{') {
				depth++;
			} else if (ch == '}') {
				depth--;
				if (depth == 0) {
					return n;
				}
			}
		}
		return -1;
	}

}
