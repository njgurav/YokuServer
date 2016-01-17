package com.yoku.server.framework.entity.merchant;

import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Merchant DO key.
 */
@Embeddable
public class MerchantKey implements IEntityKey {
	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 7188135784901052047L;
	
	/**
	 * Registration Id.
	 */
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
}
