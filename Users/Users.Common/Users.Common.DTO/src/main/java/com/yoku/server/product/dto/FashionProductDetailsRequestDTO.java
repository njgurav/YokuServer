package com.yoku.server.product.dto;

import com.yoku.server.product.dimension.FashionProductDimension;

/**
 * Product details for Fashion Products.
 */
public class FashionProductDetailsRequestDTO extends ProductDetailsRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -314070327469897080L;
	/**
	 * Product sub category
	 */
	private String subCategory;
	
	/**
	 * Product Dimensions
	 */
	private FashionProductDimension fashionProductDimension;
	/**
	 * Quantity in Pieces
	 */
	private double quantity;
	/**
	 * @return the size
	 */
	public FashionProductDimension getFashionProductDimension() {
		return fashionProductDimension;
	}
	/**
	 * @param size the size to set
	 */
	public void setFashionProductDimension(FashionProductDimension fashionProductDimension) {
		this.fashionProductDimension = fashionProductDimension;
	}
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}
	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FashionProductDetailsRequestDTO [subCategory=" + subCategory + ", quantity="
				+ quantity + "]";
	}

	
}
