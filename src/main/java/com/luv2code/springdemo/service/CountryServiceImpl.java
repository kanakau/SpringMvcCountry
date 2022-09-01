package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CountryDAO;
import com.luv2code.springdemo.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	// need to inject Country dao
	@Autowired
	private CountryDAO countryDAO;
	
	@Override
	@Transactional
	public List<Country> getCountrys() {
		return countryDAO.getCountrys();
	}

	@Override
	@Transactional
	public void saveCountry(Country theCountry) {

		countryDAO.saveCountry(theCountry);
	}

	@Override
	@Transactional
	public Country getCountry(int theId) {
		
		return countryDAO.getCountry(theId);
	}

	@Override
	@Transactional
	public void deleteCountry(int theId) {
		
		countryDAO.deleteCountry(theId);
	}
}





