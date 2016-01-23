package com.yoku.server.exception.messages;

/**
 * Parent class for all Exceptions in the application.
 */
public abstract class BaseException extends Exception {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 8030281991221724202L;

	/**
	 * Initialize parent exception with a message
	 * 
	 * @param message
	 *            exception message/cause
	 */
	public BaseException(String message) {
		super(message);
	}

}
