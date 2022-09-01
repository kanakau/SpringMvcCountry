package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springdemo.dao.FeeDAO;

import com.luv2code.springdemo.entity.Fee;

@Service
public class FeeServiceImpl implements FeeService {
	
	// need to inject Fee dao
		@Autowired
		private FeeDAO feeDAO;
		
		@Override
		@Transactional
		public List<Fee> getFees() {
			return feeDAO.getFees();
		}

		@Override
		@Transactional
		public void saveFee(Fee theFee) {

			feeDAO.saveFee(theFee);
		}

		@Override
		@Transactional
		public Fee getFee(int theId) {
			
			return feeDAO.getFee(theId);
		}

		@Override
		@Transactional
		public void deleteFee(int theId) {
			
			feeDAO.deleteFee(theId);
		}
		@Override
		@Transactional
		public List<Fee> getCountryById(int id){
			
			return feeDAO.getCountryById(id);
		}
		
		

}
