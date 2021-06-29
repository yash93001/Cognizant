package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.info("Function CountryService.getCountry() is called with code="+code);
		List<Country> country_list = context.getBean("countryList", ArrayList.class);
		for(Country c: country_list) {
			if(code.equalsIgnoreCase(c.getCode())) {
				LOGGER.debug("Country: {}", c);
				LOGGER.info("END");
				return c;
			}
		}		
		throw new CountryNotFoundException();
	}
}
