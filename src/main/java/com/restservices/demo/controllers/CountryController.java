 package com.restservices.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Country>> getCountries() {
		try {
			List<Country> countries = countryService.getAllCountries();
			return new ResponseEntity<List<Country>>(countries, HttpStatus.FOUND);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/getcountries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") int id) {
		try {
			Country country = countryService.getCountryById(id);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/getcountries/countryname")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name") String countryName) {
		try {
			Country country = countryService.getCountryByName(countryName);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/addcountry")
	public Country addNewCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@PutMapping(path = "/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country, @PathVariable(value = "id") int id) {
		try {
			Country existCountry = countryService.getCountryById(id);
			existCountry.setCountryName(country.getCountryName());
			existCountry.setCountryCapital(country.getCountryCapital());

			Country updatedCountry = countryService.updateCountry(existCountry);
			return new ResponseEntity<Country>(updatedCountry, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(path = "/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value = "id") int id) {
		return countryService.deleteCountry(id);
	}

}
