package com.yoku.server.rest.services.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.address.dto.AddressRequestDTO;
import com.yoku.server.address.dto.AddressReadResponseDTO;
import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Address management
 */
@RestController
@RequestMapping(value = "/user/{userId}/address")
public class Address extends AbstractRestService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(Address.class);

	/**
	 * Add address for the provided id in the application.
	 * 
	 * 
	 * 
	 * @param id
	 *            To store address against in the database. Id is addressId for
	 *            the entity. UserId can be merchantId, customerId, orderId (a
	 *            temporary delivery address), etc. in case a customer stores
	 *            more than one address as preference.
	 * @param address
	 *            Address containing data to be stored in the database.
	 * @return status of the operation.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> save(@PathVariable String userId, @RequestBody AddressDTO address) {
		HttpStatus httpStatus = null;
		String addressUserId = null;
		TransactionStatus status = null;
		try {
			if (Constants.USER_MERCHANT.equals(address.getUserType())) {
				addressUserId = super.beginMerchantSession(userId);
			} else if (Constants.USER_CUSTOMER.equals(address.getUserType())) {
				addressUserId = super.beginCustomerSession(userId);
			} else if (Constants.USER_NINJA.equals(address.getUserType())) {
				addressUserId = super.beginNinjaSession(userId);
			}
			com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(addressUserId);
			status = service.save(address);
			httpStatus = HttpStatus.OK;
		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, status);
	}

	/**
	 * Read all Addresses for the provided UserId in the application.
	 * 
	 * @param userId
	 *            To read address from the database. Id can be merchantId,
	 *            customerId, orderId, etc.
	 * @return addresses for the provided Id.
	 */
	@RequestMapping(method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> read(@PathVariable String userId, @RequestParam(value="userType") String userType) {
		HttpStatus httpStatus = null;
		String addressUserId = null;
		AddressReadResponseDTO addresses = null;
		try {
			if (Constants.USER_MERCHANT.equals(userType)) {
				addressUserId = super.beginMerchantSession(userId);
			} else if (Constants.USER_CUSTOMER.equals(userType)) {
				addressUserId = super.beginCustomerSession(userId);
			} else if (Constants.USER_NINJA.equals(userType)) {
				addressUserId = super.beginNinjaSession(userId);
			}

			com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(addressUserId);
			addresses = service.read();
			httpStatus = HttpStatus.OK;

		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, addresses);
	}
	
	/**
	 * Deletes all Addresses for the provided UserId in the application.
	 * 
	 * @param userId
	 *            To read address from the database. Id can be merchantId,
	 *            customerId, orderId, etc.
	 * @return addresses for the provided Id.
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> deleteAll(@PathVariable String userId, @RequestBody AddressRequestDTO request) {
		HttpStatus httpStatus = null;
		String addressUserId = null;
		TransactionStatus status = null;
		try {
			if (Constants.USER_MERCHANT.equals(request.getUserType())) {
				addressUserId = super.beginMerchantSession(userId);
			} else if (Constants.USER_CUSTOMER.equals(request.getUserType())) {
				addressUserId = super.beginCustomerSession(userId);
			} else if (Constants.USER_NINJA.equals(request.getUserType())) {
				addressUserId = super.beginNinjaSession(userId);
			}
			com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(addressUserId);
			status = service.deleteAll();
			httpStatus = HttpStatus.OK;
		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, status);
	}

	/**
	 * Update address for the provided id in the application.
	 * 
	 * @param addressId
	 *            The addressId to update address data.
	 * @param address
	 *            Address containing data to be updated in the database.
	 * @return status of the operation.
	 */
	@RequestMapping(value = "/{addressId}", method = RequestMethod.PUT, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> update(@PathVariable String userId, @PathVariable String addressId,
			@RequestBody AddressDTO address) {
		HttpStatus httpStatus = null;
		String addressUserId = null;
		TransactionStatus status = null;
		try {
			if (Constants.USER_MERCHANT.equals(address.getUserType())) {
				addressUserId = super.beginMerchantSession(userId);
			} else if (Constants.USER_CUSTOMER.equals(address.getUserType())) {
				addressUserId = super.beginCustomerSession(userId);
			} else if (Constants.USER_NINJA.equals(address.getUserType())) {
				addressUserId = super.beginNinjaSession(userId);
			}
		com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(addressUserId,addressId );
		status = service.update(address);
		httpStatus = HttpStatus.OK;

		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, status);
	}

	/**
	 * Delete address for the provided id in the application.
	 * 
	 * @param id
	 *            To delete address from the database. Id can be merchantId,
	 *            customerId, orderId, etc.
	 * @return address for the provided Id.
	 */
	@RequestMapping(value="/{addressId}",method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> delete(@PathVariable String userId,@PathVariable String addressId,@RequestBody AddressRequestDTO request) {
		HttpStatus httpStatus = null;
		String addressUserId = null;
		TransactionStatus status = null;
		try {
			if (Constants.USER_MERCHANT.equals(request.getUserType())) {
				addressUserId = super.beginMerchantSession(userId);
			} else if (Constants.USER_CUSTOMER.equals(request.getUserType())) {
				addressUserId = super.beginCustomerSession(userId);
			} else if (Constants.USER_NINJA.equals(request.getUserType())) {
				addressUserId = super.beginNinjaSession(userId);
			}
		com.yoku.server.core.services.Address service = new com.yoku.server.core.services.Address(addressUserId, addressId);
		status = service.delete();
		httpStatus = HttpStatus.OK;
		} catch (LoginSessionException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(httpStatus, status);
	}

}
