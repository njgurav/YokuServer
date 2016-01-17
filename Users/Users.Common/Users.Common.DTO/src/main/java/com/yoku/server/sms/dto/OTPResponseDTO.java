package com.yoku.server.sms.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * OTP response DTO containing validation status.
 */
public class OTPResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 2022572885282614390L;

	/**
	 * Key to generate OTP on the client.
	 */
	private String guild;

	/**
	 * Temporary field OTP public key. Henceforth to be sent in SMS.
	 */
	private String otpkey;

	/**
	 * @return the otpkey
	 */
	public String getOtpkey() {
		return otpkey;
	}

	/**
	 * @param otpkey the otpkey to set
	 */
	public void setOtpkey(String otpkey) {
		this.otpkey = otpkey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OTPResponseDTO [guild=" + guild + "]";
	}

	/**
	 * @return the key
	 */
	public String getGuild() {
		return guild;
	}

	/**
	 * @param guild
	 *            the key to set
	 */
	public void setGuild(String guild) {
		this.guild = guild;
	}

}
