package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

/**
 * Used to store Merchant address and order delivery and pickup address.
 */
public class AddressDTO extends BaseDTO {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -281506892864506491L;
	/**
	 * Identifier for Address entity. Address Entity will store address for
	 * multiple entities like Merchant, Customer, Pickup and Delivery addresses
	 * for orders, etc.
	 */
	private String id;
	/**
	 * User Type identifier.
	 */
	private String userType;
	/**
	 * User Id for which this address is being saved.
	 */
	private String userId;
	

	/**
	 * Country
	 */
	private String country;
	/**
	 * State
	 */
	private String state;
	/**
	 * City
	 */
	private String city;
	/**
	 * Zipcode
	 */
	private Integer zipcode;
	/**
	 * Line 1 of Address
	 */
	private String line1;
	/**
	 * Line 2 of Address
	 */
	private String line2;
	/**
	 * Address LandMark.
	 */
	private String landmark;
	/**
	 * Title
	 */
	private String title;
	/**
	 * Description
	 */
	private String description;

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * GPS location of Address of the Resource.
	 */
	private LocationDTO location;

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
	 * @return the location
	 */
	public LocationDTO getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", userType=" + userType + ", userId=" + userId + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", zipcode=" + zipcode + ", line1=" + line1 + ", line2="
				+ line2 + ", landmark=" + landmark + ", title=" + title + ", description=" + description + ", location="
				+ location + "]";
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
