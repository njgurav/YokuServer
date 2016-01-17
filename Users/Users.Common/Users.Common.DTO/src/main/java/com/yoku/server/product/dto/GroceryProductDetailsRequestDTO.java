package com.yoku.server.product.dto;

import com.yoku.server.product.dimension.GroceryProductDimension;

/**
 * Product details for grocery product.
 */
public class GroceryProductDetailsRequestDTO extends ProductDetailsRequestDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4697218263295205291L;
	/**
	 * Product subcategory.
	 */
	private String subCategory;
/**
 * Dimension of the product
 */
	private GroceryProductDimension groceryProductDimension;
/**
 * Number of products available
 */
	private double quantity;
/**
 * Units for quantity (kg, pieces, etc.)
 */
	private String units;
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
/**
 * @return the size
 */
public GroceryProductDimension getGroceryProductDimension() {
	return groceryProductDimension;
}
/**
 * @param size the size to set
 */
public void setGroceryProductDimension(GroceryProductDimension groceryProductDimension) {
	this.groceryProductDimension = groceryProductDimension;
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
public void setQuantity(double quantity) {
	this.quantity = quantity;
}
/**
 * @return the units
 */
public String getUnits() {
	return units;
}
/**
 * @param units the units to set
 */
public void setUnits(String units) {
	this.units = units;
}
/**
 * For Logging
 */
@Override
public String toString() {
	return "GroceryProductDetailsRequestDTO [subCategory=" + subCategory + ", size=" + groceryProductDimension + ", quantity=" + quantity
			+ ", units=" + units + "]";
}
	
	
}
