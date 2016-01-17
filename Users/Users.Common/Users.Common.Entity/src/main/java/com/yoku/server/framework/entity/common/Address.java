package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Address Entity for table 'tbl_address".
 */
@Entity
@Table(name = "tbl_address")
public class Address implements IEntity {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 5487215930467935259L;
	/**
	 * Private key
	 */
	@EmbeddedId
	private AddressKey key;
	/**
	 * Latitude
	 */
	@Column(name = "latitude")
	private Double latitude;
	/**
	 * Longitude
	 */
	@Column(name = "longitude")
	private Double longitude;
	/**
	 * PlaceId. Mostly google placeId.
	 */
	@Column(name = "plcae_id")
	private String placeId;
	/**
	 * Title
	 */
	@Column(name = "title")
	private String title;
	/**
	 * Description
	 */
	@Column(name = "description")
	private String description;
	/**
	 * Country
	 */
	@Column(name = "country")
	private String country;
	/**
	 * State
	 */
	@Column(name = "state")
	private String state;
	/**
	 * City
	 */
	@Column(name = "city")
	private String city;
	/**
	 * Zipcode
	 */
	@Column(name = "zip")
	private Integer zipcode;
	/**
	 * Line 1 of Address
	 */
	@Column(name = "line1")
	private String line1;
	/**
	 * Line 2 of Address
	 */
	@Column(name = "line2")
	private String line2;
	/**
	 * Address LandMark.
	 */
	@Column(name = "landmark")
	private String landmark;

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

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipcode
	 */
	public Integer getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * @param line1
	 *            the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @param line2
	 *            the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark
	 *            the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	

	/**
	 * @return the key
	 */
	public AddressKey getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(AddressKey key) {
		this.key = key;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [key=" + key + ", latitude=" + latitude + ", longitude=" + longitude + ", placeId=" + placeId
				+ ", title=" + title + ", description=" + description + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", zipcode=" + zipcode + ", line1=" + line1 + ", line2=" + line2 + ", landmark="
				+ landmark + "]";
	}

}
