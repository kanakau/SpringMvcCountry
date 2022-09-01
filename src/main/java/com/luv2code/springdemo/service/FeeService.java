package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Fee;


public interface FeeService {
	
	public List<Fee> getFees();

	public void saveFee(Fee theFee);

	public Fee getFee(int theId);

	public void deleteFee(int theId);
	
	public List<Fee> getCountryById(int id);
}
