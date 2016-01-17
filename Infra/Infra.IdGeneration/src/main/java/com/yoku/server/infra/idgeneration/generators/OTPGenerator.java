package com.yoku.server.infra.idgeneration.generators;

import java.util.Random;

/**
 * OTP Generator.
 */
public class OTPGenerator {
	/**
	 * OTP length
	 */
	private int OTPLength = 6;

	/**
	 * private static instance
	 */
	private static OTPGenerator instance;

	/**
	 * Private constructor
	 */
	private OTPGenerator() {
	}

	/**
	 * Initializing OTPGenerator using singleton pattern.
	 * 
	 * @return OTPGenerator instance.
	 */
	public static OTPGenerator getInstance() {
		if (instance == null) {
			synchronized (OTPGenerator.class) {
				if (instance == null) {
					instance = new OTPGenerator();
				}
			}
		}
		return instance;
	}

	/**
	 * Generate OTP method.
	 */
	public Integer nextOTPKey() {
		StringBuilder otpBuilder = new StringBuilder();
		for (int i = 0; i < OTPLength; i++) {
			otpBuilder.append(new Integer(new Random().nextInt(9)).toString());
		}
		return Integer.parseInt(otpBuilder.toString());
	}
}
