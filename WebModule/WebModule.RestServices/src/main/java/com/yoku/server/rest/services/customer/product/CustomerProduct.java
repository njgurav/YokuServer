package com.yoku.server.rest.services.customer.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Provides services for Product operations.
 */
@RestController
@RequestMapping("/product")
public class CustomerProduct extends AbstractRestService {

	/**
	 * Constructor.
	 */
	public CustomerProduct() {
	}

	/**
	 * Fetch product details based on only productId.
	 * 
	 * @param productId
	 *            Product Id to fetch details.
	 * @return
	 */
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> read(@PathVariable String productId) {
		return null;
	}

}
