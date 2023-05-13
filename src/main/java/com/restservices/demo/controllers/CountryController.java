package com.restservices.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.demo.model.Country;
import com.restservices.demo.services.CountryService;

@RestController
public class CountryController {

	private final CountryService countryService;

	@Autowired
	CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping(path = "/getcountries")
	public List getCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping(path = "/getcountries/{id}")
	public Country getCountryById(@PathVariable(value = "id") int id) {
		return countryService.getCountryById(id);
	}

	@GetMapping(path = "/getcountries/countryname")
	public Country getCountryByName(@RequestParam(value = "name") String countryName) {
		return countryService.getCountryByName(countryName);
	}

	@PostMapping(path = "/addcountry")
	public Country addNewCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@PutMapping(path = "/updatecountry")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}

	@DeleteMapping(path = "/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value = "id") int id) {
		return countryService.deleteCountry(id);
	}

}
