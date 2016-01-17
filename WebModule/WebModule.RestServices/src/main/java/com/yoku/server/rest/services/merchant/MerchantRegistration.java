package com.yoku.server.rest.services.merchant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.framework.dto.merchant.registration.MerchantBusinessDetailsRequestDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantBusinessDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPaymentDetailsRequestDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPaymentDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsRequestDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantRegistrationDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Rest for Merchant Registration consisting multiple steps.
 */
@RestController
@RequestMapping("/merchant/register/{registrationId}/details")
public class MerchantRegistration extends AbstractRestService {

	public MerchantRegistration() {
	}

	/**
	 * Save primary details of the registering merchant.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/primary", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addPrimary(@PathVariable String registrationId,
			@RequestBody MerchantPrimaryDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.server.core.services.Merchant registrationService = new com.yoku.server.core.services.Merchant(
				registrationId);
		MerchantRegistrationDTO coreRequest = new MerchantRegistrationDTO();
		coreRequest.setCompanyName(request.getCompanyName());
		coreRequest.setEmailId(request.getEmailId());
		coreRequest.setPassword(request.getPassword());
		coreRequest.setPhoneNumber(request.getPhoneNumber());
		coreRequest.setBusinessType(request.getBusinessType());
		registrationService.savePrimaryDetails(coreRequest);
		return super.buildResponse(HttpStatus.OK, status);

	}

	/**
	 * Save business details of the registering merchant.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/business", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addBusiness(@PathVariable String registrationId,
			@RequestBody MerchantBusinessDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.server.core.services.Merchant registrationService = new com.yoku.server.core.services.Merchant(
				registrationId);
		MerchantRegistrationDTO coreRequest = new MerchantRegistrationDTO();
		coreRequest.setMerchantName(request.getMerchantName());
		coreRequest.setMerchantAddress(request.getMerchantAddress());
		coreRequest.setBusinessCategory(request.getBusinessCategory());
		coreRequest.setCompanyDisplayName(request.getCompanyDisplayName());
		coreRequest.setBusinessDescription(request.getBusinessDescription());
		coreRequest.setCity(request.getCity());
		coreRequest.setZipcode(request.getZipcode());
		coreRequest.setCompanyRegistrationCertificateNumber(request.getCompanyRegistrationCertificateNumber());
		coreRequest.setIsBargainAllowed(request.getIsBargainAllowed());
		registrationService.saveBusinessDetails(coreRequest);
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * Save payment details for the registering merchant.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addPayment(@PathVariable String registrationId,
			@RequestBody MerchantPaymentDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.server.core.services.Merchant registrationService = new com.yoku.server.core.services.Merchant(
				registrationId);
		MerchantRegistrationDTO coreRequest = new MerchantRegistrationDTO();
		coreRequest.setCompanyPanNumber(request.getCompanyPanNumber());
		coreRequest.setBenefeciaryName(request.getBenefeciaryName());
		coreRequest.setAccountNumber(request.getAccountNumber());
		coreRequest.setBank(request.getBank());
		coreRequest.setBankBranch(request.getBankBranch());
		coreRequest.setBankIFSCCode(request.getBankIFSCCode());
		registrationService.savePaymentDetails(coreRequest);
		return super.buildResponse(HttpStatus.OK, status);
	}

	@RequestMapping(value = "/documents", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addDocuments(MerchantBusinessDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * Fetches primary details of the registering merchant if already saved. Use
	 * this service for completing incomplete registrations.
	 * 
	 * @return Saved Primary details of the Merchant.
	 */
	@RequestMapping(value = "/primary", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> fetchPrimary(@PathVariable String registrationId) {

		com.yoku.server.core.services.Merchant registrationService = new com.yoku.server.core.services.Merchant(
				registrationId);
		MerchantPrimaryDetailsResponseDTO response = registrationService.fetchPrimaryDetails();
		if (response != null) {
			return super.buildResponse(HttpStatus.OK, response);
		} else {
			return new ResponseEntity<BaseDTO>(HttpStatus.NO_CONTENT);
		}

	}

	/**
	 * Fetches business details of the registering merchant if already saved.
	 * Use this service for completing incomplete registrations.
	 * 
	 * @return Saved business details of the Merchant.
	 */
	@RequestMapping(value = "/business", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> fetchBusiness(@PathVariable String registrationId) {
		com.yoku.server.core.services.Merchant registrationService = new com.yoku.server.core.services.Merchant(
				registrationId);

		MerchantBusinessDetailsResponseDTO response = registrationService.fetchBusinessDetails();
		if (response != null) {
			return super.buildResponse(HttpStatus.OK, response);
		} else {
			return new ResponseEntity<BaseDTO>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * Fetches payment details of the registering merchant if already saved. Use
	 * this service for completing incomplete registrations.
	 * 
	 * @return Saved payment details of the Merchant.
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> fetchPayment(@PathVariable String registrationId) {
		com.yoku.server.core.services.Merchant registrationService = new com.yoku.server.core.services.Merchant(
				registrationId);

		MerchantPaymentDetailsResponseDTO response = registrationService.fetchPaymentDetails();
		if (response != null) {
			return super.buildResponse(HttpStatus.OK, response);
		} else {
			return new ResponseEntity<BaseDTO>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	

}
