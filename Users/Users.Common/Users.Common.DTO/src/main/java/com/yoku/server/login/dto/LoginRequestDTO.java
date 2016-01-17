package com.yoku.server.login.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Request DTO for Login requests.
 */
public class LoginRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1213996323940014712L;
	/**
	 * User name for login.
	 */
	private String userName;
	/**
	 * Password for the account.
	 */
	private String password;
	/**
	 * Device identifier that should be sent in subsequent requests after login.
	 */
	private String deviceId;

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUserName(String username) {
		this.userName = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginRequestDTO [username=" + userName + ", password=" + password + ", deviceId=" + deviceId + "]";
	}

}
