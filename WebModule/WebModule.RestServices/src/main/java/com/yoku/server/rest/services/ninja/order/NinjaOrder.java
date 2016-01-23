package com.yoku.server.rest.services.ninja.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.core.dto.LocationDTO;
import com.yoku.server.exception.session.InvalidUserException;
import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.exception.session.MandatoryLoginException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.order.dto.OrderDetailsResponseDTO;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Order related operations for Ninja
 */
@RestController
@RequestMapping("/ninja")
public class NinjaOrder extends AbstractRestService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(NinjaOrder.class);

	/**
	 * Default Constructor
	 */
	public NinjaOrder() {
	}

	/**
	 * Read all orders for Ninja for the required status from all merchants not
	 * assigned to any Ninja or with a specific status stating that orders are
	 * ready to be picked by Ninjas within the specified radius of Ninja current
	 * Location.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/order/all", method = RequestMethod.POST, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readAll(@RequestParam String status, @RequestParam String radius,
			@RequestBody LocationDTO currentLocation) {
		return null;
	}

	/**
	 * Read all orders for Ninja for the required status from all merchants
	 * serviced or assigned to current ninja.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "/{ninjaId}/order/all", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readSelfAll(@PathVariable String ninjaId, @RequestParam String status) {
		OrderDetailsResponseDTO response = null;
		HttpStatus httpStatus = null;
		try {
			String ninId = super.beginNinjaSession(ninjaId);
			com.yoku.server.core.services.order.Order service = new com.yoku.server.core.services.order.Order();
			response = service.readSelfAll(ninId, status);
			httpStatus = HttpStatus.OK;
		} catch(LoginSessionException e){
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, response);
	}

	/**
	 * Read order details for Ninja to decide to pick a delivery. Query on Order
	 * Details Table.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "order/{orderId}/details", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readOrderDetails(@PathVariable String orderId) {
		com.yoku.server.core.services.order.Order service = new com.yoku.server.core.services.order.Order();
		OrderDetailsResponseDTO response = service.readOrderDetails(orderId);
		return super.buildResponse(HttpStatus.OK, response);
	}

	/**
	 * Update Current Order status. Select Order for delivery.
	 * 
	 * @return order list
	 */
	@RequestMapping(value = "{ninjaId}/order/{orderId}", method = RequestMethod.PUT, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> updateStatus(@PathVariable String ninjaId, @PathVariable String orderId,
			@RequestParam String status) {
		return null;
	}

}
