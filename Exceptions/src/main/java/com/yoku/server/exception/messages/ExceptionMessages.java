package com.yoku.server.exception.messages;

/**
 * Class containing Exception messages.
 */
public final class ExceptionMessages {

	public static final String PLEASE_LOGIN = "User needs to login to access this service.";

	public static final String EMPTY_HEADERS = "Header data is empty or blank for Authentication.";

	public static final String INVALID_REQUEST = "The data captured from Request Headers for authentication does not match the data stored in the session cache.";
}
