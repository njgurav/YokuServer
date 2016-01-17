package com.yoku.server.framework.entity.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * OTP class
 */
@Entity
@Table(name = "sec_otp")
public class OTP implements IEntity {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8092440387682691566L;
	/**
	 * Primary Key
	 */
	@EmbeddedId
	private OTPKey key;
	/**
	 * The OTP key send to client.
	 */
	@Column(name = "otp_key")
	private Integer otpKey;
	/**
	 * OTP timeout duration in seconds.
	 */
	@Column(name = "duration")
	private Integer duration;
	/**
	 * OTP creation time. Default is initialized to system current time while
	 * persisting this entity.
	 */
	@Column(name = "created_on")
	private Timestamp createdOn;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OTP [key=" + key + ", otpKey=" + otpKey + ", duration=" + duration + ", createdOn=" + createdOn + "]";
	}

	/**
	 * @return the key
	 */
	public OTPKey getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(OTPKey key) {
		this.key = key;
	}

	/**
	 * @return the createdOn
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the otpKey
	 */
	public Integer getOtpKey() {
		return otpKey;
	}

	/**
	 * @param otpKey
	 *            the otpKey to set
	 */
	public void setOtpKey(Integer otpKey) {
		this.otpKey = otpKey;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
