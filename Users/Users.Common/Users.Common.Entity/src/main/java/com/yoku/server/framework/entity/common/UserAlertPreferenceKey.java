package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Primary key User Id (ninja Id/merchantId/customerId)
 */
@Embeddable
public class UserAlertPreferenceKey implements IEntityKey {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7049170014521462668L;
	/**
	 * User Id to store preferences for
	 */
	@Column(name = "user_id")
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
		return "UserAlertPreferenceKey [userId=" + userId + "]";
	}
	
	
}
