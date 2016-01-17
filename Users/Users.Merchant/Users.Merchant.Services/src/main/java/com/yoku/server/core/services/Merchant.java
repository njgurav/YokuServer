package com.yoku.server.core.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.framework.alerts.AlertsManager;
import com.yoku.server.framework.alerts.events.Event;
import com.yoku.server.framework.assembler.merchant.MerchantAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.dto.merchant.MerchantDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.MerchantIdResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantBusinessDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPaymentDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantRegistrationDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantRegistrationIdResponseDTO;
import com.yoku.server.framework.entity.core.IEntity;
import com.yoku.server.framework.entity.core.IEntityKey;
import com.yoku.server.framework.entity.merchant.MerchantBusinessDetails;
import com.yoku.server.framework.entity.merchant.MerchantKey;
import com.yoku.server.framework.entity.merchant.MerchantMaster;
import com.yoku.server.framework.entity.merchant.MerchantMasterKey;
import com.yoku.server.framework.entity.merchant.MerchantPaymentDetails;
import com.yoku.server.framework.entity.merchant.MerchantPrimaryDetails;
import com.yoku.server.infra.dtos.UserContext;
import com.yoku.server.infra.idgeneration.factory.AbstractIdGeneratorFactory;
import com.yoku.server.infra.idgeneration.factory.GeneratorType;
import com.yoku.server.infra.idgeneration.generators.IIdGenerator;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;

/**
 * Merchant service to save merchant details step by step in a registration
 * process. Provides functionality to save and retrieve details of any step in
 * any arbitrary position in time.
 */
public class Merchant extends AbstractService {
	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(Merchant.class);

	/**
	 * RegistrationId for saving details of merchant.
	 */
	private String registrationId;

	/**
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId
	 *            the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	/**
	 * Public constructor
	 * 
	 * @param regId
	 *            Registration Id to set for saving details.
	 */
	public Merchant(String regId) {
		setRegistrationId(regId);
	}

	/**
	 * Save Primary details of applying merchant.
	 * 
	 * @param coreRequest
	 * @return merchant registration status.
	 */
	@SuppressWarnings("unchecked")
	public boolean savePrimaryDetails(MerchantRegistrationDTO coreRequest) {
		logger.info("Inside Merchant Registration Core Service, Saving Primary Details : " + coreRequest);
		coreRequest.setRegistrationId(registrationId);
		MerchantPrimaryDetails merchant = new MerchantAssembler().toEntityWithPrimaryDetails(coreRequest);
		IRepositoryAdapter<MerchantPrimaryDetails, MerchantKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.savePrimaryDetails"));
		logger.info("Calling adapter.save() in core Service");
		adapter.save(merchant);

		return new MerchantHelper().updateStatus();
	}

	/**
	 * Save Business details of applying merchant.
	 * 
	 * @param coreRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean saveBusinessDetails(MerchantRegistrationDTO coreRequest) {
		coreRequest.setRegistrationId(registrationId);
		MerchantBusinessDetails merchant = new MerchantAssembler().toEntityWithBusinessDetails(coreRequest);
		IRepositoryAdapter<MerchantBusinessDetails, MerchantKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(
						super.getORMProvider("com.yoku.server.core.services.Merchant.saveBusinessDetails"));
		logger.info("Calling adapter.save() in core Service");
		adapter.save(merchant);
		return new MerchantHelper().updateStatus();
	}

	/**
	 * Save Payment details of applying merchant.
	 * 
	 * @param coreRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean savePaymentDetails(MerchantRegistrationDTO coreRequest) {
		coreRequest.setRegistrationId(registrationId);
		MerchantPaymentDetails merchant = new MerchantAssembler().toEntityWithPaymentDetails(coreRequest);
		IRepositoryAdapter<MerchantPaymentDetails, MerchantKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.savePaymentDetails"));
		logger.info("Calling adapter.save() in core Service");
		adapter.save(merchant);
		return new MerchantHelper().updateStatus();
	}

	/**
	 * Update Primary details of applying merchant.
	 * 
	 * @param coreRequest
	 * @return merchant registration status.
	 */
	@SuppressWarnings("unchecked")
	public boolean updatePrimaryDetails(MerchantRegistrationDTO coreRequest) {
		logger.info("Inside Merchant Registration Core Service, Saving Primary Details : " + coreRequest);
		coreRequest.setRegistrationId(registrationId);
		MerchantPrimaryDetails merchant = new MerchantAssembler().toEntityWithPrimaryDetails(coreRequest);
		IRepositoryAdapter<MerchantPrimaryDetails, MerchantKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.savePrimaryDetails"));
		logger.info("Calling adapter.update() in core Service");
		adapter.update(merchant);

		return new MerchantHelper().updateStatus();
	}

