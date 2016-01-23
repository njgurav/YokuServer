package com.yoku.server.exception.session;

import com.yoku.server.exception.messages.ExceptionMessages;
/**
 * Raise when request does not contain login data in the headers.
 */
public class InvalidLoginHeadersException extends LoginSessionException {
	
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7912470062062201986L;

	/**
	 * Error message to display when a service is accessed which requires login.
	 */
	private static String errorMessage = ExceptionMessages.EMPTY_HEADERS;

	/**
	 * Default constructor.
	 */
	public InvalidLoginHeadersException(){
		super(errorMessage);
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InvalidLoginHeaders [errorMessage=" + errorMessage + "]";
	}

	
	
}
