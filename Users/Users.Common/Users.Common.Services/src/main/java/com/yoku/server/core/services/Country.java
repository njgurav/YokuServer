package com.yoku.server.core.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.yoku.server.core.dto.CountriesDTO;
import com.yoku.server.core.dto.CountryDTO;
import com.yoku.server.core.dto.PlaceDTO;
import com.yoku.server.core.dto.PlacesDTO;

public class Country {

	private static final Logger logger = Logger.getLogger(Country.class.getName());
	
	public Country(){
		
	}
	
	public CountriesDTO getCountries(){
		if(logger.isLoggable(Level.INFO))
			logger.log(Level.INFO, "Entered Country.getCountries()");
		
		CountriesDTO countries = new CountriesDTO();
		CountryDTO country = new CountryDTO();
		country.setCode("IN");
		country.setName("India");
		countries.setCountries(new CountryDTO[]{country});
		
		if(logger.isLoggable(Level.INFO))
			logger.log(Level.INFO, "Exiting Country.getCountries");
		
		return countries;
	}
	
	public CountryDTO getCountry(String countryid){
		if(logger.isLoggable(Level.INFO))
			logger.log(Level.INFO, "Entered Country.getCountries()");
		
		CountryDTO country = new CountryDTO();
		country.setCode("IN");
		country.setName("India");
		
		if(logger.isLoggable(Level.INFO))
			logger.log(Level.INFO, "Exiting Country.getCountries()");
		
		return country;
	}
	
	public PlacesDTO getPlaces(String countryid){
		if(logger.isLoggable(Level.INFO))
			logger.log(Level.INFO, "Entered Country.getPlaces()");
		

		PlacesDTO places = new PlacesDTO();
		PlaceDTO place = new PlaceDTO();
		place.setCode("BOM");
		place.setName("Mumbai");
		place.setIsPopular(true);
		place.setCountryCode("IN");
		
		places.setPlaces(new PlaceDTO[]{place});
		
		if(logger.isLoggable(Level.INFO))
			logger.log(Level.INFO, "Exiting Country.getPlaces()");
		
		return places;
	}
}
