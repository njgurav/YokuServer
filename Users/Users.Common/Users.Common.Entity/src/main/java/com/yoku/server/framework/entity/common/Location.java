package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Location DTO containing Latitude, Longitude and placeId.
 */
@Entity
@Table(name="tbl_location")
public class Location implements IEntity {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 9170137202661617394L;

	/**
	 * Reference key to AddressId
	 */
	@EmbeddedId
	private LocationKey key;
	/**
	 * Latitude
	 */
	@Column(name="latitude")
	private String latitude;
	/**
	 * Longitude
	 */
	@Column(name="longitude")
	private String longitude;
	/**
	 * PlaceId as per some third party api
	 */
	@Column(name="placeId")
	private String placeId;

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Address address;
	
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the key
	 */
	public LocationKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(LocationKey key) {
		this.key = key;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [key=" + key + ", latitude=" + latitude + ", longitude=" + longitude + ", placeId=" + placeId
				+ ", address=" + address + "]";
	}

}
