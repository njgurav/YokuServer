package com.yoku.server.sms.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * OTP validation Request DTO.
 */
public class OTPValidateRequestDTO extends BaseRequestDTO {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -8220428873171400299L;
	/**
	 * String mobile number
	 */
	private String mobileNo;
	/**
	 * The OTP value sent for this mobile number.
	 */
	private Integer otp;
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
	 * @return the otp
	 */
	public Integer getOtp() {
		return otp;
	}
	/**
	 * @param otp the otp to set
	 */
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OTPValidateRequestDTO [mobileNo=" + mobileNo + ", otp=" + otp + "]";
	}
	
}
