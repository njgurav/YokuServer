package com.yoku.server.framework.entity.customer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Key for Customer Registration Entity.
 */
@Embeddable
public class CustomerKey implements IEntityKey {

	/**
	 * Serial Verison UID
	 */
	private static final long serialVersionUID = 6740609763419267111L;
		
	/**
	 * Registration ID
	 */
	@Column(name="registration_id")
	private String registrationId;

	/**
	 * @return the registrationId
	 */
	
	public String getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerKey [registrationId=" + registrationId + "]";
	}
	
	
	
}
