package com.yoku.server.framework.entity.customer;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

@Entity
@Table(name="customer_master")
public class CustomerMaster implements IEntity {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6192817887452625514L;

	/**
	 * Primary key contains customer Id
	 */
	@EmbeddedId
	private CustomerMasterKey key;
	
	

	/**
	 * Registration Id for customer
	 */
	@Column(name = "registration_id")
	private String registration_id;

	/**
	 * @return the registration_id
	 */
	public String getRegistration_id() {
		return registration_id;
	}

	/**
	 * @param registration_id the registration_id to set
	 */
	public void setRegistration_id(String registration_id) {
		this.registration_id = registration_id;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(CustomerMasterKey key) {
		this.key = key;
	}

	/**
	 * Identifies customer name
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Identifies customer email Id
	 */
	@Column(name = "email_id")
	private String emailId;

	/**
	 * Identifies customer mobile number
	 */
	@Column(name = "mobile_no")
	private String mobileNo;

	/**
	 * Identifies customer password.
	 */
	@Column(name = "password")
	private String password;

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param emailId
	 *            the emailId to set
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
	 * @param mobileNo
	 *            the mobileNo to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the key
	 */
	public CustomerMasterKey getKey() {
		return key;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [key=" + key + ", name=" + name + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}

}
