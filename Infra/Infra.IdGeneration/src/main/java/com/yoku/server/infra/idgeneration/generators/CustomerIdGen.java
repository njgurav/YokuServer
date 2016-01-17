package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Customer Id Generator.
 */
public class CustomerIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static CustomerIdGen getInstance() {
		return new CustomerIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Customer Id.
		 */
		class MerchantID {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "CS";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time. Proposition is to generate Customer Id
			 * once for every new Customer.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new MerchantID()).id;
	}

}
