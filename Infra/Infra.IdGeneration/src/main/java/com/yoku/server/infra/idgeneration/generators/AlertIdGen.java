package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Alert Id Generator.
 *
 */
public class AlertIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static AlertIdGen getInstance() {
		return new AlertIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Alert Id.
		 */
		class AlertId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "AT";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new AlertId()).id;
	}

}
