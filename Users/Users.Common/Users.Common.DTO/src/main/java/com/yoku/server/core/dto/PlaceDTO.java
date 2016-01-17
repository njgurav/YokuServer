package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

public class PlaceDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String code;
	
	private Boolean isPopular;
	
	private String countryCode;

	public PlaceDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsPopular() {
		return isPopular;
	}

	public void setIsPopular(Boolean isPopular) {
		this.isPopular = isPopular;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
