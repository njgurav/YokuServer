package com.yoku.server.framework.dto;


public class TransactionStatus extends BaseResponseDTO {

	/**
	 * Generated serial version uid.
	 */
	private static final long serialVersionUID = -1220863465205016748L;

	private String message;

	/**
	 * Current Operation status.
	 */
	private Status status;
	

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public enum Status{
		/**
		 * Success Status
		 */
		SUCCESS, 
		/**
		 * Failed status.
		 */
		FAILURE
		 
	}
	
}
