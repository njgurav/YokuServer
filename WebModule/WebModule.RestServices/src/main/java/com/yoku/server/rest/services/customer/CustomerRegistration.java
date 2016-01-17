package com.yoku.server.rest.services.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.framework.dto.customer.registration.CustomerRegistrationRequestDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Provides operations for customer registration and account activation.
 */
@RestController
@RequestMapping("/customer")
public class CustomerRegistration extends AbstractRestService {

	/**
	 * Registers a new customer.
	 * 
	 * @return status of current operation.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> register(@RequestBody CustomerRegistrationRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.core.services.CustomerRegistration registrationService = new com.yoku.core.services.CustomerRegistration();
		registrationService.register(request);
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * URL to activate customer. As per process thought, this URL should be
	 * fired from customer provided email Id. This would also verify the
	 * customer email.
	 * 
	 * @param activationId
	 *            activationId is the identifier in the system for the
	 *            appropriate customer account. It might be registrationId, or
	 *            any other value operated on the registrationId.
	 */
	@RequestMapping(value = "/{activationId}/activate", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> activate(@PathVariable String activationId) {
		ResponseEntity<BaseDTO> response = null;
		com.yoku.core.services.CustomerRegistration registrationService = new com.yoku.core.services.CustomerRegistration();
		registrationService.activate(activationId);
		return response;
	}

	
}
