package com.yoku.server.framework.entity.common.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Primary Key for Order Details table
 */
@Embeddable
public class OrderDetailsKey implements IEntityKey {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -1102577876583462075L;
	/**
	 * Order Id.
	 */
	@Column(name = "order_id")
	private String orderId;
	/**
	 * Product Id.
	 */
	@Column(name = "product_id")
	private String productId;

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
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
