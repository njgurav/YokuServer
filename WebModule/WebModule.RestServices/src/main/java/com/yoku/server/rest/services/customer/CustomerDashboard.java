package com.yoku.server.rest.services.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.core.services.Customer;
import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.customer.dashboard.NearByMerchantsRequestDTO;
import com.yoku.server.framework.dto.customer.dashboard.NearByMerchantsResponseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.rest.services.AbstractRestService;
import com.yoku.server.rest.services.merchant.Merchant;

/**
 * Provides services to display content on customers dashboard.
 */
@RestController
@RequestMapping(value = "/customer/{customerId}")
public class CustomerDashboard extends AbstractRestService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(Merchant.class);

	/**
	 * Provides nearby merchants list.
	 * 
	 * @param latitude
	 *            customers current location
	 * @param longitude
	 *            customers current longitude
	 * @param radius
	 *            the radius to look merchants into (in Kms). Default set to 20 kms
	 * @param customerId
	 *            customer id.
	 * @return list of Merchants that
	 */
	@RequestMapping(value = "/merchants", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> fetchNearbyMerchants(@RequestParam(value = "lat") String latitude,
			@RequestParam(value = "long") String longitude,
			@RequestParam(value = "radius", defaultValue = "20") String radius,
			@PathVariable(value = "customerId") String customerId) {
		NearByMerchantsResponseDTO response = null;
		HttpStatus status = null;
		try {
			String custId = super.beginCustomerSession(customerId);
			Customer service = new Customer(custId);
			NearByMerchantsRequestDTO request = new NearByMerchantsRequestDTO();
			request.setLatitude(latitude);
			request.setLongitude(longitude);
			request.setRadius(radius);
			response = service.fetchNearbyMerchants(request);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

}
