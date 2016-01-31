package com.yoku.server.address.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Request DTO to read all addresses saved for a particular user.
 */
public class AddressRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2985441225888090280L;
	
	/**
	 * The user type to retrieve user Id.
	 */
	private String userType;

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

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressReadRequestDTO [userType=" + userType + "]";
	}
	
	
	
	

}
