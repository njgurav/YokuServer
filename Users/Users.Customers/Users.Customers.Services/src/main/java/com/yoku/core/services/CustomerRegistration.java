package com.yoku.core.services;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.services.AbstractService;
import com.yoku.server.framework.alerts.AlertsManager;
import com.yoku.server.framework.alerts.events.Event;
import com.yoku.server.framework.assembler.customer.CustomerAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.dto.customer.registration.CustomerRegistrationRequestDTO;
import com.yoku.server.framework.entity.customer.Customer;
import com.yoku.server.framework.entity.customer.CustomerKey;
import com.yoku.server.framework.entity.customer.CustomerMaster;
import com.yoku.server.framework.entity.customer.CustomerMasterKey;
import com.yoku.server.infra.dtos.UserContext;
import com.yoku.server.infra.idgeneration.factory.AbstractIdGeneratorFactory;
import com.yoku.server.infra.idgeneration.factory.GeneratorType;
import com.yoku.server.infra.idgeneration.generators.IIdGenerator;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;

/**
 * Customer Registration and Account Activation service
 */
public class CustomerRegistration extends AbstractService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(CustomerRegistration.class);

	/**
	 * Gets customer registration data from client. Generates registration id
	 * and saves registration data into database.
	 * 
	 * @param request
	 *            contains customer registration data like EmailId, Mobile
	 *            Number, etc.
	 * @return status of operation of customer registration.
	 */
	@SuppressWarnings("unchecked")
	public boolean register(CustomerRegistrationRequestDTO request) {
		UserContext context = new UserContext();
		// generate registration Id
		IIdGenerator<String> generator = AbstractIdGeneratorFactory.getIdGenerator(GeneratorType.CUSTOMER_ONBOARD_ID);
		String registrationId = generator.nextId();

		Customer customer = new CustomerAssembler().toRegistrationEntity(request);
		customer.getKey().setRegistrationId(registrationId);

		IRepositoryAdapter<Customer, CustomerKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.core.services.CustomerRegistration.register"));
		logger.info("New Customer Registration initiated. Registration ID : " + registrationId);
		adapter.save(customer);
		// Send mail to the registered email Id for email verification and
		// customer account activation.
		context.setFirstName(request.getName());
		context.setEmailId(request.getEmailId());
		context.setMobileNo(request.getMobileNo());

		AlertsManager.getInstance().alert(context, Event.MERCHANT_CREATION_SUCCESSFUL,
				"Registration completed successfully. Please verify your email for account activation.",
				getActivationId(registrationId));

		return false;
	}

	/**
	 * Service to activate customer account based on the activation Id provided.
	 * 
	 * @param activationId
	 *            activationId to identify customer account.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean activate(String activationId) {
		UserContext context = new UserContext();
		String registrationId = getRegistrationId(activationId);
		IRepositoryAdapter<Customer, CustomerKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.core.services.CustomerRegistration.activate"));
		CustomerKey key = new CustomerKey();
		key.setRegistrationId(registrationId);
		Customer customer = adapter.fetch(Customer.class, key);
		CustomerMaster custMaster = new CustomerAssembler().toCustMasterEntity(customer);
		// generate registration Id
		IIdGenerator<String> generator = AbstractIdGeneratorFactory.getIdGenerator(GeneratorType.CUSTOMER_ID);
		String customerId = generator.nextId();
		custMaster.getKey().setCustomerId(customerId);
		IRepositoryAdapter<CustomerMaster, CustomerMasterKey> custMasterAdapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.core.services.CustomerRegistration.activate"));
		custMasterAdapter.save(custMaster);
		context.setFirstName(custMaster.getName());
		context.setEmailId(custMaster.getEmailId());
		context.setMobileNo(custMaster.getMobileNo());
		AlertsManager.getInstance().alert(context, Event.MERCHANT_CREATION_SUCCESSFUL,
				"Account created successfully. Customer Id : " + customerId);
		return true;
	}

	/**
	 * Operates on registration Id to generate account activation Id.
	 * 
	 * @param registrationId
	 *            registrationId for customer account.
	 * @return account activation Id.
	 */
	private String getActivationId(String registrationId) {
		return registrationId;
	}

	/**
	 * Operates on activation Id to extract registrationId
	 * 
	 * @param activationId
	 * @return
	 */
	private String getRegistrationId(String activationId) {
		return activationId;
	}

}
