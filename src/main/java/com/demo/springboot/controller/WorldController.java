package com.demo.springboot.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.entity.City;
import com.demo.springboot.entity.Country;
import com.demo.springboot.entity.CountryLanguage;
import com.demo.springboot.entity.CountryLanguagePK;
import com.demo.springboot.repository.CityRepository;
import com.demo.springboot.repository.CountryLanguageRepository;
import com.demo.springboot.repository.CountryRepository;

@RestController
@RequestMapping("/api")
public class WorldController {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CountryLanguageRepository countryLanguageRepository;
	
	// Get All Notes
	@GetMapping("/country")
	public List<Country> getAllCountries() {
	    return countryRepository.findAll();
	}
	
	
	// Create a new Note
	@GetMapping("/create/country")
	public Country createNote() {
		
		City capitalCity = new City("capital", "district", 237500);
		
		City ruralCity = new City("ruralcity", "ruraldistrict", 123456);
		
		CountryLanguage countryLanguage = new CountryLanguage();
		countryLanguage.setCountryLanguagePK(new CountryLanguagePK("test language"));
		countryLanguage.setIsOfficial("T");
		countryLanguage.setPercentage(55);
		
		
		Country country = new Country();
		country.setCode("T1");
		country.setName("test");
		country.setContinent("Europe");
		country.setRegion("test region");
		country.setSurfaceArea((float) 193.0);
		country.setPopulation(123456);
		country.setLifeExpectancy((float) 88);
		country.setGnp((float) 828);
		country.setLocalName("test local");
		country.setGovernmentForm("test govt");
		country.setHeadOfState("test head");
		country.setCapital(capitalCity);
		country.setCode2("T1");
		
		Set city = new HashSet<City>(){{
            add(capitalCity);
            add(ruralCity);
        }};
        
        country.setCitySet(city);
        
        capitalCity.setCountry(country);
        ruralCity.setCountry(country);
		
		Set language = new HashSet<CountryLanguage>() {{
			add(countryLanguage);
		}};
		country.setCountryLanguageSet(language);
		countryLanguage.getCountryLanguagePK().setCountry(country);
		
		
	    return countryRepository.save(country);
	} 
	

}
