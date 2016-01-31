package com.yoku.server.framework.dto.customer.dashboard;

import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsResponseDTO;

/**
 * Contains data of the merchant that reside within a specified radius from a
 * particular location.
 */
public class NearByMerchantDTO extends BaseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 930647902281105498L;

	/**
	 * Merchant details that are sent to client when nearby merchant data is
	 * requested.
	 */
	private MerchantPrimaryDetailsResponseDTO merchant;

	/**
	 * MerchantId of the merchant that lies within the radius.
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

	/**
	 * @return the merchants
	 */
	public MerchantPrimaryDetailsResponseDTO getMerchants() {
		return merchant;
	}

	/**
	 * @param merchants
	 *            the merchants to set
	 */
	public void setMerchants(MerchantPrimaryDetailsResponseDTO merchants) {
		this.merchant = merchants;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NearByMerchantDTO [merchants=" + merchant + ", merchantId=" + merchantId + "]";
	}

}
