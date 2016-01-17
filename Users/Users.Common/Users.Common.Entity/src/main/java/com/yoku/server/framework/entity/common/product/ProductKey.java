package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Product master table key
 */
@Embeddable
public class ProductKey implements IEntityKey {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2614324980453017774L;
	/**
	 * Primary key. Product Id.
	 */
	@Column(name = "product_id")
	private String productId;
	/**
	 * Merchant Id posting the product for display.
	 */
	@Column(name = "merchant_id")
	private String merchantId;

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

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * Logging
	 */
	@Override
	public String toString() {
		return "ProductKey [productId=" + productId + ", merchantId=" + merchantId + "]";
	}

}
