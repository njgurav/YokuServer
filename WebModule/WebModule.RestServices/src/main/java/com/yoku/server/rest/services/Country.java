package com.yoku.server.rest.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.core.dto.CountriesDTO;
import com.yoku.server.core.dto.CountryDTO;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;

@RestController
@RequestMapping("/countries")
public class Country {
	
	private static final ILogger logger = LoggerFactory.getLogger(Country.class);
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getCountries(){
			logger.info( "Entered Country.getCountries()");
		
		com.yoku.server.core.services.Country country = new com.yoku.server.core.services.Country();
		CountriesDTO countries = country.getCountries();
		
		logger.info("Exiting Country.getCountries");
		
		return new ResponseEntity<BaseDTO>(countries, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{countryCode}", method=RequestMethod.GET, produces=Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getCountry(@PathVariable String countryCode){
			logger.info( "Entered Country.getCountries()");
		
		com.yoku.server.core.services.Country country = new com.yoku.server.core.services.Country();
		CountryDTO countryDTO = country.getCountry(countryCode);
		
			logger.info("Exiting Country.getCountries()");
		
		return new ResponseEntity<BaseDTO>(countryDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{countryCode}/places", method=RequestMethod.GET, produces=Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getPlaces(@PathVariable String countryCode){
			logger.info("Entered Country.getPlaces()");
		
		com.yoku.server.core.services.Country country = new com.yoku.server.core.services.Country();
		CountryDTO countryDTO = country.getCountry(countryCode);
		
			logger.info("Exiting Country.getPlaces()");
		
		return new ResponseEntity<BaseDTO>(countryDTO, HttpStatus.OK);
	}
	
}
