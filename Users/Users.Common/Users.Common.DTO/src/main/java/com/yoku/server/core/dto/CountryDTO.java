package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

public class CountryDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7375050385899785847L;
	
	private String name;
	
	private String code;
	
	public CountryDTO(){
		
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
}
