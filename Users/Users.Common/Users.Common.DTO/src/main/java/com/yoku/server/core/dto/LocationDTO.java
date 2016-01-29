package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

/**
 * Location DTO. GPS location. Used in AddressDTO to store GPS position of an
 * address.
 * 
 * Use:
 * <ul>
 * <li><b> + (plus)</b> for N Latitude or E Longitude</li>
 * <li><b> - (Minus)</b> for S Latitude or W Longitude.</li>
 * </ul>
 * 
 * Example: +40.689060 -74.044636
 * 
 * Note: Your entry should not have any embedded spaces.
 */
public class LocationDTO extends BaseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1837744270527500537L;

	/**
	 * Latitude
	 */
	private String latitude;
	/**
	 * Longitude
	 */
	private String longitude;
	/**
	 * PlaceId. Mostly google placeId.
	 */
	private String placeId;

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
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
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the placeId
	 */
	public String getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId
	 *            the placeId to set
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationDTO [latitude=" + latitude + ", longitude=" + longitude + ", placeId=" + placeId + "]";
	}

}
