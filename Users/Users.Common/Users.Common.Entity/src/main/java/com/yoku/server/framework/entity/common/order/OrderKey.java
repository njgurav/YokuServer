package com.yoku.server.framework.entity.common.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Key for Order master table
 */
@Embeddable
public class OrderKey implements IEntityKey {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7526233804725744995L;
	/**
	 * Order Id
	 */
	@Column(name = "order_id")
	private String orderId;

	/**
	 * Customer Id for the customer who placed this order.
	 */
	@Column(name = "customer_id")
	private String customerId;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderKey [orderId=" + orderId + ", customerId=" + customerId + "]";
	}

}
