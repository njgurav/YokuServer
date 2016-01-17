package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class AvailableAssignmentRequestDTO extends BaseRequestDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double latitude;
	
	private Double longitude;
	
	public AvailableAssignmentRequestDTO(){
		
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
