package com.yoku.server.framework.entity.merchant;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Merchant Entity to Persist into database.
 */
@Entity
@Table(name = "mer_reg_master")
public class Merchant implements IEntity {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -3747671207544989201L;

	/**
	 * Merchant Key
	 */
	@EmbeddedId
	@AttributeOverride(name = "registrationId", column = @Column(name = "registration_id") )
	private MerchantKey key;
	/**
	 * The Id to be assigned to the merchant prior successful registration.
	 */
	@Column(name = "merchant_id")
	private String merchantId;
	/**
	 * Flag indicating if the merchant registration is incomplete.
	 */
	@Column(name = "registration_status")
	private Boolean registrationStatus;
	/**
	 * The Timestamp of merchants last activity of registration. This timestamp
	 * is only for registration process. Should not be used for any other
	 * monitoring activity.
	 */
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;
	/**
	 * The Timestamp when the merchant initiated the registration process.
	 */
	@Column(name = "initiated_on")
	private Timestamp initiatedOn;

	/**
	 * @return the key
	 */
	public MerchantKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(MerchantKey key) {
		this.key = key;
	}

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the registrationStatus
	 */
	public Boolean getRegistrationStatus() {
		return registrationStatus;
	}

	/**
	 * @param registrationStatus
	 *            the registrationStatus to set
	 */
	public void setRegistrationStatus(Boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	/**
	 * @return the lastUpdatedOn
	 */
	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * @param lastUpdatedOn
	 *            the lastUpdatedOn to set
	 */
	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/**
	 * @return the initiatedOn
	 */
	public Timestamp getInitiatedOn() {
		return initiatedOn;
	}

	/**
	 * @param initiatedOn
	 *            the initiatedOn to set
	 */
	public void setInitiatedOn(Timestamp initiatedOn) {
		this.initiatedOn = initiatedOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Merchant [key=" + key + ", merchantId=" + merchantId + ", registrationStatus=" + registrationStatus
				+ ", lastUpdatedOn=" + lastUpdatedOn + ", initiatedOn=" + initiatedOn + "]";
	}

}
