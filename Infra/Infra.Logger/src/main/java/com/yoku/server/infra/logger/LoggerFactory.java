package com.yoku.server.infra.logger;
public final class LoggerFactory {
	
	public static ILogger getLogger(Class<?> clazz){
		return SLF4JLogger.getLogger(clazz);
	}

}
