package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class PlacesDTO extends BaseResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PlaceDTO[] places;

	public PlacesDTO() {
	}

	public PlaceDTO[] getPlaces() {
		return places;
	}

	public void setPlaces(PlaceDTO[] places) {
		this.places = places;
	}
	
	

}
