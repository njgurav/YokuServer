package com.yoku.server.product.dto;

import java.util.List;

import com.yoku.server.core.dtos.MerchantListingDTO;
import com.yoku.server.core.dtos.MerchantProductSubCategoryDTO;
import com.yoku.server.framework.dto.BaseResponseDTO;

public class MerchantProductListingResponseDTO extends BaseResponseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2716602690794879143L;
	/**
	 * Serial Version UID.
	 */
	
	List<MerchantListingDTO> merchantListing;

	public List<MerchantListingDTO> getMerchantListing() {
		return merchantListing;
	}

	public void setMerchantListing(List<MerchantListingDTO> merchantListing) {
		this.merchantListing = merchantListing;
	}

}
