package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.dto.FeeLinkTo;
import com.luv2code.springdemo.entity.FeeLink;

public interface FeeLinkDAO {
	
	public List<FeeLink> getFeeLinks();
	
	public void saveFeeLink(FeeLinkTo theFeeLink);

	public List<FeeLinkTo> getFeeLink(int theId);

	public void deleteFeeLink(int theId);

}
