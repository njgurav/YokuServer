package com.yoku.server.rest.services.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.core.services.otp.OTPService;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.rest.services.AbstractRestService;
import com.yoku.server.sms.dto.OTPRequestDTO;
import com.yoku.server.sms.dto.OTPResponseDTO;

/**
 * SMS Rest operations. Create method.
 * 
 * All rest that validates OTP are written in their respective classes. They
 * should call
 * {@link com.yoku.server.core.services.otp.OTPService.validate(OTPValidateRequestDTO)}
 * and perform the needed task. 
 * 
 */
@RestController
@RequestMapping(value = "/sms")
public class OTP extends AbstractRestService {

	/**
	 * Create an OTP pin
	 */
	@RequestMapping(value = "/otp", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> create(@RequestBody OTPRequestDTO request) {
		OTPResponseDTO response = null;
		OTPService service = new OTPService();
		response = service.create(request);
		return super.buildResponse(HttpStatus.OK, response);
	}

}
