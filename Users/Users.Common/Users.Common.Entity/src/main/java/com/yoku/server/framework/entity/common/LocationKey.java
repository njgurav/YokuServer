package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Reference to AddressId. LocationId may or may not exist for a given address.
 */
@Embeddable
public class LocationKey implements IEntityKey {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3448082631288681960L;

	/**
	 * Reference to AddressId.
	 */
	@Column(name="id")
	private String locationId;

	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationKey [locationId=" + locationId + "]";
	}

}
