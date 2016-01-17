package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

public class CountriesDTO extends BaseResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2193370910508367427L;
	
	private CountryDTO[] countries;

	public CountriesDTO() {
	}

	public CountryDTO[] getCountries() {
		return countries;
	}

	public void setCountries(CountryDTO[] countries) {
		this.countries = countries;
	}
	
}
