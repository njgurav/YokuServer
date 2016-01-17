package com.yoku.server.core.db.utils;

/**
 * Utility class to perform Persistence related activities for framework.
 * 
 * @author njgurav
 *
 */
public class PersistenceUtil {
	/**
	 * Set providerType for performing persisting activities like Database
	 * persisting, Writing to disk, etc.
	 */
	public ORMProviderType providerType;

	/**
	 * Provide Persistence type.
	 * 
	 * @param requestingResource
	 *            The core service requesting an ORM provider to perform data
	 *            persistence.
	 * @return {@link ORMProviderType}
	 */
	public ORMProviderType getORMProvider(String requestingResource) {
		if (providerType != null) {
			return providerType;
		}
		return ORMProviderType.HIBERNATE;
	}
}
