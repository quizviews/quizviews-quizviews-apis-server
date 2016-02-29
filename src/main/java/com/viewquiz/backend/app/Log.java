package com.viewquiz.backend.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Log {

	private Log() {
	}

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";

	private static final Logger logger = LoggerFactory.getLogger(ViewQuizBackEndApplication.class);

	// logger.error("Message logged at ERROR level");
	// logger.warn("Message logged at WARN level");
	// logger.info("Message logged at INFO level");
	// logger.debug("Message logged at DEBUG level");

	public static void E(Object msg) {
		if (msg != null) {
			logger.error(ANSI_RED + msg.toString() + ANSI_RESET);
		} else {
			logger.error(ANSI_RED + "NULL" + ANSI_RESET);
		}
	}

	public static void W(Object msg) {
		if (msg != null) {
			logger.warn(ANSI_PURPLE + msg.toString() + ANSI_RESET);
		} else {
			logger.warn(ANSI_PURPLE + "NULL" + ANSI_RESET);
		}

	}

	public static void I(Object msg) {
		if (msg != null) {
			logger.info(ANSI_BLUE + msg.toString() + ANSI_RESET);
		} else {
			logger.info(ANSI_BLUE + "NULL" + ANSI_RESET);
		}
	}

	public static void D(Object msg) {
		if (msg != null) {
			logger.debug(ANSI_GREEN + msg.toString() + ANSI_RESET);
		} else {
			logger.debug(ANSI_GREEN + "NULL" + ANSI_RESET);
		}
	}
}
