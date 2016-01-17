package com.yoku.server.framework.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Primary key for class Address. Table "tbl_address".
 */
@Embeddable
public class AddressKey implements IEntityKey {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -3515855997942186268L;
	/**
	 * Primary key.
	 */
	@Column(name = "id")
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressKey [id=" + id + "]";
	}

}
