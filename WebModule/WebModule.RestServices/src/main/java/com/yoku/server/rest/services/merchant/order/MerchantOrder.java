package com.yoku.server.rest.services.merchant.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.order.dto.OrderDetailsResponseDTO;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Order operations for Merchant.
 * 
 * Query on table 'Order_details'
 */
@RestController
@RequestMapping("/merchant/{merchantId}/order")
public class MerchantOrder extends AbstractRestService {
	
	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(MerchantOrder.class);

	/**
	 * Constructor
	 */
	public MerchantOrder() {
	}

	/**
	 * Read all orders for current merchant.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readAll(@PathVariable String merchantId, @RequestParam String status) {
		OrderDetailsResponseDTO response = null;
		HttpStatus httpStatus = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			com.yoku.server.core.services.order.Order service = new com.yoku.server.core.services.order.Order();
			response = service.readAll(merId, status);
			httpStatus = HttpStatus.OK;
		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, response);
	}

	/**
	 * Read order for current merchant for the provided orderId.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> read(@PathVariable String merchantId, @PathVariable String orderId) {
		OrderDetailsResponseDTO response = null;
		HttpStatus httpStatus = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			com.yoku.server.core.services.order.Order service = new com.yoku.server.core.services.order.Order();
			response = service.read(merId, orderId);
			httpStatus = HttpStatus.OK;
		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, response);
	}

	/**
	 * Update Current Order status. Make it available to Ninja for pickup.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/{orderId}", method = RequestMethod.PUT, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> updateStatus(@PathVariable String merchantId, @PathVariable String orderId,
			@RequestParam String status) {
		try {
			String merId = super.beginMerchantSession(merchantId);
			com.yoku.server.core.services.order.Order service = new com.yoku.server.core.services.order.Order();
			service.updateStatusByMerchant(merId, orderId, status);
		} catch (LoginSessionException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
