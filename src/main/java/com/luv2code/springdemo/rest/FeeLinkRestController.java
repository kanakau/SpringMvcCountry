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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dto.FeeLinkTo;

import com.luv2code.springdemo.entity.FeeLink;
import com.luv2code.springdemo.service.FeeLinkService;

@RestController
@RequestMapping("/flink")
public class FeeLinkRestController {
	
	@Autowired
	private FeeLinkService feelinkService;
	
	@GetMapping("/feelinks")
	public List<FeeLink> getFeeLinks(){
		return feelinkService.getFeeLinks();
	}
	
	@GetMapping("/getFeeLinks")
	public List<FeeLinkTo> getFeeLink(@RequestParam int theId) {
		List<FeeLinkTo> thefeelink=feelinkService.getFeeLink(theId);
//		if(thefeelink==null) {
//			throw new FeeLinkNotFoundException("feelink id not found-"+feeLinkId);
//		}
		return thefeelink;
	}
	
	@PostMapping("/feelinks")
	public FeeLinkTo addFee(@RequestBody FeeLinkTo theFeeLink) {
		theFeeLink.setFeeLinkId(0);
		feelinkService.saveFeeLink(theFeeLink);
		return theFeeLink;
	}
	
	@PutMapping("/feelinks")
	public FeeLinkTo updateFee(@RequestBody FeeLinkTo theFeeLink) {
		feelinkService.saveFeeLink(theFeeLink);
		return theFeeLink;
	}
	
	@DeleteMapping("/Deletefeelinks")
	public String deleteFeeLink(@RequestParam int theId) {
//		FeeLinkTo tempFeeLink=feelinkService.getFeeLink(theId);
//		
//		if(tempFeeLink==null) {
//			throw new FeeLinkNotFoundException("FeeLink id not found-"+theId);
//		}
		feelinkService.deleteFeeLink(theId);
		return "Deleted FeeLink id - " + theId;
	}

}
