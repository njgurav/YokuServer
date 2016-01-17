package com.yoku.server.core.services.order;

import java.util.List;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.dto.LocationDTO;
import com.yoku.server.core.services.AbstractService;
import com.yoku.server.framework.assembler.common.OrderAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.entity.common.order.OrderDetails;
import com.yoku.server.framework.entity.common.order.OrderDetailsKey;
import com.yoku.server.framework.entity.common.order.OrderKey;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.order.dto.OrderDetailRequestDTO;
import com.yoku.server.order.dto.OrderDetailsResponseDTO;

public class Order extends AbstractService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(Order.class);

	public Order() {
	}

	// ********************* CUSTOMER OPERATIONS ***********************
	/**
	 * Generates a new OrderId. Updates tables 'órder_master' and
	 * 'order_details' for the generated orderId.
	 * 
	 * @param request
	 *            order containing order details.
	 * @return status of order placement.
	 */
	public void create(String customerId, OrderDetailRequestDTO request) {
		return;
	}

	// ******************** MERCHANT OPERATIONS *************************
	/**
	 * Read all orders for current merchant.
	 * 
	 * @return order list
	 */
	@SuppressWarnings("unchecked")
	public OrderDetailsResponseDTO readAll(String merchantId, String status) {
		OrderDetailsResponseDTO response = null;
		List<?> orders = null;
		String query = "";
		logger.info("Inside Order Core Service, fetching all orders for merchant");
		IRepositoryAdapter<OrderDetails, OrderDetailsKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.fetchBusinessDetails"));
		if (status == null || status.length() == 0) {
			query = "from OrderDetails o where o.merchantId = '" + merchantId + "'";
			orders = (List<OrderDetails>) adapter.executeReadQuery(query);
		} else {
			query = "from OrderDetails o where o.merchantId = '" + merchantId + "' and o.status = '" + status + "'";
			orders = (List<OrderDetails>) adapter.executeReadQuery(query);
		}
		response = new OrderAssembler().toOrderDetailsResponse((List<OrderDetails>) orders);
		return response;
	}

	/**
	 * Read order for current merchant for the provided orderId.
	 * 
	 * @param orderId
	 * 
	 * @return order list
	 */
	@SuppressWarnings("unchecked")
	public OrderDetailsResponseDTO read(String merchantId, String orderId) {
		OrderDetailsResponseDTO response = null;
		List<?> orders = null;
		String query = "";
		logger.info("Inside Order Core Service, fetching all orders for merchant");
		IRepositoryAdapter<OrderDetails, OrderDetailsKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.fetchBusinessDetails"));

		query = "from OrderDetails o where o.merchantId = '" + merchantId + "' and o.key.orderId = '" + orderId + "'";
		orders = (List<OrderDetails>) adapter.executeReadQuery(query);

		response = new OrderAssembler().toOrderDetailsResponse((List<OrderDetails>) orders);
		return response;
	}

	/**
	 * Update Current Order status.
	 * 
	 * @param status2
	 * 
	 * @return order list
	 */
	public void updateStatusByMerchant(String merchantId, String OrderId, String status) {
		return;
	}

	// ************************** NINJA OPERATIONS *****************************

	/**
	 * Read all orders for Ninja for the required status from all merchants not
	 * assigned to any Ninja or with a specific status stating that orders are
	 * ready to be picked by Ninjas within the specified radius of Ninja current
	 * Location.
	 * 
	 * @return order list
	 */
	public void readAll(String status, String radius, LocationDTO currentLocation) {
		return;
	}

	/**
	 * Read all orders for Ninja for the required status from all merchants
	 * serviced or assigned to current ninja.
	 * 
	 * @return
	 * 
	 * @return order list
	 */
	@SuppressWarnings("unchecked")
	public OrderDetailsResponseDTO readSelfAll(String ninjaId, String status) {
		OrderDetailsResponseDTO response = null;
		List<?> orders = null;
		String query = "";
		logger.info("Inside Order Core Service, fetching all orders for merchant");
		IRepositoryAdapter<OrderDetails, OrderDetailsKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.fetchBusinessDetails"));
		if (status == null || status.length() == 0) {
			query = "from OrderDetails o where o.ninjaId = '" + ninjaId + "'";
			orders = (List<OrderDetails>) adapter.executeReadQuery(query);
		} else {
			query = "from OrderDetails o where o.ninjaId = '" + ninjaId + "' and o.status = '" + status + "'";
			orders = (List<OrderDetails>) adapter.executeReadQuery(query);
		}
		response = new OrderAssembler().toOrderDetailsResponse((List<OrderDetails>) orders);
		return response;
	}

	/**
	 * Read order for current merchant for the provided orderId.
	 * 
	 * @param orderId
	 * 
	 * @return order list
	 */
	@SuppressWarnings("unchecked")
	public OrderDetailsResponseDTO readOrderDetails(String orderId) {
		OrderDetailsResponseDTO response = null;
		List<?> orders = null;
		String query = "";
		logger.info("Inside Order Core Service, fetching all orders for merchant");
		IRepositoryAdapter<OrderDetails, OrderDetailsKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.fetchBusinessDetails"));

		query = "from OrderDetails o where o.key.orderId = '" + orderId + "'";
		orders = (List<OrderDetails>) adapter.executeReadQuery(query);

		response = new OrderAssembler().toOrderDetailsResponse((List<OrderDetails>) orders);
		return response;
	}

	/**
	 * Update Current Order status. Select Order for delivery.
	 * 
	 * @return order list
	 */
	public void updateStatusByNinja(String ninjaId, String orderId, String status) {
		return;
	}

}
