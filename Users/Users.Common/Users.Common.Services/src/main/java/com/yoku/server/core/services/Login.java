package com.yoku.server.core.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.entity.core.IEntity;
import com.yoku.server.framework.entity.core.IEntityKey;
import com.yoku.server.framework.entity.customer.CustomerMaster;
import com.yoku.server.framework.entity.merchant.MerchantPrimaryDetails;
import com.yoku.server.fw.authentication.session.SessionManager;
import com.yoku.server.login.dto.LoginRequestDTO;
import com.yoku.server.login.dto.LoginResponseDTO;

/**
 * Login Service for merchant, customer and ninja
 */
public class Login extends AbstractService {
	/**
	 * Login Service for customer.
	 * 
	 * @param request
	 *            contains login request data
	 * @return LoginResponse containing authentication token value if login is
	 *         successful; auth token null otherwise.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LoginResponseDTO customerLogin(LoginRequestDTO request) {
		LoginResponseDTO response = new LoginResponseDTO();
		IRepositoryAdapter<IEntity, IEntityKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Login.customerLogin"));

		String query = "from CustomerMaster m where m.mobileNo=:userName";
		Map params = new HashMap();
		params.put("userName", request.getUserName());
		Iterator<CustomerMaster> custIterator = adapter.executeReadQuery(query, params).iterator();
		while (custIterator.hasNext()) {
			CustomerMaster customer = custIterator.next();
			if (request.getPassword().equals(customer.getPassword())) {
				response.setAuthenticationToken(generateAuthenticationToken());
				response.setIdirectedUserId(generateIndirectedId());
				new SessionManager().saveCustomer(customer.getKey().getCustomerId(), response.getIdirectedUserId(),
						response.getAuthenticationToken(), request.getDeviceId(), null);
			}else{
				//throw invalid login exception.
			}
			break;
		}

		return response;
	}

	/**
	 * Login Service for merchant.
	 * 
	 * @param request
	 *            contains login request data
	 * @return LoginResponse containing authentication token value if login is
	 *         successful; auth token null otherwise.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LoginResponseDTO merchantLogin(LoginRequestDTO request) {
		LoginResponseDTO response = new LoginResponseDTO();
		String merchantId = null;
		IRepositoryAdapter<IEntity, IEntityKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.Login.merchantLogin"));

		String query = "from MerchantPrimaryDetails m where m.phoneNumber=:userName";
		Map params = new HashMap();
		params.put("userName", request.getUserName());
		Iterator<MerchantPrimaryDetails> merchantIterator = adapter.executeReadQuery(query, params).iterator();
		while (merchantIterator.hasNext()) {
			MerchantPrimaryDetails merchant = merchantIterator.next();
			if (request.getPassword().equals(merchant.getPassword())) {
				query = "select merchant_id from merchant_master where registration_id=:registrationId";
				params = new HashMap();
				params.put("registrationId", merchant.getKey().getRegistrationId());
				List<?> merchantData = adapter.executeSQLQuery(query, params);
				if (!(merchantData.isEmpty())) {
					merchantId = (String) merchantData.get(0);
				}else{
					//throw invalid login exception
				}
				response.setAuthenticationToken(generateAuthenticationToken());
				response.setIdirectedUserId(generateIndirectedId());

				new SessionManager().saveMerchant(merchantId, response.getIdirectedUserId(),
						response.getAuthenticationToken(), request.getDeviceId(), null);
			}else{
				//throw invalid login exception.
			}
			break;
		}
		return response;
	}

	/**
	 * Generate login token for user authentication in subsequent requests.
	 * 
	 * @return Random Unique value.
	 */
	private String generateAuthenticationToken() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Generate Indirected value for a user Id.
	 * 
	 * @return Random Unique value.
	 */
	private String generateIndirectedId() {
		return UUID.randomUUID().toString();
	}
}
