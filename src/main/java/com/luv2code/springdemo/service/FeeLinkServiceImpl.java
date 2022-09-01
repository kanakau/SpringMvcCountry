package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springdemo.dao.FeeLinkDAO;
import com.luv2code.springdemo.dto.FeeLinkTo;

import com.luv2code.springdemo.entity.FeeLink;

@Service
public class FeeLinkServiceImpl implements FeeLinkService {
	
	@Autowired
	private FeeLinkDAO feeLinkDAO;
	
	@Override
	@Transactional
	public List<FeeLink>  getFeeLinks() {
		return feeLinkDAO. getFeeLinks();
	}

	@Override
	@Transactional
	public void saveFeeLink(FeeLinkTo theFeeLink) {

		feeLinkDAO.saveFeeLink(theFeeLink);
	}

	@Override
	@Transactional
	public List<FeeLinkTo> getFeeLink(int theId) {
		
		return feeLinkDAO.getFeeLink(theId);
	}

	@Override
	@Transactional
	public void deleteFeeLink(int theId) {
		
		feeLinkDAO.deleteFeeLink(theId);
	}
	
	

}
