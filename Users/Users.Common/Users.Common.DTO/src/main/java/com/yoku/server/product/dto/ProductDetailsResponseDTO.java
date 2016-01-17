package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class ProductDetailsResponseDTO extends BaseResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7168154070501043933L;
	/**
	 * Serial Version UID.
	 */

	/**
	 * Merchant Id for identifying that product id is for given Merchant ID
	 */
	private String merchantId;


	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}
