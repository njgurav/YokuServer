package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

/**
 * Location DTO. GPS location. Used in AddressDTO to store GPS position of an
 * address.
 */
public class LocationDTO extends BaseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1837744270527500537L;

	/**
	 * Latitude
	 */
	private Double latitude;
	/**
	 * Longitude
	 */
	private Double longitude;
	/**
	 * PlaceId. Mostly google placeId.
	 */
	private String placeId;
	/**
	 * Title
	 */
	private String title;
	/**
	 * Description
	 */
	private String description;

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LocationInformationDTO [latitude=" + latitude + ", longitude=" + longitude + ", placeId=" + placeId
				+ ", title=" + title + ", description=" + description + "]";
	}

}
