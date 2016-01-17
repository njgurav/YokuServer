package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Provide RegistrationId for performing Merchant Registration step by step.
 * 
 * @author njgurav
 *
 */
public class ProductCreateAndRegistrationResponseDTO extends BaseResponseDTO {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 8690285802447517068L;
	/**
	 * Registration Id for performing Merchant Registration step by step.
	 */
	private String productRegistrationId;
	

	/**
	 * Merchant Id for identifying that product id is for given Merchant ID
	 */
	private String merchantId;
	
	/**
	 * Business Category for identifying that product id is for given Merchant ID
	 */
	private String businessCategory;



	/**
	 * @return the registrationId
	 */
	public String getProductRegistrationId() {
		return productRegistrationId;
	}
	
	/**
	 * @return the businessCategory
	 */
	public String getMerchantId() {
		return merchantId;
	}
	

	/**
	 * @return the merchantId
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}


	/**
	 * @param registrationId
	 *            the registrationId to set
	 */
	public void setProductRegistrationId(String productRegistrationId) {
		this.productRegistrationId = productRegistrationId;
	}
	
	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	/**
	 * @param businessCategory
	 *            the businessCategory to set
	 */
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

}
