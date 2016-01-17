package com.yoku.server.infra.validation.validators;

/**
 * Validation Error class representing the data of the culprit that failed
 * validation and appropriate message.
 */
public class ValidationError {
	/**
	 * Why validation failed and appropriate message.
	 */
	private String cause;
	/**
	 * The String representation of the object that failed to be validated
	 */
	private String failedFor;

	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * @param cause
	 *            the cause to set
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}

	/**
	 * @return the failedFor
	 */
	public String getFailedFor() {
		return failedFor;
	}

	/**
	 * @param failedFor
	 *            the failedFor to set
	 */
	public void setFailedFor(String failedFor) {
		this.failedFor = failedFor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ValidationError [cause=" + cause + ", failedFor=" + failedFor + "]";
	}

}
