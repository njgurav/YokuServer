package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;
/**
 * Entity for User preferences
 */
@Entity
@Table(name="alert_preferences")
public class UserAlertPreferences implements IEntity {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -271081566160062877L;

	/**
	 * Primary key for the entity.
	 */
	@EmbeddedId
	private UserAlertPreferenceKey key;
	/**
	 * SMS Preference value.
	 */
	@Column(name="sms")
	private boolean smsEnabled;
	/**
	 * Email Preference value.
	 */
	@Column(name="email")
	private boolean emailEnabled;
	/**
	 * Push notification value.
	 */
	@Column(name="push")
	private boolean pushEnabled;
	/**
	 * @return the key
	 */
	public UserAlertPreferenceKey getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(UserAlertPreferenceKey key) {
		this.key = key;
	}
	/**
	 * @return the smsEnabled
	 */
	public boolean isSmsEnabled() {
		return smsEnabled;
	}
	/**
	 * @param smsEnabled the smsEnabled to set
	 */
	public void setSmsEnabled(boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}
	/**
	 * @return the emailEnabled
	 */
	public boolean isEmailEnabled() {
		return emailEnabled;
	}
	/**
	 * @param emailEnabled the emailEnabled to set
	 */
	public void setEmailEnabled(boolean emailEnabled) {
		this.emailEnabled = emailEnabled;
	}
	/**
	 * @return the pushEnabled
	 */
	public boolean isPushEnabled() {
		return pushEnabled;
	}
	/**
	 * @param pushEnabled the pushEnabled to set
	 */
	public void setPushEnabled(boolean pushEnabled) {
		this.pushEnabled = pushEnabled;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAlertPreferences [key=" + key + ", smsEnabled=" + smsEnabled + ", emailEnabled=" + emailEnabled
				+ ", pushEnabled=" + pushEnabled + "]";
	}
	
	
}
