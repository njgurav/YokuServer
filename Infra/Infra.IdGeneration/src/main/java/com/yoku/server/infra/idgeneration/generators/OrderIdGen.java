package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Order Id Generator.
 */
public class OrderIdGen implements IIdGenerator<String> {
	/**
	 * Instance Creator.
	 * @return
	 */
	public static OrderIdGen getInstance(){
		return new OrderIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Order Id.
		 */
		class OrderId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "OR";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new OrderId()).id;
	}
	

}
