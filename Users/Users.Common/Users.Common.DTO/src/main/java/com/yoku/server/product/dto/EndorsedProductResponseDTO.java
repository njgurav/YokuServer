package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class EndorsedProductResponseDTO extends BaseResponseDTO{
	
	private String businessCategory;
	
	private String merchantID;

	public String getBusinessCategory() {
		return businessCategory;
	}
	
	public String getMerchantID() {
		return merchantID;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}	

}
