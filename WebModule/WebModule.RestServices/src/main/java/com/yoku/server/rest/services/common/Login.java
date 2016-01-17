package com.yoku.server.rest.services.common;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.login.dto.LoginRequestDTO;
import com.yoku.server.login.dto.LoginResponseDTO;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * REST for Login service.
 */
@RestController
@RequestMapping("/login")
public class Login extends AbstractRestService {

	/**
	 * Login service for Customer. If Login is successful, it will add
	 * auth-token in response header.
	 * 
	 * @param request
	 *            contains login parameters like user name, password and
	 *            deviceId.
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> customerLogin(@RequestBody LoginRequestDTO request,
			final HttpServletResponse sResponse) {
		HttpStatus status = null;
		com.yoku.server.core.services.Login loginService = new com.yoku.server.core.services.Login();
		LoginResponseDTO response = loginService.customerLogin(request);
		String authToken = response.getAuthenticationToken();
		if (authToken != null) {
			sResponse.setHeader("auth-token", authToken);
			sResponse.setHeader("user-hash", response.getIdirectedUserId());
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}

		return super.buildResponse(status, null);
	}
	
	/**
	 * Login service for merchant. If Login is successful, it will add
	 * auth-token in response header.
	 * 
	 * @param request
	 *            contains login parameters like user name, password and
	 *            deviceId.
	 */
	@RequestMapping(value = "/merchant", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> merchantLogin(@RequestBody LoginRequestDTO request,
			final HttpServletResponse sResponse) {
		HttpStatus status = null;
		com.yoku.server.core.services.Login loginService = new com.yoku.server.core.services.Login();
		
		LoginResponseDTO response = loginService.merchantLogin(request);
		String authToken = response.getAuthenticationToken();
		if (authToken != null) {
			sResponse.setHeader("auth-token", authToken);
			sResponse.setHeader("user-hash", response.getIdirectedUserId());
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}

		return super.buildResponse(status, null);
	}
}
