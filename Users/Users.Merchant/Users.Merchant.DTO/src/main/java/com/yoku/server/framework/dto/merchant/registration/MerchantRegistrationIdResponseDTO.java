package com.yoku.server.framework.dto.merchant.registration;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Provide RegistrationId for performing Merchant Registration step by step.
 * 
 * @author njgurav
 *
 */
public class MerchantRegistrationIdResponseDTO extends BaseResponseDTO {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 8758323415346036753L;
	/**
	 * Registration Id for performing Merchant Registration step by step.
	 */
	private String registrationId;

	/**
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId
	 *            the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}
