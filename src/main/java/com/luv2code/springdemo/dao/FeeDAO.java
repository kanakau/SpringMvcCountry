package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Fee;


public interface FeeDAO {
	
	public List<Fee> getFees();

	public void saveFee(Fee theFee);

	public Fee getFee(int theId);

	public void deleteFee(int theId);
	
	public List<Fee> getCountryById(int id);

}
