package com.yoku.server.core.services;

import java.util.List;

import com.yoku.server.address.dto.AddressReadResponseDTO;
import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.framework.assembler.common.AddressAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.framework.entity.common.AddressKey;
import com.yoku.server.framework.entity.core.IEntity;
import com.yoku.server.framework.entity.core.IEntityKey;
import com.yoku.server.infra.idgeneration.factory.AbstractIdGeneratorFactory;
import com.yoku.server.infra.idgeneration.factory.GeneratorType;
import com.yoku.server.infra.idgeneration.generators.IIdGenerator;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;

/**
 * Address management service. Default constructor is declared private. Cannot
 * instantiate this service without an addressId.
 */
public class Address extends AbstractService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(Address.class);
	/**
	 * Address Id to uniquely identify stored entries
	 */
	private String addressId;

	/**
	 * User Id to fetch and store addresses from and into the data store.
	 */
	private String userId;

	/**
	 * Constructor. Initialize service with userId.
	 * 
	 * @param userId
	 *            userId to make entry against or to fetch data against.
	 */
	public Address(String userId) {
		this.setUserId(userId);
	}

	/**
	 * Constructor. Initialize service with userId and addressId
	 * 
	 * @param userId
	 *            userId to make entry against or to fetch data against.
	 * @param addressId
	 *            To perform operations on an individual address identified by
	 *            addressId
	 */
	public Address(String userId, String addressId) {
		this.setUserId(userId);
		this.setAddressId(addressId);
	}

	/**
	 * Default constructor private. Cannot initialize this service without an
	 * addressId.
	 */
	@SuppressWarnings("unused")
	private Address() {
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	/**
	 * Add address for the provided id in the application.
	 * 
	 * To store address in the database, generate an AddressId.
	 * 
	 * UserId can be merchantId, customerId, orderId (a temporary delivery
	 * address), etc. in case a customer stores more than one address as
	 * preference.
	 * 
	 * @param addressDTO
	 *            Address containing data to be stored in the database.
	 * @return status of the operation.
	 */
	@SuppressWarnings("unchecked")
	public TransactionStatus save(AddressDTO addressDTO) {
		TransactionStatus status = new TransactionStatus();

		logger.info(
				"Inside Address Core Service, saving address for : " + getUserId() + " Saving Address : " + addressDTO);
		IIdGenerator<String> generator = AbstractIdGeneratorFactory.getIdGenerator(GeneratorType.ADDRESS_ID);
		addressDTO.setId(generator.nextId());
		addressDTO.setUserId(getUserId());
		com.yoku.server.framework.entity.common.Address address = new AddressAssembler().toEntity(addressDTO);
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.save"));
		adapter.save(address);
		status.setStatus(TransactionStatus.Status.SUCCESS);

		return status;
	}

	/**
	 * Reads all address for the provided userId in the application. (basis
	 * userId)
	 * 
	 * @return address for the provided Id.
	 */
	@SuppressWarnings("unchecked")
	public AddressReadResponseDTO read() {
		logger.info("Inside Address Core Service, to read all addresses for userId :" + getUserId());
		AddressReadResponseDTO response = new AddressReadResponseDTO();
		IRepositoryAdapter<IEntity, IEntityKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.read"));

		String query = "from Address a where a.userId ='" + getUserId() + "'";
		List<com.yoku.server.framework.entity.common.Address> addresses = adapter.executeReadQuery(query);
		if (!addresses.isEmpty()) {
			AddressDTO[] addressDTOs = new AddressDTO[addresses.size()];
			AddressAssembler assembler = new AddressAssembler();
			for (int index = 0; index < addresses.size(); index++) {
				com.yoku.server.framework.entity.common.Address address = addresses.get(index);
				addressDTOs[index] = assembler.fromEntity(address);
			}
			response.setAddresses(addressDTOs);
		}

		return response;
	}
	
	/**
	 * Deletes all address for the provided userId in the application. (basis
	 * userId)
	 * 
	 * @return status of the operation.
	 */
	@SuppressWarnings("unchecked")
	public TransactionStatus deleteAll() {
		TransactionStatus status = new TransactionStatus();

		logger.info(
				"Inside Address Core Service, delting address for : " + getUserId());
		
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.save"));
		String query = "delete Address a where a.userId='"+ getUserId() + "'";
		
		adapter.executeUpdateQuery(query);
		status.setStatus(TransactionStatus.Status.SUCCESS);

		return status;
	}
	/**
	 * Update address for the provided id in the application.
	 * 
	 * @param addressDTO
	 *            Address containing data to be stored in the database.
	 * @return status of the operation.
	 */
	@SuppressWarnings("unchecked")
	public TransactionStatus update(AddressDTO addressDTO) {
		TransactionStatus status = new TransactionStatus();

		logger.info("Inside Address Core Service, updating AddressID : " + getAddressId() + " Updating Address : "
				+ addressDTO + " for user :" + getUserId());
		addressDTO.setId(getAddressId());
		addressDTO.setUserId(getUserId());
		com.yoku.server.framework.entity.common.Address address = new AddressAssembler().toEntity(addressDTO);
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.update"));
		adapter.update(address);
		status.setStatus(TransactionStatus.Status.SUCCESS);
		return status;
	}

	/**
	 * Delete address for the provided AddressId in the application.
	 * 
	 * @return address for the provided Id.
	 */
	@SuppressWarnings("unchecked")
	public TransactionStatus delete() {
		logger.info(
				"Inside Address Core Service, deleting AddressID : " + getAddressId() + " for user : " + getUserId());
		TransactionStatus status = new TransactionStatus();
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.delete"));
		AddressKey key = new AddressKey();
		key.setId(getAddressId());
		com.yoku.server.framework.entity.common.Address address = new com.yoku.server.framework.entity.common.Address();
				//adapter.fetch(com.yoku.server.framework.entity.common.Address.class, key);
		address.setKey(key);
		adapter.delete(address);
		status.setStatus(TransactionStatus.Status.SUCCESS);
		return status;
	}

}
