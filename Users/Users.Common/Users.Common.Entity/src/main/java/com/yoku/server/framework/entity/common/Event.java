package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Event generated in the system to notify users (Merchant, CUstomer and Ninja).
 */
@Entity
@Table(name = "application_events")
public class Event implements IEntity {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1470615361520852976L;

	/**
	 * Primary key for the event table.
	 */
	@EmbeddedId
	private EventKey key;

	/**
	 * Action to perform on occurrence of this event. Actions are to be
	 * specified ',' separated; eg. mail,sms,push which could be easily
	 * separated.
	 */
	@Column(name = "action")
	private String action;

	/**
	 * Messages to be sent to users on occurrence of this event. Messages to be
	 * sent should be separated with ',' in the order of the defined actions in
	 * {@link com.yoku.server.framework.entity.common.Event.action}
	 * 
	 * eg. mail,sms,push --> MAIL10034,SMS10034,PUSH10065
	 */
	@Column(name = "message_id")
	private String message;

	/**
	 * @return the key
	 */
	public EventKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(EventKey key) {
		this.key = key;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
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
		return "Event [key=" + key + ", action=" + action + ", message=" + message + "]";
	}

}
