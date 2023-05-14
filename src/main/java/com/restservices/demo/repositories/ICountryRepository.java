package com.restservices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservices.demo.model.Country;

public interface ICountryRepository extends JpaRepository<Country, Integer> {

}
