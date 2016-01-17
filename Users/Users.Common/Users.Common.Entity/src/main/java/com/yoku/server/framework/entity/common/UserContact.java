package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

@Entity
@Table(name="tbl_contact")
public class UserContact implements IEntity {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7459459090361040574L;

	/**
	 * Primary key
	 */
	@EmbeddedId
	private UserContactKey key;

	/**
	 * Email Id
	 */
	@Column(name="email")
	private String emailId;
	/**
	 * Current Email Id Verification status
	 */
	@Column(name="email_verified")
	private boolean isEmailVerified;
	/**
	 * Mobile Number
	 */
	@Column(name="mobile")
	private String mobileNo;
	/**
	 * Current Mobile Number Verification status
	 */
	@Column(name="mobile_verified")
	private boolean isMobileNoVerified;
	
	/**
	 * Landline number
	 */
	@Column(name="landline")
	private String landline;
	
	
	/**
	 * @return the landline
	 */
	public String getLandline() {
		return landline;
	}

	/**
	 * @param landline the landline to set
	 */
	public void setLandline(String landline) {
		this.landline = landline;
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
	 * @return the isEmailVerified
	 */
	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	/**
	 * @param isEmailVerified the isEmailVerified to set
	 */
	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
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
	 * @return the isMobileNoVerified
	 */
	public boolean isMobileNoVerified() {
		return isMobileNoVerified;
	}

	/**
	 * @param isMobileNoVerified the isMobileNoVerified to set
	 */
	public void setMobileNoVerified(boolean isMobileNoVerified) {
		this.isMobileNoVerified = isMobileNoVerified;
	}

	/**
	 * @return the key
	 */
	public UserContactKey getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(UserContactKey key) {
		this.key = key;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserContact [key=" + key + ", emailId=" + emailId + ", isEmailVerified=" + isEmailVerified
				+ ", mobileNo=" + mobileNo + ", isMobileNoVerified=" + isMobileNoVerified + ", landline=" + landline
				+ "]";
	}
	
	

}
