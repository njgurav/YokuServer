package com.yoku.server.framework.dto.customer.dashboard;

import java.util.Arrays;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Contains list of nearby merchants
 */
public class NearByMerchantsResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 930647902281105498L;
	
	/**
	 * List of nearby merchants.
	 */
	private NearByMerchantDTO[] merchants;

	/**
	 * @return the merchants
	 */
	public NearByMerchantDTO[] getMerchants() {
		return merchants;
	}

	/**
	 * @param merchants the merchants to set
	 */
	public void setMerchants(NearByMerchantDTO[] merchants) {
		this.merchants = merchants;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NearByMerchantsResponseDTO [merchants=" + Arrays.toString(merchants) + "]";
	}
	
	

}
