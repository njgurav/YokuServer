package com.yoku.server.framework.dto.merchant.registration;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class MerchantPrimaryDetailsResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 5749174506702586461L;
	/**
	 * Merchant company name.
	 */
	private String companyName;
	/**
	 * Merchant email id.
	 */
	private String emailId;
	/**
	 * Password to access application.
	 */
	private String password;
	/**
	 * Merchant phone number.
	 */
	private String phoneNumber;
	/**
	 * Merchant business type.
	 */
	private String businessType;
	/**
	 * For Logging
	 */
	@Override
	public String toString() {
		return "MerchantPrimaryDetailsRequestDTO [companyName=" + companyName + ", emailId=" + emailId + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", businessType=" + businessType + "]";
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
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
	 * @param emailId the emailId to set
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
	 * @param password the password to set
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
	 * @param phoneNumber the phoneNumber to set
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
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	
	
}
