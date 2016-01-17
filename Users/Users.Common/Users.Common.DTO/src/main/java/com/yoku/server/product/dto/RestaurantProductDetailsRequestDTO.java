package com.yoku.server.product.dto;

import com.yoku.server.product.dimension.RestrauntProductDimension;

/**
 * Product details for Restraunt Food and other product details.
 */
public class RestaurantProductDetailsRequestDTO extends ProductDetailsRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1726288720638390960L;
	/**
	 * Restraunt Cuisine Type.
	 */
	private String cuisine;
	/**
	 * Size of plate, box, glass etc.
	 */
	private RestrauntProductDimension restrauntProductDimension;
	
	/**
	 * @return the cuisine
	 */
	public String getCuisine() {
		return cuisine;
	}
	/**
	 * @param cuisine the cuisine to set
	 */
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	/**
	 * @return the size
	 */
	public RestrauntProductDimension getRestrauntProductDimension() {
		return restrauntProductDimension;
	}
	/**
	 * @param size the size to set
	 */
	public void setRestrauntProductDimension(RestrauntProductDimension restrauntProductDimension) {
		this.restrauntProductDimension = restrauntProductDimension;
	}
	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "RestrauntProductDetailsRequestDTO [cuisine=" + cuisine + ", size=" + restrauntProductDimension +  "]";
	}
	
	
}
