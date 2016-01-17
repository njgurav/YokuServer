package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class GorceryProductDetailsResponseDTO extends BaseResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7204699081809216372L;

	/**
	 * Merchant Id for identifying that product id is for given Merchant ID
	 */
	private String merchantId;
	
	/**
	 * Merchant Id for identifying that product id is for given Merchant ID
	 */
	private String productId;

	/**
	 * Product category.
	 */
	private String category;
	
	/**
	 * Product title
	 */
	private String title;
	/**
	 * Product description
	 */
	private String description;
	/**
	 * Product Price per unit.
	 */
	private Double pricePerUnit;
	
	/**
	 * Product subcategory
	 */
	
	private String subCategory;
	
	/**
	 * @return the category
	 */
	
	/**
	 * Measurement Unit
	 */
	private String unit;
	
	/**
	 * Quantity
	 */
	private Double quantity;


	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pricePerUnit
	 */
	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	/**
	 * @param pricePerUnit
	 *            the pricePerUnit to set
	 */
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}


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
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
