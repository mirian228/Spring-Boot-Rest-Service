package com.restservices.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restservices.demo.controllers.AddResponse;
import com.restservices.demo.model.Country;

@Component
public class CountryService {

	static HashMap<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();

		Country indiaCountry = new Country(1, "India", "Delhi");
		Country usaCountry = new Country(2, "USA", "Washington");
		Country ukCountry = new Country(3, "UK", "London");

		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);

	}

	public List getAllCountries() {
		List countries = new ArrayList(countryIdMap.values());
		return countries;
	}

	public Country getCountryById(int id) {
		return countryIdMap.get(id);
	}

	public Country getCountryByName(String name) {
		Country country = null;
		for (int i : countryIdMap.keySet()) {
			if (countryIdMap.get(i).getCountryName().equals(name)) {
				country = countryIdMap.get(i);
			}
		}
		return country;

	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(getMaxId(), country);
		return country;
	}

	// Utility Method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : countryIdMap.keySet()) {
			if (max <= id) {
				max = id;
			}
		}
		return max + 1;
	}

	public Country updateCountry(Country country) {
		if (country.getId() > 0) {
			countryIdMap.put(country.getId(), country);
		}
		return country;
	}

	public AddResponse deleteCountry(int id) {
		countryIdMap.remove(id);
		AddResponse response = new AddResponse();
		response.setMessage("Country Deleted");
		response.setId(id);
		return response;
	}
}
