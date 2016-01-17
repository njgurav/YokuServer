package com.yoku.server.framework.assembler.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.yoku.server.core.assembler.IAssembler;
import com.yoku.server.framework.entity.common.order.Order;
import com.yoku.server.framework.entity.common.order.OrderDetails;
import com.yoku.server.order.dto.OrderDTO;
import com.yoku.server.order.dto.OrderDetailsResponseDTO;

/**
 * Assembler for Order Service.
 */
public class OrderAssembler implements IAssembler {
	/**
	 * Add order details from the application to Response.
	 * 
	 * @param placed orders from application
	 * @return response containing order data.
	 */
	public OrderDetailsResponseDTO toOrderDetailsResponse(List<OrderDetails> orders) {
		OrderDetailsResponseDTO response = new OrderDetailsResponseDTO();
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		Iterator<OrderDetails> itOrder = orders.iterator();
		while (itOrder.hasNext()) {
			OrderDetails order = itOrder.next();
			OrderDTO ord = new OrderDTO();
			ord.setDiscount(order.getDiscount());
			ord.setOfferId(order.getOfferId());
			ord.setOrderId(order.getKey().getOrderId());
			ord.setProductId(order.getKey().getProductId());
			ord.setQuantity(order.getQuantity());
			ord.setPrice(order.getPrice());
			ord.setTax(order.getTax());
			ord.setTotal(order.getTotal());
			ord.setMerchantId(order.getMerchantId());
			ord.setNinjaId(order.getNinjaId());
			ord.setLastUpdated(order.getLastUpdated());
			ord.setStatus(order.getStatus());
			orderList.add(ord);
		}
		response.setOrders(orderList);
		return response;
	}
/**
 * Order master table details
 * @param orders
 * @return
 */
	public OrderDetailsResponseDTO toOrderMasterResponse(List<Order> orders) {
		OrderDetailsResponseDTO response = new OrderDetailsResponseDTO();
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		Iterator<Order> itOrder = orders.iterator();
		while (itOrder.hasNext()) {
			Order order = itOrder.next();
			OrderDTO ord = new OrderDTO();
			
			ord.setDeliveryAddress(order.getAddress());
			ord.setOrderPlacementDate(order.getDate());
			ord.setOrderId(order.getKey().getOrderId());
			orderList.add(ord);
		}
		response.setOrders(orderList);
		return response;
	}

}
