package com.yoku.server.framework.dto.merchant.registration;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Contains message and reference no.
 */
public class MerchantRegistrationResponseDTO extends BaseResponseDTO {
	/**
	 * Serial Version Id.
	 */
	private static final long serialVersionUID = 4790719132028480458L;
	/**
	 * Message stating whether Request is accepted or rejected.
	 */
	private String message;
	/**
	 * Reference number for future reference.
	 */
	private String referenceNo;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo
	 *            the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

}
