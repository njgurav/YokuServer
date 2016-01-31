package com.yoku.core.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.queries.QueryConstants;
import com.yoku.server.core.services.AbstractService;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.dto.customer.dashboard.NearByMerchantDTO;
import com.yoku.server.framework.dto.customer.dashboard.NearByMerchantsRequestDTO;
import com.yoku.server.framework.dto.customer.dashboard.NearByMerchantsResponseDTO;
import com.yoku.server.framework.dto.merchant.registration.MerchantPrimaryDetailsResponseDTO;
import com.yoku.server.framework.entity.core.IEntity;
import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Contains services for customer activities.
 *
 */
public class Customer extends AbstractService {

	/**
	 * Customer Id to initialize this class
	 */
	private String customerId;

	/**
	 * Constructor
	 * 
	 * @param customerId
	 */
	public Customer(String customerId) {
		setCustomerId(customerId);
	}

	/**
	 * Default constructor private
	 */
	@SuppressWarnings("unused")
	private Customer() {
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Return a list of Merchants that lie within the specified radius.
	 * 
	 * @param request
	 *            request data contains current location and requested radius.
	 * @return merchant list.
	 */
	@SuppressWarnings("unchecked")
	public NearByMerchantsResponseDTO fetchNearbyMerchants(NearByMerchantsRequestDTO request) {
		NearByMerchantsResponseDTO response = null;
		
		IRepositoryAdapter<IEntity, IEntityKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.core.services.Customer.fetchNearbyMerchants"));

		String query = QueryConstants.FETCH_NEARBY_MERCHANTS;
		Map<String, String> params = new HashMap<String, String>();
		params.put("radius", request.getRadius());
		params.put("cur_lat", request.getLatitude());
		params.put("cur_long", request.getLongitude());

		List<?> merchants = adapter.executeSQLQuery(query, params);

		if (!merchants.isEmpty()) {
			response = new NearByMerchantsResponseDTO();
			// merchants list contains nearby merchants data.
			NearByMerchantDTO[] merchantData = new NearByMerchantDTO[merchants.size()];
			Iterator<?> merchantIterator = merchants.iterator();
			int index = 0;
			while(merchantIterator.hasNext()){
				Object[] merchant = (Object[]) merchantIterator.next();
				merchantData[index] = new NearByMerchantDTO();
				MerchantPrimaryDetailsResponseDTO merchantDetails = new MerchantPrimaryDetailsResponseDTO();
				merchantData[index].setMerchantId((String) merchant[0]);
				merchantDetails.setCompanyName((String)merchant[1]);
				merchantDetails.setPhoneNumber((String) merchant[2]);
				merchantDetails.setBusinessType((String)merchant[3]);
				merchantData[index].setMerchants(merchantDetails);
			}
			response.setMerchants(merchantData);
			
			
		} else {
			// no merchants in the specified radius.

		}

		return response;
	}

}
