package com.yoku.server.order.dto;

import java.util.List;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Contains list of Placed Orders
 */
public class OrderDetailsResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1939200826197395752L;
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
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDetailsResponseDTO [orders=" + orders + "]";
	}

}
