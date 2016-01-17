package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Ninja Id Generator.
 */
public class NinjaIdGen implements IIdGenerator<String> {
	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static NinjaIdGen getInstance() {
		return new NinjaIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Ninja Id.
		 */
		class MerchantID {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "NJ";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be duplicated across time. Proposition is to
			 * generate Ninja Id once for every new Ninja.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new MerchantID()).id;
	}

}
