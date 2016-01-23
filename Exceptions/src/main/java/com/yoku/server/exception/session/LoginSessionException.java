package com.yoku.server.exception.session;

/**
 * Generic exception for Login Session faults.
 */
public class LoginSessionException extends Exception {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 2731068392723863408L;

	/**
	 * Initialize parent exception with a message
	 * 
	 * @param message
	 *            exception message/cause
	 */
	public LoginSessionException(String errorMessage) {
		super(errorMessage);
	}
	
	public LoginSessionException(){
		
	}
}
