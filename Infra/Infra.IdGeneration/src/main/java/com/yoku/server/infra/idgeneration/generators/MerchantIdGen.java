package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Merchant Id generator.
 */
public class MerchantIdGen implements IIdGenerator<String> {
	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static MerchantIdGen getInstance() {
		return new MerchantIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Merchant Onboarding Id.
		 */
		class MerchantID {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "MR";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time. Proposition is to generate merchant Id
			 * once for every new merchant.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new MerchantID()).id;
	}

}
