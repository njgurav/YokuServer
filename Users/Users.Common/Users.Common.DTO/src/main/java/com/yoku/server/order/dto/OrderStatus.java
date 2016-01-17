package com.yoku.server.order.dto;

/**
 * Enum class containing status of orders.
 */
public enum OrderStatus {
	/**
	 * Customer placed this order
	 */
	NEW,
	/**
	 * Merchant approved this order
	 */
	APPROVED,
	/**
	 * Merchant rejected this order
	 */
	REJECTED,
	/**
	 * Merchant has approved this order and the package is ready to be shipped.
	 */
	M_READY,
	/**
	 * Ninja has picked this order from merchant and is being delivered to
	 * customer.
	 */
	M_TRANSIT,
	/**
	 * Ninja has successfully delivered the products to customer.
	 */
	M_DELIVERED,
	/**
	 * In case, a return is initiated from customer end, the customer is ready
	 * to return the order.
	 */
	C_READY,
	/**
	 * Ninja has picked products from customer and is being returned to
	 * merchant.
	 */
	C_TRANSIT,
	/**
	 * Ninja has successfully delivered the returned products back to the
	 * merchant.
	 */
	C_DELIVERED;

}
