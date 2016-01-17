package com.yoku.server.framework.dto.customer.registration;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Request DTO for customer registration.
 */
public class CustomerRegistrationRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 8729645967145385793L;

	/**
	 * Identifies customer name
	 */
	private String name;
	
	/**
	 * Identifies customer email Id
	 */
	private String emailId;
	
	/**
	 * Identifies customer mobile number
	 */
	private String mobileNo;
	
	/**
	 * Identifies customer password.
	 */
	private String password;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerRegistrationRequestDTO [name=" + name + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}
	
	
}
