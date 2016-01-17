package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Primary key for Event
 */
@Embeddable
public class EventKey implements IEntityKey {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2448528997064761425L;
	/**
	 * Event Id
	 */
	@Column(name = "event_id")
	private String eventId;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventKey [eventId=" + eventId + "]";
	}

	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

}
