package com.yoku.server.product.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Create New Product in the application.
 */
public class ProductCreateAndRegisterRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 61073222310770189L;
	
	/**
	 * Product is in stock while registering.
	 */
	private boolean inStock;

	/**
	 * @return the inStock
	 */
	public boolean isInStock() {
		return inStock;
	}

	/**
	 * @param inStock
	 *            the inStock to set
	 */
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	/**
	 * For Logging
	 */
	@Override
	public String toString() {
		return "ProductCreateAndRegisterRequestDTO [inStock=" + inStock + "]";
	}

}
