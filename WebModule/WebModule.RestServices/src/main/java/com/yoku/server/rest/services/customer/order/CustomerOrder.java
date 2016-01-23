package com.yoku.server.rest.services.customer.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.order.dto.OrderDetailRequestDTO;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Manages Orders from Customer perspective
 */
@RestController
@RequestMapping("/customer/{customerId}/order")
public class CustomerOrder extends AbstractRestService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(CustomerOrder.class);
	
	/**
	 * Default Constructor
	 */
	public CustomerOrder() {
	}

	/**
	 * Generates a new OrderId. Updates tables 'órder_master' and
	 * 'order_details' for the generated orderId.
	 * 
	 * @param request
	 *            order containing order details.
	 * @return status of order placement.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> create(@PathVariable String customerId, @RequestBody OrderDetailRequestDTO request) {
		try {
		String custId = super.beginCustomerSession(customerId);
		com.yoku.server.core.services.order.Order service = new com.yoku.server.core.services.order.Order();
		service.create(custId, request);
		} catch(LoginSessionException e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	

	/**
	 * Read all orders placed by current customer.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readAll(@PathVariable String customerId, @RequestParam String status) {
		return null;
	}

	/**
	 * Read order for current customer for the provided orderId.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> read(@PathVariable String customerId) {
		return null;
	}
}
