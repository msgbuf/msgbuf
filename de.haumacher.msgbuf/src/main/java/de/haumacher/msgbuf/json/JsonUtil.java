/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.io.StringW;
import de.haumacher.msgbuf.json.value.JsonArray;
import de.haumacher.msgbuf.json.value.JsonBoolean;
import de.haumacher.msgbuf.json.value.JsonDouble;
import de.haumacher.msgbuf.json.value.JsonLong;
import de.haumacher.msgbuf.json.value.JsonNull;
import de.haumacher.msgbuf.json.value.JsonObject;
import de.haumacher.msgbuf.json.value.JsonString;
import de.haumacher.msgbuf.json.value.JsonValue;

/**
 * Utilities for reading and writing JSON.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class JsonUtil {
	
	/**
	 * Reads a string or a <code>null</code> value from the given reader.
	 */
	public static String nextStringOptional(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		
		return in.nextString();
	}

	/**
	 * Reads a byte array or a <code>null</code> value from the given reader.
	 */
	public static byte[] nextBinaryOptional(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		
		return Base64Utils.fromBase64(in.nextString());
	}
	
	/**
	 * Writes the given byte array as Base64 encoded string.
	 */
	public static void writeBinaryOptional(JsonWriter out, byte[] value) throws IOException {
		if (value == null) {
			out.nullValue();
		} else {
			out.value(Base64Utils.toBase64(value));
		}
	}

	/**
	 * Reads any JSON value and returns it as a Java object.
	 *
	 * <ul>
	 * <li>JSON object &rarr; {@link Map}&lt;String, Object&gt;</li>
	 * <li>JSON array &rarr; {@link List}&lt;Object&gt;</li>
	 * <li>JSON string &rarr; {@link String}</li>
	 * <li>JSON number &rarr; {@link Long} or {@link Double}</li>
	 * <li>JSON boolean &rarr; {@link Boolean}</li>
	 * <li>JSON null &rarr; {@code null}</li>
	 * </ul>
	 */
	@SuppressWarnings("unchecked")
	public static Object nextJsonValue(JsonReader in) throws IOException {
		JsonToken token = in.peek();
		switch (token) {
			case BEGIN_OBJECT: {
				Map<String, Object> map = new LinkedHashMap<>();
				in.beginObject();
				while (in.hasNext()) {
					String key = in.nextName();
					Object value = nextJsonValue(in);
					map.put(key, value);
				}
				in.endObject();
				return map;
			}
			case BEGIN_ARRAY: {
				List<Object> list = new ArrayList<>();
				in.beginArray();
				while (in.hasNext()) {
					list.add(nextJsonValue(in));
				}
				in.endArray();
				return list;
			}
			case STRING:
				return in.nextString();
			case NUMBER: {
				String raw = in.nextString();
				if (raw.indexOf('.') >= 0 || raw.indexOf('e') >= 0 || raw.indexOf('E') >= 0) {
					return Double.valueOf(raw);
				}
				try {
					return Long.valueOf(raw);
				} catch (NumberFormatException e) {
					return Double.valueOf(raw);
				}
			}
			case BOOLEAN:
				return Boolean.valueOf(in.nextBoolean());
			case NULL:
				in.nextNull();
				return null;
			default:
				throw new IOException("Unexpected JSON token: " + token);
		}
	}

	/**
	 * Writes a Java object as a JSON value.
	 *
	 * @param out The JSON writer.
	 * @param value The value to write (may be {@code null}, {@link Map}, {@link List}, {@link String},
	 *              {@link Number}, or {@link Boolean}).
	 */
	@SuppressWarnings("unchecked")
	public static void writeJsonValue(JsonWriter out, Object value) throws IOException {
		if (value == null) {
			out.nullValue();
		} else if (value instanceof Map) {
			out.beginObject();
			for (Map.Entry<String, Object> entry : ((Map<String, Object>) value).entrySet()) {
				out.name(entry.getKey());
				writeJsonValue(out, entry.getValue());
			}
			out.endObject();
		} else if (value instanceof List) {
			out.beginArray();
			for (Object element : (List<Object>) value) {
				writeJsonValue(out, element);
			}
			out.endArray();
		} else if (value instanceof String) {
			out.value((String) value);
		} else if (value instanceof Boolean) {
			out.value(((Boolean) value).booleanValue());
		} else if (value instanceof Number) {
			out.value((Number) value);
		} else {
			throw new IOException("Cannot serialize to JSON: " + value.getClass().getName());
		}
	}

	/**
	 * Converts a plain Java object to a {@link JsonValue} envelope for binary/XML serialization.
	 *
	 * @param value A Java object ({@code null}, {@link Map}, {@link List}, {@link String},
	 *              {@link Number}, or {@link Boolean}).
	 * @return The corresponding {@link JsonValue} envelope.
	 */
	@SuppressWarnings("unchecked")
	public static JsonValue toJsonValue(Object value) {
		if (value == null) {
			return JsonNull.create();
		} else if (value instanceof Map) {
			JsonObject obj = JsonObject.create();
			for (Map.Entry<String, Object> entry : ((Map<String, Object>) value).entrySet()) {
				obj.putEntry(entry.getKey(), toJsonValue(entry.getValue()));
			}
			return obj;
		} else if (value instanceof List) {
			JsonArray arr = JsonArray.create();
			for (Object element : (List<Object>) value) {
				arr.addElement(toJsonValue(element));
			}
			return arr;
		} else if (value instanceof String) {
			return JsonString.create().setValue((String) value);
		} else if (value instanceof Boolean) {
			return JsonBoolean.create().setValue(((Boolean) value).booleanValue());
		} else if (value instanceof Long || value instanceof Integer || value instanceof Short || value instanceof Byte) {
			return JsonLong.create().setValue(((Number) value).longValue());
		} else if (value instanceof Number) {
			return JsonDouble.create().setValue(((Number) value).doubleValue());
		} else {
			throw new IllegalArgumentException("Cannot convert to JsonValue: " + value.getClass().getName());
		}
	}

	/**
	 * Converts a {@link JsonValue} envelope back to a plain Java object.
	 *
	 * @param value The {@link JsonValue} envelope.
	 * @return The corresponding Java object ({@code null}, {@link Map}, {@link List}, {@link String},
	 *         {@link Long}, {@link Double}, or {@link Boolean}).
	 */
	public static Object fromJsonValue(JsonValue value) {
		if (value == null) {
			return null;
		}
		switch (value.kind()) {
			case JSON_NULL:
				return null;
			case JSON_STRING:
				return ((JsonString) value).getValue();
			case JSON_LONG:
				return Long.valueOf(((JsonLong) value).getValue());
			case JSON_DOUBLE:
				return Double.valueOf(((JsonDouble) value).getValue());
			case JSON_BOOLEAN:
				return Boolean.valueOf(((JsonBoolean) value).isValue());
			case JSON_ARRAY: {
				List<Object> list = new ArrayList<>();
				for (JsonValue element : ((JsonArray) value).getElements()) {
					list.add(fromJsonValue(element));
				}
				return list;
			}
			case JSON_OBJECT: {
				Map<String, Object> map = new LinkedHashMap<>();
				for (Map.Entry<String, JsonValue> entry : ((JsonObject) value).getEntries().entrySet()) {
					map.put(entry.getKey(), fromJsonValue(entry.getValue()));
				}
				return map;
			}
			default:
				throw new IllegalArgumentException("Unknown JsonValue kind: " + value.kind());
		}
	}

	/**
	 * Converts a Java object to its JSON string representation.
	 * Used for encoding JSON values in binary and XML formats.
	 */
	public static String jsonStringValue(Object value) {
		if (value == null) {
			return "null";
		}
		try {
			StringW buffer = new StringW();
			JsonWriter writer = new JsonWriter(buffer);
			writer.setLenient(true);
			writeJsonValue(writer, value);
			return buffer.toString();
		} catch (IOException e) {
			throw new RuntimeException("Failed to serialize JSON value.", e);
		}
	}

	/**
	 * Parses a JSON string into a Java object.
	 * Used for decoding JSON values from binary and XML formats.
	 */
	public static Object parseJsonValue(String json) {
		if (json == null) {
			return null;
		}
		try {
			JsonReader reader = new JsonReader(new StringR(json));
			reader.setLenient(true);
			return nextJsonValue(reader);
		} catch (IOException e) {
			throw new RuntimeException("Failed to parse JSON value: " + json, e);
		}
	}

}
