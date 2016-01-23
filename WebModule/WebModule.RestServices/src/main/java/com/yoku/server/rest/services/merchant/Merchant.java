package com.yoku.server.rest.services.merchant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.framework.dto.merchant.MerchantDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.MerchantIdResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantBusinessDetailsRequestDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantBusinessDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPaymentDetailsRequestDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPaymentDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsRequestDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantRegistrationDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantRegistrationIdResponseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * Merchant related activities.
 */
@RestController
@RequestMapping("/merchant")
public class Merchant extends AbstractRestService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(Merchant.class);
	
	/**
	 * Generate Registration Id for new merchants.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> register() {
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant("");
		MerchantRegistrationIdResponseDTO response = service.register();
		return super.buildResponse(HttpStatus.ACCEPTED, response);
	}

	/**
	 * Provides merchant dash-board data. Read data from <b>merchant_master</b>
	 * table. Also <b>returns Merchant Registration ID</b> to be used to fetch
	 * and update Merchant Profile.
	 * 
	 * @param merchantId
	 *            to fetch data for.
	 * @return merchant dash-board data.
	 */
	@RequestMapping(value = "{merchantId}/home", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> dashboard(@PathVariable String merchantId) {
		MerchantDetailsResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(merId);
			response = service.fetchDetails(merId);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

	/**
	 * Provides merchant Profile Primary data. Fetch data from merchant
	 * registration table 'mer_reg_primary'
	 * 
	 * @param registrationId
	 *            to fetch data for.
	 * 
	 * @return merchant primary details.
	 */
	@RequestMapping(value = "{registrationId}/profile/primary", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readProfilePrimary(@PathVariable String registrationId) {
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);
		MerchantPrimaryDetailsResponseDTO response = service.fetchPrimaryDetails();
		return super.buildResponse(HttpStatus.OK, response);
	}

	/**
	 * Updates merchant Profile Primary data.
	 * 
	 * @param registrationId
	 *            identifier to update merchant data.
	 * @return status of operation
	 */
	@RequestMapping(value = "{registrationId}/profile/primary", method = RequestMethod.PUT, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addPrimary(@PathVariable String registrationId,
			@RequestBody MerchantPrimaryDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);
		MerchantRegistrationDTO coreRequest = new MerchantRegistrationDTO();
		coreRequest.setCompanyName(request.getCompanyName());
		coreRequest.setEmailId(request.getEmailId());
		coreRequest.setPassword(request.getPassword());
		coreRequest.setPhoneNumber(request.getPhoneNumber());
		coreRequest.setBusinessType(request.getBusinessType());
		service.updatePrimaryDetails(coreRequest);
		return super.buildResponse(HttpStatus.OK, status);

	}

	/**
	 * Update business details of the registering merchant.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "{registrationId}/profile/business", method = RequestMethod.PUT, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addBusiness(@PathVariable String registrationId,
			@RequestBody MerchantBusinessDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);
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
		service.updateBusinessDetails(coreRequest);
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * Update payment details for the registering merchant.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "{registrationId}/profile/payment", method = RequestMethod.PUT, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addPayment(@PathVariable String registrationId,
			@RequestBody MerchantPaymentDetailsRequestDTO request) {
		TransactionStatus status = new TransactionStatus();
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);
		MerchantRegistrationDTO coreRequest = new MerchantRegistrationDTO();
		coreRequest.setCompanyPanNumber(request.getCompanyPanNumber());
		coreRequest.setBenefeciaryName(request.getBenefeciaryName());
		coreRequest.setAccountNumber(request.getAccountNumber());
		coreRequest.setBank(request.getBank());
		coreRequest.setBankBranch(request.getBankBranch());
		coreRequest.setBankIFSCCode(request.getBankIFSCCode());
		service.updatePaymentDetails(coreRequest);
		return super.buildResponse(HttpStatus.OK, status);
	}

	/**
	 * Fetches business details of the registering merchant if already saved.
	 * Use this service for completing incomplete registrations.
	 * 
	 * @return Saved business details of the Merchant.
	 */
	@RequestMapping(value = "{registrationId}/profile/business", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> fetchBusiness(@PathVariable String registrationId) {
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);

		MerchantBusinessDetailsResponseDTO response = service.fetchBusinessDetails();
		return super.buildResponse(HttpStatus.OK, response);
	}

	/**
	 * Fetches payment details of the registering merchant if already saved. Use
	 * this service for completing incomplete registrations.
	 * 
	 * @return Saved payment details of the Merchant.
	 */
	@RequestMapping(value = "{registrationId}/profile/payment", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> fetchPayment(@PathVariable String registrationId) {
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);

		MerchantPaymentDetailsResponseDTO response = service.fetchPaymentDetails();
		return super.buildResponse(HttpStatus.OK, response);
	}

	/**
	 * Saves Profile Pic
	 * 
	 * @return
	 */
	@RequestMapping(value = "{registrationId}/profile/pic", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> saveProfilePic() {
		return null;
	}

	/**
	 * Fetch Profile Pic
	 * 
	 * @return
	 */
	@RequestMapping(value = "{registrationId}/profile/pic", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> readProfilePic() {
		return null;
	}

	/**
	 * Update Profile Pic.
	 * 
	 * @return
	 */
	@RequestMapping(value = "{registrationId}/profile/pic", method = RequestMethod.PUT)
	public ResponseEntity<BaseDTO> updateProfilePic() {
		return null;
	}

	/**
	 * Get Merchant ID for the provided RegistrationId.
	 */
	@RequestMapping(value = "{registrationId}/id", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> getMerchantId(@PathVariable String registrationId) {
		com.yoku.server.core.services.Merchant service = new com.yoku.server.core.services.Merchant(registrationId);
		MerchantIdResponseDTO response = service.getMerchantId(registrationId);
		return super.buildResponse(HttpStatus.OK, response);
	}

}
