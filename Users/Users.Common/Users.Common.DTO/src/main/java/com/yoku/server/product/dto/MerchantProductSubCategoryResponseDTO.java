package com.yoku.server.product.dto;

import java.util.List;

import com.yoku.server.core.dtos.MerchantListingDTO;
import com.yoku.server.core.dtos.MerchantProductSubCategoryDTO;
import com.yoku.server.framework.dto.BaseResponseDTO;

public class MerchantProductSubCategoryResponseDTO extends BaseResponseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3771319732690849766L;
	/**
	 * Serial Version UID.
	 */
	
	List<MerchantProductSubCategoryDTO> merchantProductSubCategoryDTO;

	public List<MerchantProductSubCategoryDTO> getMerchantProductSubCategoryDTO() {
		return merchantProductSubCategoryDTO;
	}

	public void setMerchantProductSubCategoryDTO(
			List<MerchantProductSubCategoryDTO> merchantProductSubCategoryDTO) {
		this.merchantProductSubCategoryDTO = merchantProductSubCategoryDTO;
	}
	
	

}
