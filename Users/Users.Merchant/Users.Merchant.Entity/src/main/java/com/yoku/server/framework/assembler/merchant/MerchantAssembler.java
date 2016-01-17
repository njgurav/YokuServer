package com.yoku.server.framework.assembler.merchant;

import java.sql.Timestamp;
import java.util.Date;

import com.yoku.server.core.assembler.IAssembler;
import com.yoku.server.framework.dto.merchant.MerchantDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantBusinessDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPaymentDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantRegistrationDTO;
import com.yoku.server.framework.entity.merchant.Merchant;
import com.yoku.server.framework.entity.merchant.MerchantBusinessDetails;
import com.yoku.server.framework.entity.merchant.MerchantKey;
import com.yoku.server.framework.entity.merchant.MerchantMaster;
import com.yoku.server.framework.entity.merchant.MerchantMasterKey;
import com.yoku.server.framework.entity.merchant.MerchantPaymentDetails;
import com.yoku.server.framework.entity.merchant.MerchantPrimaryDetails;

public class MerchantAssembler implements IAssembler {

	/**
	 * Create a new Merchant Entity using the provided registration Id.
	 */
	public Merchant entity(String registrationId) {
		Merchant merchant = new Merchant();
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(registrationId);
		merchant.setKey(key);
		merchant.setInitiatedOn(new Timestamp(new Date().getTime()));
		merchant.setLastUpdatedOn(new Timestamp(new Date().getTime()));
		merchant.setRegistrationStatus(false);
		return merchant;
	}

	/**
	 * Create a merchant entity with primary details.
	 * 
	 * @param coreRequest
	 *            contains merchant primary details.
	 * @return entity.
	 */
	public MerchantPrimaryDetails toEntityWithPrimaryDetails(MerchantRegistrationDTO coreRequest) {
		MerchantPrimaryDetails merchant = new MerchantPrimaryDetails();
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(coreRequest.getRegistrationId());
		merchant.setKey(key);
		merchant.setCompanyName(coreRequest.getCompanyName());
		merchant.setEmailId(coreRequest.getEmailId());
		merchant.setPassword(coreRequest.getPassword());
		merchant.setPhoneNumber(coreRequest.getPhoneNumber());
		merchant.setBusinessType(coreRequest.getBusinessType());
		return merchant;
	}

	/**
	 * Create merchant entity with business details.
	 * 
	 * @param coreRequest
	 *            contains merchant business details.
	 * @return entity.
	 */
	public MerchantBusinessDetails toEntityWithBusinessDetails(MerchantRegistrationDTO coreRequest) {
		MerchantBusinessDetails merchant = new MerchantBusinessDetails();
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(coreRequest.getRegistrationId());
		merchant.setKey(key);
		merchant.setMerchantName(coreRequest.getMerchantName());
		merchant.setMerchantAddress(coreRequest.getMerchantAddress());
		merchant.setBusinessCategory(coreRequest.getBusinessCategory());
		merchant.setCompanyDisplayName(coreRequest.getCompanyDisplayName());
		merchant.setBusinessDescription(coreRequest.getBusinessDescription());
		merchant.setCity(coreRequest.getCity());
		merchant.setZipcode(coreRequest.getZipcode());
		merchant.setCompanyRegistrationCertificateNumber(coreRequest.getCompanyRegistrationCertificateNumber());
		merchant.setIsBargainAllowed(coreRequest.getIsBargainAllowed());
		return merchant;
	}

	/**
	 * Create merchant with Payment details.
	 * 
	 * @param coreRequest
	 *            contains merchant payment details.
	 * @return entity.
	 */
	public MerchantPaymentDetails toEntityWithPaymentDetails(MerchantRegistrationDTO coreRequest) {
		MerchantPaymentDetails merchant = new MerchantPaymentDetails();
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(coreRequest.getRegistrationId());
		merchant.setKey(key);
		merchant.setCompanyPanNumber(coreRequest.getCompanyPanNumber());
		merchant.setBeneficiaryName(coreRequest.getBenefeciaryName());
		merchant.setAccountNumber(coreRequest.getAccountNumber());
		merchant.setBank(coreRequest.getBank());
		merchant.setBankBranch(coreRequest.getBankBranch());
		merchant.setBankIFSCCode(coreRequest.getBankIFSCCode());
		return merchant;
	}

