package com.yoku.server.framework.dto.customer.dashboard;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Request DTO containing current location details and requested radius.
 */
public class NearByMerchantsRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 3620837825762744888L;
	
	private String latitude;
	
	private String longitude;
	
	private String radius;

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the radius
	 */
	public String getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(String radius) {
		this.radius = radius;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NearByMerchantsRequestDTO [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius
				+ "]";
	}
	
	

}
