package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.dto.FeeLinkTo;
import com.luv2code.springdemo.entity.FeeLink;

public interface FeeLinkService {
	
	public List<FeeLink> getFeeLinks();

	public void saveFeeLink(FeeLinkTo theFeeLink);

	public List<FeeLinkTo> getFeeLink(int theId);

	public void deleteFeeLink(int theId);

}
