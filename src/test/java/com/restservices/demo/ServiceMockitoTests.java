package com.restservices.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

	@Test
	@Order(2)
	public void TestGetCountryById() {
		mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1, "India", "Delhi"));
		mycountries.add(new Country(2, "USA", "Washington"));
		int countryID = 1;
		when(countryRepository.findAll()).thenReturn(mycountries);
		assertEquals(countryID, countryService.getCountryById(countryID).getId());
	}

	@Test
	@Order(3)
	public void TestGetCountryByName() {
		mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1, "India", "Delhi"));
		mycountries.add(new Country(2, "USA", "Washington"));
		String countryName = ("India");
		when(countryRepository.findAll()).thenReturn(mycountries);
		assertEquals(countryName, countryService.getCountryByName(countryName).getCountryName());

	}

	@Test
	@Order(4)
	public void TestAddCountry() {
		Country newCountry = new Country(3, "Japan", "Tokyo");
		when(countryRepository.save(newCountry)).thenReturn(newCountry);
		assertEquals("Japan", countryService.addCountry(newCountry).getCountryName());
		assertEquals(newCountry, countryService.addCountry(newCountry));
	}

	@Test
	@Order(5)
	public void TestUpdateCountry() {
		Country updatedCountry = new Country(3, "Japan", "Tokyo");
		when(countryRepository.save(updatedCountry)).thenReturn(updatedCountry);
		assertEquals("Japan", countryService.updateCountry(updatedCountry).getCountryName());
		assertEquals(updatedCountry, countryService.addCountry(updatedCountry));
	}

	@Test
	@Order(6)
	public void TestDeleteCountry() {
		Country newCountry = new Country(3, "Japan", "Tokyo");
		countryService.deleteCountry(newCountry);
		verify(countryRepository, times(1)).delete(newCountry);

	}
}
