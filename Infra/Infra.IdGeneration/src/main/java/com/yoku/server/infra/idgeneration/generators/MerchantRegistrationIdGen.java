package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Merchant Onboarding Registration Id generator.
 */
public class MerchantRegistrationIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static MerchantRegistrationIdGen getInstance() {
		return new MerchantRegistrationIdGen();
	}

	/**
	 * Generate and return new Id.
	 */
	public String nextId() {
		/**
		 * Local class for Merchant Onboarding Id.
		 */
		class MerchantOnboardingID {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "M";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time. Proposition is to generate onboarding Id
			 * once for every new merchant.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new MerchantOnboardingID()).id;
	}

}
