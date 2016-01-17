package com.yoku.server.framework.alerts.events;

/**
 * For every entry in this enum, update table "application_events". Generate
 * Event Id using com.yoku.server.infra.idgeneration.generators.EventIdGen
 */
public enum Event {
	/**
	 * Merchant Successful Creation event.
	 */
	MERCHANT_CREATION_SUCCESSFUL,
	/**
	 * Merchant Failed Creation event.
	 */
	MERCHANT_CREATION_FAILED,
	/**
	 * Merchant Password generation event.
	 */
	MERCHANT_PASSWORD_GENERATION,
	/**
	 * Merchant Password Reset event.
	 */
	MERCHANT_PASSWORD_RESET,
	/**
	 * Mobile Verification and OTP event.
	 */
	MOBILE_VERIFICATION

}
