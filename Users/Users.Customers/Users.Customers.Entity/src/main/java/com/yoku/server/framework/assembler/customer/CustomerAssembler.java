package com.yoku.server.framework.assembler.customer;

import com.yoku.server.core.assembler.IAssembler;
import com.yoku.server.framework.dto.customer.registration.CustomerRegistrationRequestDTO;
import com.yoku.server.framework.entity.customer.Customer;
import com.yoku.server.framework.entity.customer.CustomerKey;
import com.yoku.server.framework.entity.customer.CustomerMaster;
import com.yoku.server.framework.entity.customer.CustomerMasterKey;

/**
 * Converts Request and response DTOs into entities and vice-versa for Customers
 */
public class CustomerAssembler implements IAssembler {
	/**
	 * Returns customer registration entity.
	 * 
	 * @param request
	 *            request data from client.
	 * @return registration entity.
	 */
	public Customer toRegistrationEntity(CustomerRegistrationRequestDTO request) {
		Customer customer = new Customer();
		CustomerKey key = new CustomerKey();
		customer.setName(request.getName());
		customer.setEmailId(request.getEmailId());
		customer.setMobileNo(request.getMobileNo());
		customer.setPassword(request.getPassword());
		customer.setKey(key);

		return customer;
	}

	/**
	 * Returns customer entity to add to customer master table which indicates
	 * customer account is created successfully and activated.
	 */
	public CustomerMaster toCustMasterEntity(Customer customer){
		CustomerMaster custMaster = new CustomerMaster();
		custMaster.setEmailId(customer.getEmailId());
		custMaster.setName(customer.getName());
		custMaster.setMobileNo(customer.getMobileNo());
		custMaster.setPassword(customer.getPassword());
		custMaster.setRegistration_id(customer.getKey().getRegistrationId());
		CustomerMasterKey key = new CustomerMasterKey();
		custMaster.setKey(key);
		
		return custMaster;
	}
}
