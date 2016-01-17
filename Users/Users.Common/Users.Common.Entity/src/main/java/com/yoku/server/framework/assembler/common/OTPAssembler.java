package com.yoku.server.framework.assembler.common;

import com.yoku.server.framework.entity.common.OTP;
import com.yoku.server.framework.entity.common.OTPKey;

/**
 * OTP assembler
 */
public class OTPAssembler {

	/**
	 * Create OTP Entity.
	 * 
	 * @param mobileNo
	 *            To generate OTP for.
	 * @param otpVal
	 *            OTP value generated.
	 * @param otpKey
	 *            OTP public key sent to client.
	 * @param duration
	 *            otp expiry timeout in seconds.
	 * @return {@link OTP} entity
	 */
	public OTP toEntity(String mobileNo, Integer otpVal, Integer otpKey, Integer duration) {
		OTP otp = new OTP();
		OTPKey key = new OTPKey();

		key.setMobileNo(mobileNo);
		key.setOtpVal(otpVal);
		otp.setOtpKey(otpKey);

		otp.setDuration(duration);

		return otp;
	}

}
