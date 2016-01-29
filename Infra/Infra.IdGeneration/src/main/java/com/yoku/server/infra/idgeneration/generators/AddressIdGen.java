package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Complaint Id Generator.
 */
public class AddressIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static AddressIdGen getInstance() {
		return new AddressIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Complaint Id.
		 */
		class AddressId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "AD";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new AddressId()).id;
	}

}
