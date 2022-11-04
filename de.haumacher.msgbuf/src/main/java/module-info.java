/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
/**
 * <i>MsgBuf</i> API module.
 */
module de.haumacher.msgbuf {
	exports de.haumacher.msgbuf.binary;
	exports de.haumacher.msgbuf.coder;
	exports de.haumacher.msgbuf.data;
	exports de.haumacher.msgbuf.graph;
	exports de.haumacher.msgbuf.graph.cmd;
	exports de.haumacher.msgbuf.io;
	exports de.haumacher.msgbuf.json;
	exports de.haumacher.msgbuf.observer;
	exports de.haumacher.msgbuf.server.io;
	exports de.haumacher.msgbuf.util;
	exports de.haumacher.msgbuf.xml;
	
	requires transitive java.xml;
}