	/**
	 * Update Business details of applying merchant.
	 * 
	 * @param coreRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean updateBusinessDetails(MerchantRegistrationDTO coreRequest) {
		coreRequest.setRegistrationId(registrationId);
		MerchantBusinessDetails merchant = new MerchantAssembler().toEntityWithBusinessDetails(coreRequest);
		IRepositoryAdapter<MerchantBusinessDetails, MerchantKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(
						super.getORMProvider("com.yoku.server.core.services.Merchant.saveBusinessDetails"));
		logger.info("Calling adapter.update() in core Service");
		adapter.update(merchant);
		return new MerchantHelper().updateStatus();
	}

	/**
	 * Update Payment details of applying merchant.
	 * 
	 * @param coreRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean updatePaymentDetails(MerchantRegistrationDTO coreRequest) {
		coreRequest.setRegistrationId(registrationId);
		MerchantPaymentDetails merchant = new MerchantAssembler().toEntityWithPaymentDetails(coreRequest);
		IRepositoryAdapter<MerchantPaymentDetails, MerchantKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.savePaymentDetails"));
		logger.info("Calling adapter.update() in core Service");
		adapter.update(merchant);
		return new MerchantHelper().updateStatus();
	}

	/**
	 * Generate registration Id for applying merchant.
	 * 
	 * @return DTO containing registration Id.
	 */
	@SuppressWarnings("unchecked")
	public MerchantRegistrationIdResponseDTO register() {
		MerchantRegistrationIdResponseDTO response = new MerchantRegistrationIdResponseDTO();
		IIdGenerator<String> generator = AbstractIdGeneratorFactory.getIdGenerator(GeneratorType.MERCHANT_ONBOARD_ID);
		registrationId = generator.nextId();

		com.yoku.server.framework.entity.merchant.Merchant merchant = new MerchantAssembler().entity(registrationId);

		IRepositoryAdapter<com.yoku.server.framework.entity.merchant.Merchant, MerchantKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Merchant.register"));
		logger.info("New Merchant Registration initiated. Registration ID : " + registrationId + ". Initiated on : "
				+ merchant.getInitiatedOn());
		adapter.save(merchant);

		response.setRegistrationId(registrationId);
		return response;
	}

	/**
	 * Fetches primary details of the registering merchant if already saved. Use
	 * this service for completing incomplete registrations.
	 * 
	 * @return Saved Primary details of the Merchant.
	 */
	@SuppressWarnings("unchecked")
	public MerchantPrimaryDetailsResponseDTO fetchPrimaryDetails() {
		MerchantPrimaryDetailsResponseDTO response = null;
		IRepositoryAdapter<MerchantPrimaryDetails, MerchantKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.fetchPrimaryDetails"));
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(registrationId);
		MerchantPrimaryDetails merchant = adapter.fetch(MerchantPrimaryDetails.class, key);
		if (merchant != null) {
			response = new MerchantAssembler().toResponseWithPrimaryDetails(merchant);
		}
		return response;
	}

	/**
	 * Fetches business details of the registering merchant if already saved.
	 * Use this service for completing incomplete registrations.
	 * 
	 * @return Saved business details of the Merchant.
	 */
	@SuppressWarnings("unchecked")
	public MerchantBusinessDetailsResponseDTO fetchBusinessDetails() {
		MerchantBusinessDetailsResponseDTO response = null;
		IRepositoryAdapter<MerchantBusinessDetails, MerchantKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(
						super.getORMProvider("com.yoku.server.core.services.Merchant.fetchBusinessDetails"));
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(registrationId);
		MerchantBusinessDetails merchant = adapter.fetch(MerchantBusinessDetails.class, key);
		if (merchant != null) {
			response = new MerchantAssembler().toResponseWithBusinessDetails(merchant);
		}
		return response;
	}

