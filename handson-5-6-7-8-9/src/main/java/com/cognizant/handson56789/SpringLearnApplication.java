package com.cognizant.handson56789;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.handson56789.service.CountryNotFoundException;
import com.cognizant.handson56789.service.CountryService;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		getAllCountriesTest();
		AddCountry();
		UpdateCountry();
		DeleteCountry();
	}

	private static void getAllCountriesTest() {
		LOGGER.info("Start");
		Country country;
		try {
			country = countryService.findCountryByCode("GF");
			LOGGER.debug("Country:{}", country);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void AddCountry() {
		Country country = new Country();
		country.setCode("IN");
		country.setName("INDIA");
		countryService.addCountry(country);
		Country Country_Check;
		try {
			Country_Check = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", Country_Check);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void UpdateCountry() {
		countryService.updateCountry("IN", "INDONESIA");
		Country Country_Check;
		try {
			Country_Check = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", Country_Check);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void DeleteCountry() {
		countryService.deleteCountry("IN");
		Country Country_Check;
		try {
			Country_Check = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", Country_Check);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			System.out.println("Deleted!");
		}
	}

}
