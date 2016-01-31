package com.yoku.server.address.dto;

import java.util.Arrays;

import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Address Response DTO contains all addresses stored for a user.
 */
public class AddressReadResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8293945396786175002L;

	/**
	 * All addresses stored for a particular user.
	 */
	private AddressDTO[] addresses;

	/**
	 * @return the addresses
	 */
	public AddressDTO[] getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(AddressDTO[] addresses) {
		this.addresses = addresses;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressReadResponseDTO [addresses=" + Arrays.toString(addresses) + "]";
	}

}
