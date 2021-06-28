package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.example.demo.Country;
import com.example.demo.SpringLearnApplication;

import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CountryController {
	@RequestMapping(method = RequestMethod.GET,value ="/countries")			
	public List<Country> getallCountries(){
		SpringLearnApplication springrest= new SpringLearnApplication();
		return springrest.displayCountries();
	}
	@RequestMapping(method = RequestMethod.GET,value ="/country")			
	public Country getCountryIndia(){
		SpringLearnApplication springrest= new SpringLearnApplication();
		return springrest.displayCountry();
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/country/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException{
		try {
		SpringLearnApplication springrest= new SpringLearnApplication();

		return springrest.countrycode(code);
		}
		catch (Exception e) {
			throw new CountryNotFoundException() ;
		}
	}
}
