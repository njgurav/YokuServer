package com.yoku.server.exception.session;

/**
 * Exception indicating the user requesting service cannot be validated against
 * the session data stored in the application. Raised when user is logged into
 * the application, but when the auth-token and device Id fails to be validated
 * with the ones stored in the cache.
 */
public class InvalidUserException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1750473690183151155L;

	/**
	 * User Type that raised the exception. (Merchant/Ninja/Customer)
	 */
	private String userType;

	/**
	 * Indirected MerchantId/NinjaId/CustomerId of the customer that failed to
	 * be validated.
	 */
	private String userId;

	/**
	 * Device Id passed by the user.
	 */
	private String deviceId;
	
	/**
	 * Authentication Token passed by the user.
	 */
	private String authToken;

	/**
	 * Constructor
	 * 
	 * @param userType
	 *            the user type that failed to be validated
	 */
	public InvalidUserException(String userType, String userId, String deviceId, String authToken) {
		this.userType = userType;
		this.userId = userId;
		this.deviceId = deviceId;
		this.authToken = authToken;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InvalidUserException [userType=" + userType + ", userId=" + userId + ", deviceId=" + deviceId
				+ ", authToken=" + authToken + "] does not provide valid auth-token or deviceId";
	}

}
