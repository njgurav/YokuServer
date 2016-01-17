package com.yoku.server.sms.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * SMS OTP Request DTO
 */
public class OTPRequestDTO extends BaseRequestDTO {
	/**
	 * Mobile number to send OTP to.
	 */
	private String mobileNo;
	/**
	 * The device Id to send additional validation information if required.
	 */
	private String deviceId;
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
		return "OTPRequestDTO [mobileNo=" + mobileNo + ", deviceId=" + deviceId + "]";
	}
	
	

}
