package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class ParcelInfo extends BaseRequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String parcelId;
	
	private String parcelName;
	
	private String parcelDescription;
	
	private Boolean isFragile = false;
	
	private Boolean isInflammable = false;
	
	private Dimension dimension;
	
	private float weight;
	
	public ParcelInfo(){
		
	}

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}

	public String getParcelName() {
		return parcelName;
	}

	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}

	public String getParcelDescription() {
		return parcelDescription;
	}

	public void setParcelDescription(String parcelDescription) {
		this.parcelDescription = parcelDescription;
	}

	public Boolean getIsFragile() {
		return isFragile;
	}

	public void setIsFragile(Boolean isFragile) {
		this.isFragile = isFragile;
	}

	public Boolean getIsInflammable() {
		return isInflammable;
	}

	public void setIsInflammable(Boolean isInflammable) {
		this.isInflammable = isInflammable;
	}

	public void setDimension(Dimension dimension){
		this.dimension = dimension;
	}
	
	public Dimension getDimension(){
		return this.dimension;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	

}
