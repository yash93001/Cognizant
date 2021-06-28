package com.example.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.Country;


@ComponentScan(basePackages="com")
@SpringBootApplication
public class SpringLearnApplication {	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		LOGGER.info("Inside main function");
		SpringApplication.run(SpringLearnApplication.class, args);
		
	}
	
	public Country displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("india.xml"); 
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	 
	
	public List<Country> displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		return list;
		
	}
	public Country countrycode(String code)
	{
		code = code.toLowerCase();
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean(code, Country.class);
		return country;
		
	}

}
