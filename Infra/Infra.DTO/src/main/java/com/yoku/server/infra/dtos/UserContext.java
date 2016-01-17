package com.yoku.server.infra.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class UserContext implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	private String referenceNumber;
	/**
	 * First Name of the Alert recipient.
	 */
	private String firstName;
	/**
	 * Last Name of the Alert recipient.
	 */
	private String lastName;
	/**
	 * Last login of the Alert recipient.
	 */
	private Date lastLogin;
	/**
	 * Locale of the Alert recipient.
	 */
	private Locale locale;
	/**
	 * Email Id of the Alert recipient.
	 */
	private String emailId;
	/**
	 * Mobile number of the Alert recipient.
	 */
	private String mobileNo;
	/**
	 * Device Id of the Alert recipient.
	 */
	private String deviceId;
	/**
	 * @return the referenceNumber
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}
	/**
	 * @param referenceNumber the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserContext [referenceNumber=" + referenceNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", lastLogin=" + lastLogin + ", locale=" + locale + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", deviceId=" + deviceId + "]";
	}
	
	

	
	

}
