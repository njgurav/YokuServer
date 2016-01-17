package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Order Id Generator.
 */
public class ProductIdGen implements IIdGenerator<String> {
	/**
	 * Instance Creator.
	 * @return
	 */
	public static ProductIdGen getInstance(){
		return new ProductIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Order Id.
		 */
		class ProductId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "PRDCT";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new ProductId()).id;
	}
	

}
