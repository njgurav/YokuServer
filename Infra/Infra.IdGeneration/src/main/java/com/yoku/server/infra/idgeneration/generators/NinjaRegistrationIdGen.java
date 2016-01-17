package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Ninja Onboarding Registration Id Generator.
 */
public class NinjaRegistrationIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static NinjaRegistrationIdGen getInstance() {
		return new NinjaRegistrationIdGen();
	}

	/**
	 * Generate and return new Id.
	 */
	public String nextId() {
		/**
		 * Local class for Ninja Registration Id.
		 */
		class NinjaRegistrationId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "N";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time. Proposition is to generate registration Id
			 * once for every new Ninja.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new NinjaRegistrationId()).id;
	}

}
