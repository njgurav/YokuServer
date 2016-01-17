package com.yoku.server.framework.entity.merchant;

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
@Table(name = "mer_reg_primary")
public class MerchantPrimaryDetails implements IEntity {

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
	 * Merchant company name.
	 */
	@Column(name = "company_name")
	private String companyName;
	/**
	 * Merchant email id.
	 */
	@Column(name = "email_id")
	private String emailId;
	/**
	 * Password to access application.
	 */
	@Column(name = "password")
	private String password;
	/**
	 * Merchant phone number.
	 */
	@Column(name = "phone_number")
	private String phoneNumber;
	/**
	 * Merchant business type.
	 */
	@Column(name = "business_type")
	private String businessType;

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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType
	 *            the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MerchantPrimaryDetails [key=" + key + ", companyName=" + companyName + ", emailId=" + emailId
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", businessType=" + businessType + "]";
	}

}
