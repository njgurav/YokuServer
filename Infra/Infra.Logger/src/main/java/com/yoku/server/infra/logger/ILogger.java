package com.yoku.server.infra.logger;

public interface ILogger{

	public void info(String message);

	public void warning(String message);
	
	public void error(String message, Exception e);
	
	public void debug(String message);
}
