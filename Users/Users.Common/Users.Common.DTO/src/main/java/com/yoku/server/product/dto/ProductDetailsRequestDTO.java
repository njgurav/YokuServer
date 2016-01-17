package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Product details for adding Product to a repository.
 */
public class ProductDetailsRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 419591867440470942L;
	
	/**
	 * Product FashionProductDetailsRequestDTO.
	 */
	private FashionProductDetailsRequestDTO fashionProductDetailsRequestDTO;

	/**
	 * Product GroceryProductDetailsRequestDTO.
	 */
	private GroceryProductDetailsRequestDTO groceryProductDetailsRequestDTO;
	
	/**
	 * Product RestaurantProductDetailsRequestDTO.
	 */
	private RestaurantProductDetailsRequestDTO restaurantProductDetailsRequestDTO;
	
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
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
	
	public FashionProductDetailsRequestDTO getFashionProductDetailsRequestDTO() {
		return fashionProductDetailsRequestDTO;
	}

	public void setFashionProductDetailsRequestDTO(
			FashionProductDetailsRequestDTO fashionProductDetailsRequestDTO) {
		this.fashionProductDetailsRequestDTO = fashionProductDetailsRequestDTO;
	}

	public GroceryProductDetailsRequestDTO getGroceryProductDetailsRequestDTO() {
		return groceryProductDetailsRequestDTO;
	}

	public void setGroceryProductDetailsRequestDTO(
			GroceryProductDetailsRequestDTO groceryProductDetailsRequestDTO) {
		this.groceryProductDetailsRequestDTO = groceryProductDetailsRequestDTO;
	}

	public RestaurantProductDetailsRequestDTO getRestaurantProductDetailsRequestDTO() {
		return restaurantProductDetailsRequestDTO;
	}

	public void setRestaurantProductDetailsRequestDTO(
			RestaurantProductDetailsRequestDTO restaurantProductDetailsRequestDTO) {
		this.restaurantProductDetailsRequestDTO = restaurantProductDetailsRequestDTO;
	}

	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "ProductDetailsRequestDTO [Category=" + category + ", title=" + title
				+ ", description=" + description + ", pricePerUnit=" + pricePerUnit + "]";
	}

}
