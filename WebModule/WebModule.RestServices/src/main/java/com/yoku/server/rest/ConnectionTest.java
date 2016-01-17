package com.yoku.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.infra.constants.Constants;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * To test Yoku Server connection
 */
@RestController
@RequestMapping("/yoku")
public class ConnectionTest extends AbstractRestService {
	/**
	 * public constructor
	 */
	public ConnectionTest() {
	}

	/**
	 * TEST REST Service
	 */
	@RequestMapping(method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<String> trial() {
		return new ResponseEntity<String>("Yoku server up and Running", HttpStatus.CONTINUE);
	}
}
