package com.yoku.server.core.dtos;

import com.yoku.server.framework.dto.BaseDTO;

public class MerchantProductSubCategoryDTO extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2175708160757572151L;

	/**
	 * Businness Category
	 */
	private String businessCategory;

	/**
	 * Sub Category
	 */
	private String subCategory;
	
	/**
	 * Sub Category
	 */
	private String dimesion;

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getDimesion() {
		return dimesion;
	}

	public void setDimesion(String dimesion) {
		this.dimesion = dimesion;
	}
	
	
	

}
