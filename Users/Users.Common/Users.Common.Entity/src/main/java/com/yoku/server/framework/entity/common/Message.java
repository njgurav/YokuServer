package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * The message to sent to users on occurrence of a certain event in the system,
 * be it user specific or system specific.
 */
@Entity
@Table(name = "application_msg")
public class Message implements IEntity {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 4019980879876012887L;

	/**
	 * Primary key for message table
	 */
	@EmbeddedId
	private MessageKey key;

	/**
	 * Message to send to user for specific events. Contains place-holders in
	 * message string that will take actual values.
	 * 
	 * eg. <br>
	 * Action : Mail <br>
	 * Event : Merchant Registration Successful.<br>
	 * Message : <br>
	 * <p>
	 * Hi %%MER_NAME%%, <br>
	 * Your registration with Yoku is Successful. Merchant ID : %%MER_ID%%.
	 * Upload your inventory.....
	 * </p>
	 * 
	 */
	@Column(name = "message")
	private String message;

	/**
	 * @return the key
	 */
	public MessageKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(MessageKey key) {
		this.key = key;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [key=" + key + ", message=" + message + "]";
	}

}
