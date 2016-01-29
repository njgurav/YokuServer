package com.yoku.server.rest.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.yoku.server.exception.session.InvalidLoginHeadersException;
import com.yoku.server.exception.session.InvalidUserException;
import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.exception.session.MandatoryLoginException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.fw.authentication.session.SessionManager;

/**
 * Parent class for all rest services.
 */
public abstract class AbstractRestService {

	/**
	 * Security flag. Temporary hard coded. This value should be fetched from
	 * Preferences and configurations.
	 */
	private static final boolean SECURITY_ENABLED = false;

	/**
	 * {@link HttpServletRequest} instance to fetch header data for validation
	 * and other activities.
	 */
	@Autowired
	private HttpServletRequest request;
	/**
	 * {@link HttpServletResponse} instance to store data into headers.
	 */
	@Autowired
	private HttpServletResponse response;

	/**
	 * Build Response for client.
	 * 
	 * @param httpStatus
	 *            {@link HttpStatus}
	 * @param response
	 *            {@link BaseDTO}
	 * @return {@link ResponseEntity}
	 */
	protected ResponseEntity<BaseDTO> buildResponse(HttpStatus httpStatus, BaseDTO response) {
		return new ResponseEntity<BaseDTO>(response, httpStatus);
	}

	/**
	 * Validates merchant session and returns Actual merchantId for service
	 * Execution.
	 * 
	 * @param userId
	 *            merchantId from client (indirected)
	 * @return Actual merchantId
	 * @throws InvalidUserException
	 *             If logged in merchant user fails to provide the correct
	 *             validation data (auth-token and deviceId).s
	 * @throws MandatoryLoginException
	 *             Throw this exception when a user tries to access a service
	 *             that requires authentication, and the authentication data is
	 *             not provided.
	 */
	protected String beginMerchantSession(String userId) throws LoginSessionException {
		if (SECURITY_ENABLED) {
			String authToken = request.getHeader("auth-token");
			String deviceId = request.getHeader("device-hash");
			if (authToken == null || deviceId == null) {
				throw new InvalidLoginHeadersException();
			}
			return new SessionManager().validateMerchant(userId, authToken, deviceId);
		}
		return userId;
	}

	/**
	 * Validates ninja session and returns Actual ninjaId for service Execution.
	 * 
	 * @param userId
	 *            ninjaId from client (indirected)
	 * @return Actual ninjaId
	 * @throws InvalidUserException
	 *             If logged in ninja user fails to provide the correct
	 *             validation data (auth-token and deviceId).s
	 * @throws MandatoryLoginException
	 *             Throw this exception when a user tries to access a service
	 *             that requires authentication, and the authentication data is
	 *             not provided.
	 */
	protected String beginNinjaSession(String userId) throws InvalidUserException, MandatoryLoginException {
		if (SECURITY_ENABLED) {
			String authToken = request.getHeader("auth-token");
			String deviceId = request.getHeader("device-hash");
			return new SessionManager().validateNinja(userId, authToken, deviceId);
		} else {
			return userId;
		}
	}

	/**
	 * Validates customer session and returns Actual customerId for service
	 * Execution.
	 * 
	 * @param userId
	 *            customerId from client (indirected)
	 * @return Actual customerId
	 * @throws InvalidUserException
	 *             If logged in customer user fails to provide the correct
	 *             validation data (auth-token and deviceId).s
	 * @throws MandatoryLoginException
	 *             Throw this exception when a user tries to access a service
	 *             that requires authentication, and the authentication data is
	 *             not provided.
	 */
	protected String beginCustomerSession(String userId) throws InvalidUserException, MandatoryLoginException {
		if (SECURITY_ENABLED) {
			String authToken = request.getHeader("auth-token");
			String deviceId = request.getHeader("device-hash");
			return new SessionManager().validateCustomer(userId, authToken, deviceId);
		} else {
			return userId;
		}
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractRestService [request=" + request + ", response=" + response + "]";
	}

}
