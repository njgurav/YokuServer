package com.yoku.server.order.dto;

import java.util.List;

import com.yoku.server.framework.dto.BaseRequestDTO;

/**
 * Order details for placing orders.
 */
public class OrderDetailRequestDTO extends BaseRequestDTO {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8532798714673516800L;

	/**
	 * Order details
	 */
	List<OrderDTO> orders;

	/**
	 * @return the orders
	 */
	public List<OrderDTO> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDetailRequestDTO [orders=" + orders + "]";
	}
	
	
}
