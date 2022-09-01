package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.service.CountryService;

@RestController
@RequestMapping("/con")
public class CountryRestController {
	
	@Autowired
	private CountryService countryService;
	
//	@RequestMapping(value="/welcome",method=RequestMethod.GET)
//	public String showform() {
//		return "hello";
//	}
	
	@GetMapping("/countrys")
	public List<Country> getCountrys(){
		return countryService.getCountrys();
	}
	
	@GetMapping("/countrys/{countryId}")
	public Country getCountry(@PathVariable int countryId) {
		Country theCountry=countryService.getCountry(countryId);
		if(theCountry==null) {
			throw new CountryNotFoundException("Country id not found-"+countryId);
		}
		return theCountry;
	}
	
	@PostMapping("/countrys")
	public Country addCountry(@RequestBody Country theCountry) {
		theCountry.setId(0);
		countryService.saveCountry(theCountry);
		return theCountry;
	}
	
	@PutMapping("/countrys")
	public Country updateCountry(@RequestBody Country theCountry) {
		countryService.saveCountry(theCountry);
		return theCountry;
	}
	
	@DeleteMapping("/countrys/{countryId}")
	public String deleteCountry(@PathVariable int countryId) {
		Country tempCountry=countryService.getCountry(countryId);
		
		if(tempCountry==null) {
			throw new CountryNotFoundException("Country id not found-"+countryId);
		}
		countryService.deleteCountry(countryId);
		return "Deleted Country id - " + countryId;
	}

}
