package com.yoku.server.core.dtos;

import com.yoku.server.framework.dto.BaseDTO;

public class MerchantListingDTO extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1725892774583721692L;

	/**
	 * Product ID
	 */
	private String productID;

	/**
	 * Total number of product for the given merchant
	 */
	private double productCount;
	
	/**
	 * Title of the product
	 */
	private String title;
	
	/**
	 * Price of the product
	 */
	private double price;
	
	/**
	 * URL for the product Image
	 */
	String iconURL;

	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}


	/**
	 * @return the productCount
	 */
	public double getProductCount() {
		return productCount;
	}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	
	/**
	 * @return the iconURL
	 */
	public String getIconURL() {
		return iconURL;
	}

	
	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}

	/**
	 * @param productCount
	 *            the productCount to set
	 */
	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param iconURL
	 *            the iconURL to set
	 */
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	
	

}
