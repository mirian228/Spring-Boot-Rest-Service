package com.restservices.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.restservices.demo.model.Country;
import com.restservices.demo.repositories.ICountryRepository;
import com.restservices.demo.services.CountryService;

@SpringBootTest(classes = { ServiceMockitoTests.class })
public class ServiceMockitoTests {
	@Mock
	ICountryRepository countryRepository;
	@InjectMocks
	CountryService countryService;
	@Mock
	public List<Country> mycountries;

	@Test()
	@Order(1)
	public void TestGetAllCountries() {
		mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1, "India", "Delhi"));
		mycountries.add(new Country(2, "USA", "Washington"));
		
		when(countryRepository.findAll()).thenReturn(mycountries);
		
		assertEquals(2, countryService.getAllCountries().size());
			
	
	}
	
	
	public void TestGetCountryById () {
		
	}
}
