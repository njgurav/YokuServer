package com.yoku.server.exception.session;

import com.yoku.server.exception.messages.ExceptionMessages;

/**
 * Exception to be raised when Login is essential.
 */
public class MandatoryLoginException extends LoginSessionException {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7912470062062201986L;

	/**
	 * Error message to display when a service is accessed which requires login.
	 */
	private static String errorMessage = ExceptionMessages.PLEASE_LOGIN;

	/**
	 * The user type that raised this exception.
	 */
	private String userType;

	/**
	 * Default constructor declared private. Cannot initialize this exception
	 * without userType.
	 */
	@SuppressWarnings("unused")
	private MandatoryLoginException() {
	}

	/**
	 * Cannot initialize this exception without userType.
	 * 
	 * @param userType UserType that caused this exception.
	 */
	public MandatoryLoginException(String userType) {
		super(errorMessage);
		this.userType = userType;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MandatoryLoginException [errorMessage=" + errorMessage + ", userType=" + userType + "]";
	}

}