	/**
	 * Domain response to Service Response for Primary details.
	 * 
	 * @param merchant
	 *            domain response.
	 * @return service response.
	 */
	public MerchantPrimaryDetailsResponseDTO toResponseWithPrimaryDetails(MerchantPrimaryDetails merchant) {
		MerchantPrimaryDetailsResponseDTO response = new MerchantPrimaryDetailsResponseDTO();
		response.setCompanyName(merchant.getCompanyName());
		response.setEmailId(merchant.getEmailId());
		response.setPassword(merchant.getPassword());
		response.setPhoneNumber(merchant.getPhoneNumber());
		response.setBusinessType(merchant.getBusinessType());
		return response;
	}

	/**
	 * Domain response to Service Response for business details.
	 * 
	 * @param merchant
	 *            domain response.
	 * @return service response.
	 */
	public MerchantBusinessDetailsResponseDTO toResponseWithBusinessDetails(MerchantBusinessDetails merchant) {
		MerchantBusinessDetailsResponseDTO response = new MerchantBusinessDetailsResponseDTO();
		response.setMerchantName(merchant.getMerchantName());
		response.setMerchantAddress(merchant.getMerchantAddress());
		response.setBusinessCategory(merchant.getBusinessCategory());
		response.setCompanyDisplayName(merchant.getCompanyDisplayName());
		response.setBusinessDescription(merchant.getBusinessDescription());
		response.setCity(merchant.getCity());
		response.setZipcode(merchant.getZipcode());
		response.setCompanyRegistrationCertificateNumber(merchant.getCompanyRegistrationCertificateNumber());
		response.setIsBargainAllowed(merchant.getIsBargainAllowed());
		return response;
	}

	/**
	 * Domain response to Service Response for payment details.
	 * 
	 * @param merchant
	 *            domain response.
	 * @return service response.
	 */
	public MerchantPaymentDetailsResponseDTO toResponseWithPaymentDetails(MerchantPaymentDetails merchant) {
		MerchantPaymentDetailsResponseDTO response = new MerchantPaymentDetailsResponseDTO();
		response.setCompanyPanNumber(merchant.getCompanyPanNumber());
		response.setBeneficiaryName(merchant.getBeneficiaryName());
		response.setAccountNumber(merchant.getAccountNumber());
		response.setBank(merchant.getBank());
		response.setBankBranch(merchant.getBankBranch());
		response.setBankIFSCCode(merchant.getBankIFSCCode());
		return response;
	}

	/**
	 * Return data to render merchant dashboard.
	 * 
	 * @return merchant data relevant to painting merchant dashboard.
	 */
	public MerchantDetailsResponseDTO toResponseWithMerchantDetails() {
		MerchantDetailsResponseDTO response = new MerchantDetailsResponseDTO();
		response.setRegistrationId("N647647654665");
		response.setRating(4);
		response.setOrdersToday(24);
		response.setPendingOrders(16);
		response.setListingInStock(52);
		response.setListingOutOfStock(7);
		response.setPaymentSettled(506778);
		response.setPaymentUnSettled(324431);
		return response;
	}
/**
 * Create entity MerchantMaster with merchantId and registrationId
 * @param registrationId
 * @param merchantId
 * @return entity.
 */
	public MerchantMaster toEntityWithMasterDetails(String registrationId, String merchantId) {
		MerchantMaster merchant = new MerchantMaster();
		merchant.setRegistrationId(registrationId);
		MerchantMasterKey key = new MerchantMasterKey();
		key.setMerchantId(merchantId);
		merchant.setKey(key);
		return merchant;
	}

}
