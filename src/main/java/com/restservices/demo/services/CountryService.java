package com.restservices.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.restservices.demo.controllers.AddResponse;
import com.restservices.demo.model.Country;

public class CountryService {

	static HashMap<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();

		Country indiaCountry = new Country(1, "India", "Delhi");
		Country usaCountry = new Country(1, "USA", "Washington");
		Country ukCountry = new Country(1, "UK", "London");

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
		String countryName = null;
		int i;
		Country result = null;
		for (i = 0; i < countryIdMap.size(); i++) {
			countryName = countryIdMap.get(i).getCountryName();
			if (countryName == name) {
				result = countryIdMap.get(i);
			}
		}

		return result;
	}

	public Country addCountry(Country country) {
		return countryIdMap.put(getMaxId(), country);
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
