package com.restservices.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restservices.demo.controllers.AddResponse;
import com.restservices.demo.model.Country;
import com.restservices.demo.repositories.ICountryRepository;

@Component
@Service
public class CountryService {

	ICountryRepository countryRepository;

	@Autowired
	CountryService(ICountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	public Country getCountryById(int id) {
		return countryRepository.findById(id).get();
	}

	public Country getCountryByName(String name) {
		List<Country> countries = countryRepository.findAll();
		Country country = null;
		for (Country con : countries) {
			if (con.getCountryName().equalsIgnoreCase(name)) {
				country = con;
			}

		}
		return country;
	}

	public Country addCountry(Country country) {
		return countryRepository.save(country);
	}

	/*
	 * // Utility Method to get max id public static int getMaxId() {
	 * 
	 * }
	 */

	public Country updateCountry(Country country) {
		countryRepository.save(country);
		return country;
	}

	public AddResponse deleteCountry(int id) {
		countryRepository.deleteById(id);
		AddResponse response = new AddResponse();
		response.setMessage("Country removed from database");
		response.setId(id);
		
		return response;
	}
}
