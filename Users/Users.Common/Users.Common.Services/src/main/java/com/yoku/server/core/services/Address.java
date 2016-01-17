package com.yoku.server.core.services;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.framework.assembler.common.AddressAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.dto.TransactionStatus;
import com.yoku.server.framework.entity.common.AddressKey;
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
	 * Id can be merchantId, customerId, orderId, etc.
	 */
	private String addressId;

	/**
	 * Constructor
	 * 
	 * @param addressId
	 *            AddressId.
	 */
	public Address(String addressId) {
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
	 * @param id
	 *            To store address against in the database. Id can be
	 *            merchantId, customerId, orderId, etc.
	 * @param addressDTO
	 *            Address containing data to be stored in the database.
	 * @return status of the operation.
	 */
	@SuppressWarnings("unchecked")
	public TransactionStatus save(AddressDTO addressDTO) {
		TransactionStatus status = new TransactionStatus();

		logger.info("Inside Address Core Service, AddressID : " + addressId + " Saving Address : " + addressDTO);
		addressDTO.setId(addressId);
		com.yoku.server.framework.entity.common.Address address = new AddressAssembler().toEntity(addressDTO);
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.save"));
		adapter.save(address);
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

		logger.info("Inside Address Core Service, AddressID : " + addressId + " Updating Address : " + addressDTO);
		addressDTO.setId(addressId);
		com.yoku.server.framework.entity.common.Address address = new AddressAssembler().toEntity(addressDTO);
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.update"));
		adapter.update(address);
		status.setStatus(TransactionStatus.Status.SUCCESS);
		return status;
	}

	/**
	 * Read address for the provided id in the application.
	 * 
	 * @return address for the provided Id.
	 */
	@SuppressWarnings("unchecked")
	public AddressDTO read() {
		AddressDTO response = null;
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.read"));
		AddressKey key = new AddressKey();
		key.setId(addressId);
		com.yoku.server.framework.entity.common.Address address = adapter
				.fetch(com.yoku.server.framework.entity.common.Address.class, key);
		response = new AddressAssembler().fromEntity(address);
		return response;
	}

	/**
	 * Delete address for the provided id in the application.
	 * 
	 * @return address for the provided Id.
	 */

	@SuppressWarnings("unchecked")
	public TransactionStatus delete() {
		TransactionStatus status = new TransactionStatus();
		IRepositoryAdapter<com.yoku.server.framework.entity.common.Address, AddressKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Address.delete"));
		AddressKey key = new AddressKey();
		key.setId(addressId);
		com.yoku.server.framework.entity.common.Address address = adapter
				.fetch(com.yoku.server.framework.entity.common.Address.class, key);
		adapter.delete(address);
		status.setStatus(TransactionStatus.Status.SUCCESS);
		return status;
	}

}