	/**
	 * Fetches payment details of the registering merchant if already saved. Use
	 * this service for completing incomplete registrations.
	 * 
	 * @return Saved payment details of the Merchant.
	 */
	@SuppressWarnings("unchecked")
	public MerchantPaymentDetailsResponseDTO fetchPaymentDetails() {
		MerchantPaymentDetailsResponseDTO response = null;
		IRepositoryAdapter<MerchantPaymentDetails, MerchantKey> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.Merchant.fetchPaymentDetails"));
		MerchantKey key = new MerchantKey();
		key.setRegistrationId(registrationId);
		MerchantPaymentDetails merchant = adapter.fetch(MerchantPaymentDetails.class, key);
		if (merchant != null) {
			response = new MerchantAssembler().toResponseWithPaymentDetails(merchant);
		}
		return response;
	}

	/**
	 * Fetch data from table 'merchant_master' to render dashboard.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MerchantDetailsResponseDTO fetchDetails(String merchantId) {
		MerchantDetailsResponseDTO response = null;
		IRepositoryAdapter<MerchantMaster, MerchantMasterKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Merchant.fetchDetails"));
		MerchantMasterKey key = new MerchantMasterKey();
		key.setMerchantId(merchantId);
		// MerchantMaster merchant = adapter.fetch(MerchantMaster.class, key);
		response = new MerchantAssembler().toResponseWithMerchantDetails();
		return response;
	}

	/**
	 * Generate new Merchant Id if one does not already exist for the provided
	 * registrationId. Create an alert and notify merchant about successful
	 * registration and Id Generation. Create new Login credentials for the
	 * merchant.
	 *
	 * This method can be optimized by reducing database calls.
	 *
	 * @param registrationId
	 *            Registration Id for merchant.
	 * @return Merchant Id for this merchant.
	 */
	@SuppressWarnings("unchecked")
	public MerchantIdResponseDTO getMerchantId(String registrationId) {
		MerchantIdResponseDTO response = new MerchantIdResponseDTO();
		UserContext context = new UserContext();
		MerchantMaster merchant = null;
		IRepositoryAdapter<IEntity, IEntityKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Merchant.getMerchantId"));
		String query = "from MerchantMaster m where m.registrationId = '" + registrationId + "'";

		List<?> merchants = adapter.executeReadQuery(query);
		if (!merchants.isEmpty()) {
			Iterator<MerchantMaster> it = (Iterator<MerchantMaster>) merchants.iterator();
			merchant = it.next();
			response.setMerchantId(merchant.getKey().getMerchantId());
		} else {
			adapter = RepositoryAdapterFactory
					.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Merchant.getMerchantId"));
			query = "SELECT m.registration_id,s.merchant_name,y.email_id,y.phone_number FROM mer_reg_master m join mer_reg_primary y on (m.registration_id = y.registration_id and m.registration_id=:reg_id) JOIN mer_reg_business s on (m.registration_id = s.registration_id ) JOIN mer_reg_payment t on (m.registration_id = t.registration_id)";
			Map params = new HashMap();
			params.put("reg_id", registrationId);
			merchants = adapter.executeSQLQuery(query, params);
			if (!merchants.isEmpty()) {
				// also check if email and mobile number is verified

				// merchants List element 0 content : [M20151122002102616,
				// Dhanadesh joglekar, united11@yoku.com, 1000909090]
				IIdGenerator<String> generator = AbstractIdGeneratorFactory.getIdGenerator(GeneratorType.MERCHANT_ID);
				String merchantId = generator.nextId();
				IRepositoryAdapter<com.yoku.server.framework.entity.merchant.MerchantMaster, MerchantMasterKey> mmadapter = RepositoryAdapterFactory
						.getRepositoryAdapter(
								super.getORMProvider("com.yoku.server.core.services.Merchant.getMerchantId"));
				merchant = new MerchantAssembler().toEntityWithMasterDetails(registrationId, merchantId);
				mmadapter.save(merchant);
				response.setMerchantId(merchantId);
				Object[] details = (Object[]) merchants.get(0);
				response.setName((String) details[1]);
				context.setFirstName((String) details[1]);
				context.setEmailId((String) details[2]);
				context.setMobileNo((String) details[3]);

				AlertsManager.getInstance().alert(context, Event.MERCHANT_CREATION_SUCCESSFUL,
						"Merchant Registration completed successfully. Merchant Id : " + merchantId);

			} else {
				System.out.println("Merchaant registration incomplete");
			}
		}
		return response;
	}

	/**
	 * Utility class for Merchant Registration service.
	 */
	private class MerchantHelper {
		/**
		 * Calculate merchant registration status based on different parameters.
		 * 
		 * @return current status of merchant registration.
		 */
		boolean updateStatus() {
			// TO-DO : check if all tables contains entries for merchant
			// registration and set flag to true or false accordingly.
			return false;
		}
	}

}
