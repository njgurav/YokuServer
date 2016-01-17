package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class RestaurantProductDetailsResponseDTO extends BaseResponseDTO {


	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1728063371035411217L;
	
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
	 * Product cuisine.
	 */
	private String cuisine;

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
	
	/**
	 * @return the cuisine
	 */
	public String getCuisine() {
		return cuisine;
	}

	/**
	 * @param cuisine
	 *            the cuisine to set
	 */
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
}
