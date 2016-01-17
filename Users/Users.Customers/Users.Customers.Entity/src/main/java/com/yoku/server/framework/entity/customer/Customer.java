package com.yoku.server.framework.entity.customer;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Customer registration entity.
 */
@Entity
@Table(name = "cust_reg_master")
public class Customer implements IEntity {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7869799521804887939L;

	/**
	 * Primary key contains registration Id
	 */
	@EmbeddedId
	private CustomerKey key;
	
	/**
	 * Identifies customer name
	 */
	@Column(name="name")
	private String name;
	
	/**
	 * Identifies customer email Id
	 */
	@Column(name="email_id")
	private String emailId;
	
	/**
	 * Identifies customer mobile number
	 */
	@Column(name="mobile_no")
	private String mobileNo;
	
	/**
	 * Identifies customer password.
	 */
	@Column(name="password")
	private String password;

	/**
	 * @return the key
	 */
	public CustomerKey getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(CustomerKey key) {
		this.key = key;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [key=" + key + ", name=" + name + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}
	
	
	
}
