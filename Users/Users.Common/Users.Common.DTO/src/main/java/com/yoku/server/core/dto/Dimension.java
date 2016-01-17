package com.yoku.server.core.dto;

import java.io.Serializable;

public class Dimension implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float width;
	
	private float height;
	
	private float length;
	
	public Dimension(){
		
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	
	

}
