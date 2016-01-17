package com.yoku.server.rest.services.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Address management
 */
@RestController
@RequestMapping(value = "/address/{id}")
public class Address extends AbstractRestService {

	/**
	 * Add address for the provided id in the application.
	 * 
	 * @param id
	 *            To store address against in the database. Id can be
	 *            merchantId, customerId, orderId, etc.
	 * @param address
	 *            Address containing data to be stored in the database.
	 * @return status of the operation.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> save(@PathVariable String id, @RequestBody AddressDTO address) {
		TransactionStatus status = null;
		com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(id);
		status = service.save(address);
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * Update address for the provided id in the application.
	 * 
	 * @param id
	 *            To update address against in the database. Id can be
	 *            merchantId, customerId, orderId, etc.
	 * @param address
	 *            Address containing data to be stored in the database.
	 * @return status of the operation.
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> update(@PathVariable String id, @RequestBody AddressDTO address) {
		TransactionStatus status = null;
		com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(id);
		status = service.update(address);
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * Read address for the provided id in the application.
	 * 
	 * @param id
	 *            To read address from the database. Id can be merchantId,
	 *            customerId, orderId, etc.
	 * @return address for the provided Id.
	 */
	@RequestMapping(method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> read(@PathVariable String id) {
		AddressDTO address = null;
		com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(id);
		address = service.read();
		return super.buildResponse(HttpStatus.OK, address);
	}

	/**
	 * Delete address for the provided id in the application.
	 * 
	 * @param id
	 *            To delete address from the database. Id can be merchantId,
	 *            customerId, orderId, etc.
	 * @return address for the provided Id.
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> delete(@PathVariable String id) {
		TransactionStatus status = null;
		com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(id);
		status = service.delete();
		return super.buildResponse(HttpStatus.OK, status);
	}

}
