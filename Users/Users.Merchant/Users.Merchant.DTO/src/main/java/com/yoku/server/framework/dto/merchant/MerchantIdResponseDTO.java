package com.yoku.server.framework.dto.merchant;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Contains MerchantId
 */
public class MerchantIdResponseDTO extends BaseResponseDTO {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -5732149059106985235L;

	/**
	 * Constructor
	 */
	public MerchantIdResponseDTO() {
	}

	/**
	 * MerchantId
	 */
	private String merchantId;
	/**
	 * Merchant Name
	 */
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the merchnatId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchnatId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MerchantIdResponseDTO [merchantId=" + merchantId + ", name=" + name + "]";
	}

}
