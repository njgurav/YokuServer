package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Grocery Product key
 */
@Embeddable
public class ProductGroceryKey implements IEntityKey {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6261520579670587243L;
	/**
	 * Product Id
	 */
	@Column(name="product_id")
	private String productId;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductGroceryKey [productId=" + productId + "]";
	}

}
