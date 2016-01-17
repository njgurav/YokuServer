package com.yoku.server.infra.idgeneration.generators;

import java.sql.Timestamp;

/**
 * Complaint Id Generator.
 */
public class ComplaintIdGen implements IIdGenerator<String> {

	/**
	 * Instance Creator.
	 * 
	 * @return
	 */
	public static ComplaintIdGen getInstance() {
		return new ComplaintIdGen();
	}

	public String nextId() {
		/**
		 * Local class for Complaint Id.
		 */
		class ComplaintId {
			/**
			 * Prefix for the generated Id.
			 */
			private String prefix = "CT";
			/**
			 * Id Generated using prefix and current timestamp. So cannot be
			 * duplicated across time.
			 */
			private String id = prefix
					+ (new Timestamp((new java.util.Date()).getTime())).toString().replaceAll("\\s+|\\.|-|:", "");
		}
		return (new ComplaintId()).id;
	}

}
