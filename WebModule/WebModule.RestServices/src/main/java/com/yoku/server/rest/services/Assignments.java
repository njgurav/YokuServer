package com.yoku.server.rest.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.core.dto.AvailableAssignmentRequestDTO;
import com.yoku.server.core.dto.AvailableAssignmentResponseDTO;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;

@RestController
@RequestMapping("/assignments")
public class Assignments {
	
	private static final ILogger logger = LoggerFactory.getLogger(Assignments.class);
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=Constants.APPLICATION_JSON)
	public ResponseEntity<? extends Object> fetchAvailableAssignments(@RequestParam String latitude, @RequestParam String longitude) {
		
		logger.info("Entered REST service Assignments.fetchAvailableAssignments with arguments, latitude = " + latitude + ", longitude = " + longitude);
		
		ResponseEntity<? extends Object> restResponse = null ;
		AvailableAssignmentRequestDTO request = new AvailableAssignmentRequestDTO();
		try{
			request.setLatitude(Double.parseDouble(latitude));
			request.setLongitude(Double.parseDouble(longitude));
			
			com.yoku.server.core.services.Assignments assignments = new com.yoku.server.core.services.Assignments();
			AvailableAssignmentResponseDTO response = assignments.fetchAvailableAssignments(request);
			
			if(response==null){
				restResponse = new ResponseEntity<BaseDTO>((BaseDTO)null, HttpStatus.INTERNAL_SERVER_ERROR);
			}else{
				restResponse = new ResponseEntity<BaseDTO>(response, HttpStatus.OK);
			}
		}catch(NullPointerException e){
				logger.error("Required Params not specified in the url, latitude and longitude must be present in the query params", e);
				restResponse = new ResponseEntity<String>("Required Params not specified in the url, latitude and longitude must be present in the query params", HttpStatus.BAD_REQUEST);
		}catch(NumberFormatException e){
				logger.error( "Query params should be a Double value and nothing else", e);
				restResponse = new ResponseEntity<String>("Query params should be a Double value and nothing else", HttpStatus.BAD_REQUEST);
		}
		
		logger.info("Exiting REST service Assignments.fetchAvailableAssignments ");
		return restResponse;
		
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET, produces=Constants.TEXT_PLAIN)
	public ResponseEntity<String> testMethod(){
		return new ResponseEntity<String>("Hello Shrikant!", HttpStatus.OK);
	}

}
