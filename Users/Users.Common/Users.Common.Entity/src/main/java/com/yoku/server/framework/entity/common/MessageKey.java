package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Primary Key for message table.
 */
@Embeddable
public class MessageKey implements IEntityKey {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 4289870226351860354L;
	
	/**
	 * Message Id
	 */
	@Column(name = "message_id")
	private String messageId;

	/**
	 * Language Id
	 */
	@Column(name = "locale")
	private String languageId;
	

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}


	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}


	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageKey [messageId=" + messageId + ", languageId=" + languageId + "]";
	}
	
}
