package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * OTP key
 */
@Embeddable
public class OTPKey implements IEntityKey {

	/**
	 * Serial Version UID. 
	 */
	private static final long serialVersionUID = -6004667524860418013L;
	/**
	 * The mobile number to send otp to.
	 */
	@Column(name="mobile_no")
	private String mobileNo;
	/**
	 * The OTP value to store in the db for validation.
	 */
	@Column(name="otp_val")
	private Integer otpVal;
	

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

	/**
	 * @return the otpVal
	 */
	public Integer getOtpVal() {
		return otpVal;
	}

	/**
	 * @param otpVal
	 *            the otpVal to set
	 */
	public void setOtpVal(Integer otpVal) {
		this.otpVal = otpVal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OTPKey [mobileNo=" + mobileNo + ", otpVal=" + otpVal + "]";
	}

	

}
