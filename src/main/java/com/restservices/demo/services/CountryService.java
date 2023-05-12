package com.restservices.demo.services;

import java.util.HashMap;

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

}
