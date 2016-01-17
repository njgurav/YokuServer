package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

public class ContactDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Email Id.
	 */
	private String emailId;
	/**
	 * Mobile No.
	 */
	private String mobileNo;
	/**
	 * Phone No.
	 */
	private String phoneNo;

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "ContactDTO [emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", phoneNo=" + phoneNo + "]";
	}

}
