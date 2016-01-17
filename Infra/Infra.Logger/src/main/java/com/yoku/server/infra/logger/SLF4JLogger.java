package com.yoku.server.infra.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLogger implements ILogger{
	private  Logger logger;
	private static SLF4JLogger slf4jLogger=new SLF4JLogger();
	
	
	public static SLF4JLogger getLogger(Class<?> clazz){
		slf4jLogger.logger=LoggerFactory.getLogger(clazz);
		return slf4jLogger;
	}

	@Override
	public void info(String message) {
		// TODO Auto-generated method stub
		if(logger.isInfoEnabled()){
			logger.info(message);
		}
		
	}

	@Override
	public void warning(String message) {
		if(logger.isWarnEnabled()){
			logger.info(message);
		}
		
	}

	@Override
	public void error(String message, Exception e) {
		if(logger.isErrorEnabled()){
			logger.error(message, e);;
		}
		
	}

	@Override
	public void debug(String message) {
		if(logger.isDebugEnabled()){
			logger.debug(message);
		}
		
	}

}