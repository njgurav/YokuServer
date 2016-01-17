package com.yoku.server.fw.authentication.session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Application cache containing logged in users context for authentication and
 * authorization purpose.
 * 
 * All logged in users Id are maintained in a SET that helps to identify if the
 * service requesting user has logged in or not.
 * 
 * It maintains a cache that stores logged in users context; and all incoming
 * post requests should be validated against the content stored in the cache.
 * 
 * This class will be instantiated based on singleton pattern so that only one
 * instance of the class exists in the application.
 */
public class Session {

	/**
	 * Private constructor. Cannot instantiate this class from outside.
	 * Initializes login sets and session kid caches.
	 */
	private Session() {
		if (!initialized) {
			initialized = true;

			merchants = new HashSet<String>();
			ninjas = new HashSet<String>();
			customers = new HashSet<String>();

			merchantCache = new ConcurrentHashMap<String, UserContext>();
			ninjaCache = new ConcurrentHashMap<String, UserContext>();
			customerCache = new ConcurrentHashMap<String, UserContext>();

			cache.put(MERCHANT_CACHE_KEY, merchantCache);
			cache.put(NINJA_CACHE_KEY, ninjaCache);
			cache.put(CUSTOMER_CACHE_KEY, customerCache);

		}
	}

	/**
	 * Singleton instance provider.
	 * 
	 * @return instance of Session class.
	 */
	protected static Session getInstance() {
		return SessionInstanceCreator.INSTANCE;
	}

	/**
	 * Session cache initialized flag
	 */
	private static boolean initialized = false;

	/**
	 * Key to identify Merchant Kid cache in session cache.
	 */
	public static final String MERCHANT_CACHE_KEY = "MERCHANT";

	/**
	 * Key to identify Ninja Kid cache in session cache.
	 */
	public static final String NINJA_CACHE_KEY = "NINJA";

	/**
	 * Key to identify Customer Kid cache in session cache.
	 */
	public static final String CUSTOMER_CACHE_KEY = "CUSTOMER";

	/**
	 * Logged in merchants Id.
	 */
	protected Set<String> merchants;

	/**
	 * Logged in ninjas Id.
	 */
	protected Set<String> ninjas;

	/**
	 * Logged in customers Id.
	 */
	protected Set<String> customers;

	/**
	 * Cache containing logged in users context.
	 */
	protected Map<String, ConcurrentHashMap<String, UserContext>> cache = new HashMap<String, ConcurrentHashMap<String, UserContext>>();

	/**
	 * Session Kid cache for Merchants.
	 */
	protected ConcurrentHashMap<String, UserContext> merchantCache;

	/**
	 * Session Kid cache for Ninja.
	 */
	protected ConcurrentHashMap<String, UserContext> ninjaCache;

	/**
	 * Session Kid cache for Customers.
	 */
	protected ConcurrentHashMap<String, UserContext> customerCache;

	
	

	/**
	 * Class to provide Session class singleton instance.
	 */
	private static class SessionInstanceCreator {
		private static final Session INSTANCE = new Session();
	}
}
