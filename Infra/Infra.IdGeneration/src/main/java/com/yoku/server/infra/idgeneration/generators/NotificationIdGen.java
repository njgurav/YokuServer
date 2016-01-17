package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Notification ID Generator.
 */
public class NotificationIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static NotificationIdGen getInstance() {
		return new NotificationIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Notification Id.
		 */
		class NotificationId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "NT";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new NotificationId()).id;
	}

}
