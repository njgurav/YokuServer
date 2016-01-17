package com.yoku.server.login.dto;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Response DTO for Login requests.
 */
public class LoginResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 5248869821691461222L;

	/**
	 * Authentication Token to identify customer/merchant/ninja in subsequent
	 * requests after Login.
	 */
	private String authenticationToken;
	
	/**
	 * Indirected value for user Id (MerchantId/NinjaId/CustomerId)
	 */
	private String idirectedUserId;

	/**
	 * @return the authenticationToken
	 */
	public String getAuthenticationToken() {
		return authenticationToken;
	}

	/**
	 * @param authenticationToken the authenticationToken to set
	 */
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}
	
	/**
	 * @return the idirectedUserId
	 */
	public String getIdirectedUserId() {
		return idirectedUserId;
	}

	/**
	 * @param idirectedUserId the idirectedUserId to set
	 */
	public void setIdirectedUserId(String idirectedUserId) {
		this.idirectedUserId = idirectedUserId;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginResponseDTO [authenticationToken=" + authenticationToken + ", idirectedUserId=" + idirectedUserId
				+ "]";
	}
	
	
}
