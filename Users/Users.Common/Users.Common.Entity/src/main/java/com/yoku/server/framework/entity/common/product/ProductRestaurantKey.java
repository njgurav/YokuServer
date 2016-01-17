package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;
/**
 * Primary Key for Product Restraunt
 */
@Embeddable
public class ProductRestaurantKey implements IEntityKey {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2988534374631412342L;
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
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductRestrauntKey [productId=" + productId + "]";
	}
	
}
