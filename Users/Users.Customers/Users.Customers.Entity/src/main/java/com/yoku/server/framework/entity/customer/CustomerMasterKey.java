package com.yoku.server.framework.entity.customer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;
/**
 * Customer master key for CustomerMaster entity.
 */
@Embeddable
public class CustomerMasterKey implements IEntityKey {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1659691863999197359L;

	/**
	 * Customer Id after successful registration.
	 */
	@Column(name="customer_id")
	private String customerId;

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerMasterKey [customerId=" + customerId + "]";
	}
	
	
}
