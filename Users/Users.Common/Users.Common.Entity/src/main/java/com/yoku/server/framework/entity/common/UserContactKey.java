package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * User Id. (merchantId/customerId/ninjaId)
 */
@Embeddable
public class UserContactKey implements IEntityKey {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1021020739884706609L;

	/**
	 * User Id to store cont.act details for. user id can be merchant Id, ninja
	 * Id or customer Id
	 */
	@Column(name="contact_id")
	private String userId;
	

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserContactKey [userId=" + userId + "]";
	}

	
}
