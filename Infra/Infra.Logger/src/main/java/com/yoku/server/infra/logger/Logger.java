package com.yoku.server.infra.logger;

import java.util.logging.Level;
import java.util.logging.LogManager;

public class Logger extends java.util.logging.Logger implements ILogger {

	private Logger(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}

	public static ILogger getLogger(Class<?> clazz) {
		String name = clazz.getName();
		LogManager m = LogManager.getLogManager();
        Object l = m.getLogger(name);
        if (l == null) m.addLogger(new Logger(name, null));
        l = m.getLogger(name);
        return (Logger) l;
	}

	@Override
	public void info(String message) {
		if(isLoggable(Level.INFO)){
			super.info(message);
		}
	}

	@Override
	public void warning(String message) {
		if(isLoggable(Level.WARNING)){
			super.warning(message);
		}
	}

	public void error(String message, Exception e) {
		// TODO Auto-generated method stub
		
	}

	public void debug(String message) {
		// TODO Auto-generated method stub
		
	}

}
