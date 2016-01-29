package com.yoku.server.framework.entity.common;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.text.StyleConstants.ColorConstants;

import com.yoku.server.framework.entity.core.IEntity;
import com.yoku.server.infra.constants.Constants;

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
	 * Primary key. AddressId.
	 */
	@EmbeddedId
	private AddressKey key;

	/**
	 * Identifier for the user for whom the address is being stored.
	 *
	 * Contains value pertaining to
	 * <ul>
	 * <li>MerchantId (Location of his store)</li>
	 * <li>CustomerId (Delivery addresses for orders)</li>
	 * <li>NinjaId (Residential Address, etc)</li>
	 * </ul>
	 * 
	 */
	@Column(name = "user_id")
	private String userId;
	
	
	/**
	 * Identifies user type for which this address is being stored. Should have
	 * one of the following values
	 * <ul>
	 * <li>MERCHANT {@link Constants.USER_MERCHANT}</li>
	 * <li>CUSTOMER {@link Constants.USER_CUSTOMER}}</li>
	 * <li>NINJA {@link Constants.USER_NINJA}</li>
	 * </ul>
	 */
	@Column(name="user_type")
	private String userType;
	
	/**
	 * Location info for the current address.
	 */
	@OneToOne(fetch = FetchType.EAGER, mappedBy="address", cascade=CascadeType.ALL)
	private Location location;

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
	 * Title. Especially for the customer where user has more than one delivery
	 * address. Or Ninja Residential Temporary or permanent address.
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
	 * @param key
	 *            the key to set
	 */
	public void setKey(AddressKey key) {
		this.key = key;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the loaction
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the loaction to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}


	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [key=" + key + ", userId=" + userId + ", userType=" + userType + ", title=" + title
				+ ", description=" + description + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + ", line1=" + line1 + ", line2=" + line2 + ", landmark=" + landmark + "]";
	}

}
