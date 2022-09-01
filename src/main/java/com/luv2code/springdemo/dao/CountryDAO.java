package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Country;

public interface CountryDAO {

	public List<Country> getCountrys();

	public void saveCountry(Country theCountry);

	public Country getCountry(int theId);

	public void deleteCountry(int theId);
	
}
