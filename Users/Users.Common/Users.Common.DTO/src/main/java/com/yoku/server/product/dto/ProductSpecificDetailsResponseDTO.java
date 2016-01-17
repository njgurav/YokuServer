package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class ProductSpecificDetailsResponseDTO extends BaseResponseDTO {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4555246432400232559L;

	/**
	 * Serial Version UID.
	 */
	
	private RestaurantProductDetailsResponseDTO restaurantProductDetailsResponseDTO;
	
	private FashionProductDetailsResponseDTO fashionProductDetailsResponseDTO;
	
	private GorceryProductDetailsResponseDTO gorceryProductDetailsResponseDTO;

	
	public RestaurantProductDetailsResponseDTO getRestaurantProductDetailsResponseDTO() {
		return restaurantProductDetailsResponseDTO;
	}

	public FashionProductDetailsResponseDTO getFashionProductDetailsResponseDTO() {
		return fashionProductDetailsResponseDTO;
	}

	public GorceryProductDetailsResponseDTO getGorceryProductDetailsResponseDTO() {
		return gorceryProductDetailsResponseDTO;
	}
	
	public void setRestaurantProductDetailsResponseDTO(
			RestaurantProductDetailsResponseDTO restaurantProductDetailsResponseDTO) {
		this.restaurantProductDetailsResponseDTO = restaurantProductDetailsResponseDTO;
	}

	public void setFashionProductDetailsResponseDTO(
			FashionProductDetailsResponseDTO fashionProductDetailsResponseDTO) {
		this.fashionProductDetailsResponseDTO = fashionProductDetailsResponseDTO;
	}

	public void setGorceryProductDetailsResponseDTO(
			GorceryProductDetailsResponseDTO gorceryProductDetailsResponseDTO) {
		this.gorceryProductDetailsResponseDTO = gorceryProductDetailsResponseDTO;
	}

}
