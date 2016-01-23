package com.yoku.server.fw.authentication.session;

import com.yoku.server.exception.session.InvalidUserException;
import com.yoku.server.exception.session.MandatoryLoginException;

/**
 * Performs operations on Session cache.
 */
public class SessionManager {

	/**
	 * The session instance to manage.
	 */
	private static Session session = Session.getInstance();

	/**
	 * Checks whether the merchant with the provided Id is logged in or not.
	 * 
	 * @param merchantId
	 *            Merchant Id to check
	 * @return Log in status.
	 */
	private boolean isMerchantLoggedIn(String merchantId) {
		if (session.merchants.contains(merchantId)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the ninja with the provided Id is logged in or not.
	 * 
	 * @param ninjaId
	 *            Ninja Id to check
	 * @return Log in status.
	 */
	private boolean isNinjaLoggedIn(String ninjaId) {
		if (session.ninjas.contains(ninjaId)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the customer with the provided Id is logged in or not.
	 * 
	 * @param customerId
	 *            Customer Id to check
	 * @return Log in status.
	 */
	private boolean isCustomerLoggedIn(String customerId) {
		if (session.customers.contains(customerId)) {
			return true;
		}
		return false;
	}

	/**
	 * Provides user context information of the user identified by userId
	 * (MechantId/NinjaId/CustomerId)
	 * 
	 * @param kidCacheKey
	 *            kid cache identifier for user type (MERCHANT/NINJA/CUSTOMER)
	 *            to pick kid cache from session cache.
	 * @param userId
	 *            MerchantId/NinjaId/CustomerId
	 * @return {@link UserContext}
	 */
	private UserContext getUserContext(String kidCacheKey, String userId) {
		return (session.cache.get(kidCacheKey)).get(userId);
	}

	/**
	 * Provides user context information of the user identified by userId
	 * (MechantId/NinjaId/CustomerId)
	 * 
	 * @param kidCacheKey
	 *            kid cache identifier for user type (MERCHANT/NINJA/CUSTOMER)
	 *            to pick kid cache from session cache.
	 * @param userId
	 *            MerchantId/NinjaId/CustomerId
	 * @return {@link UserContext}
	 */
	private UserContext saveUserContext(String kidCacheKey, String userId, UserContext user) {
		return (session.cache.get(kidCacheKey)).put(userId, user);
	}

	/**
	 * Validates merchants validation data.
	 * 
	 * @param merchantId
	 *            merchantId from client (Indirected)
	 * @param authToken
	 *            authentication token from client.
	 * @param deviceId
	 *            device Identifier used for login. Should be unique in a user
	 *            session.
	 * @return actual Merchant Id to execute Merchant service.
	 * @throws InvalidUserException
	 *             If logged in merchant user fails to provide the correct
	 *             validation data (auth-token and deviceId).
	 * @throws MandatoryLoginException
	 *             Throw this exception when a user tries to access a service
	 *             that requires authentication, and the authentication data is
	 *             not provided.
	 */
	public String validateMerchant(String merchantId, String authToken, String deviceId)
			throws InvalidUserException, MandatoryLoginException {
		String userId = null;
		if (isMerchantLoggedIn(merchantId)) {
			UserContext userContext = getUserContext(Session.MERCHANT_CACHE_KEY, merchantId);
			if (userContext.getAuthToken().equals(authToken) && userContext.getDeviceId().equals(deviceId)) {
				userId = userContext.getId();
			} else {
				throw new InvalidUserException("Merchant", merchantId, deviceId, authToken);
			}
		} else {
			throw new MandatoryLoginException("Merchant");
		}
		return userId;
	}

	/**
	 * Validates Ninja validation data.
	 * 
	 * @param ninjaId
	 *            ninjaId from client
	 * @param authToken
	 *            authentication token from client.
	 * @param deviceId
	 *            device Identifier used for login. Should be unique in a user
	 *            session.
	 * @return actual Ninja Id to execute Ninja service.
	 * @throws InvalidUserException
	 *             If logged in ninja user fails to provide the correct
	 *             validation data (auth-token and deviceId).
	 * @throws MandatoryLoginException
	 *             Throw this exception when a user tries to access a service
	 *             that requires authentication, and the authentication data is
	 *             not provided.
	 * 
	 */
	public String validateNinja(String ninjaId, String authToken, String deviceId)
			throws InvalidUserException, MandatoryLoginException {
		String userId = null;
		if (isNinjaLoggedIn(ninjaId)) {
			UserContext userContext = getUserContext(Session.NINJA_CACHE_KEY, ninjaId);
			if (userContext.getAuthToken().equals(authToken) && userContext.getDeviceId().equals(deviceId)) {
				userId = userContext.getId();
			} else {
				throw new InvalidUserException("Ninja", ninjaId, deviceId, authToken);
			}
		} else {
			throw new MandatoryLoginException("Ninja");
		}
		return userId;
	}

	/**
	 * Validates customer validation data.
	 * 
	 * @param customerId
	 *            customerId from client
	 * @param authToken
	 *            authentication token from client.
	 * @param deviceId
	 *            device Identifier used for login. Should be unique in a user
	 *            session.
	 * @return actual Customer Id to execute Customer service.
	 * @throws InvalidUserException
	 *             If logged in customer user fails to provide the correct
	 *             validation data (auth-token and deviceId).
	 * @throws MandatoryLoginException
	 *             Throw this exception when a user tries to access a service
	 *             that requires authentication, and the authentication data is
	 *             not provided.
	 */
	public String validateCustomer(String customerId, String authToken, String deviceId)
			throws InvalidUserException, MandatoryLoginException {
		String userId = null;
		if (isCustomerLoggedIn(customerId)) {
			UserContext userContext = getUserContext(Session.CUSTOMER_CACHE_KEY, customerId);
			if (userContext.getAuthToken().equals(authToken) && userContext.getDeviceId().equals(deviceId)) {
				userId = userContext.getId();
			} else {
				throw new InvalidUserException("Customer", customerId, deviceId, authToken);
			}
		} else {
			throw new MandatoryLoginException("Customer");
		}
		return userId;
	}

	/**
	 * Save merchant context into session cache post login.
	 * 
	 * @param merchantId
	 *            Actual merchantId
	 * @param indirectedId
	 *            Indirected MerchantId
	 * @param authToken
	 *            Authentication token generated by the application for current
	 *            merchant.
	 * @param deviceId
	 *            Device Id used for login
	 * @param authorizationRole
	 *            Authorization role assigned to current Merchant.
	 * @return context saved to cache.
	 */
	public boolean saveMerchant(String merchantId, String indirectedId, String authToken, String deviceId,
			String authorizationRole) {
		UserContext context = new UserContext();
		context.setId(merchantId);
		context.setIndirectedId(indirectedId);
		context.setAuthToken(authToken);
		context.setDeviceId(deviceId);
		context.setAuthorizationRole(authorizationRole);
		session.merchants.add(indirectedId);
		saveUserContext(Session.MERCHANT_CACHE_KEY, indirectedId, context);
		return false;
	}

	/**
	 * Save ninja context into session cache post login.
	 * 
	 * @param ninjaId
	 *            Actual ninjaId
	 * @param indirectedId
	 *            Indirected ninjaId
	 * @param authToken
	 *            Authentication token generated by the application for current
	 *            ninja.
	 * @param deviceId
	 *            Device Id used for login
	 * @param authorizationRole
	 *            Authorization role assigned to current Ninja.
	 * @return context saved to cache.
	 */
	public boolean saveNinja(String ninjaId, String indirectedId, String authToken, String deviceId,
			String authorizationRole) {
		UserContext context = new UserContext();
		context.setId(ninjaId);
		context.setIndirectedId(indirectedId);
		context.setAuthToken(authToken);
		context.setDeviceId(deviceId);
		context.setAuthorizationRole(authorizationRole);
		session.ninjas.add(indirectedId);
		saveUserContext(Session.NINJA_CACHE_KEY, indirectedId, context);
		return false;
	}

	/**
	 * Save customer context into session cache post login.
	 * 
	 * @param customerId
	 *            Actual customerId
	 * @param indirectedId
	 *            Indirected customerId
	 * @param authToken
	 *            Authentication token generated by the application for current
	 *            customer.
	 * @param deviceId
	 *            Device Id used for login
	 * @param authorizationRole
	 *            Authorization role assigned to current customer.
	 * @return context saved to cache.
	 */
	public boolean saveCustomer(String customerId, String indirectedId, String authToken, String deviceId,
			String authorizationRole) {
		UserContext context = new UserContext();
		context.setId(customerId);
		context.setIndirectedId(indirectedId);
		context.setAuthToken(authToken);
		context.setDeviceId(deviceId);
		context.setAuthorizationRole(authorizationRole);
		session.customers.add(indirectedId);
		saveUserContext(Session.CUSTOMER_CACHE_KEY, indirectedId, context);
		return false;
	}

}
