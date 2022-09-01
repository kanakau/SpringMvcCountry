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
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Fee;
import com.luv2code.springdemo.service.FeeService;

@RestController
@RequestMapping("/fee")
public class FeeRestController {
	
	@Autowired
	private FeeService feeService;
	
	@GetMapping("/fees")
	public List<Fee> getFees(){
		return feeService.getFees();
	}
	
	@GetMapping("/fees/{feeId}")
	public Fee getFee(@PathVariable int feeId) {
		Fee thefee=feeService.getFee(feeId);
		if(thefee==null) {
			throw new FeeNotFoundException("fee id not found-"+feeId);
		}
		return thefee;
	}
	
	@PostMapping("/fees")
	public Fee addFee(@RequestBody Fee theFee) {
		theFee.setFeeId(0);
		feeService.saveFee(theFee);
		return theFee;
	}
	
	@PutMapping("/fees")
	public Fee updateFee(@RequestBody Fee theFee) {
		feeService.saveFee(theFee);
		return theFee;
	}
	
	@DeleteMapping("/fees/{feeId}")
	public String deleteFee(@PathVariable int feeId) {
		Fee tempFee=feeService.getFee(feeId);
		
		if(tempFee==null) {
			throw new FeeNotFoundException("Fee id not found-"+feeId);
		}
		feeService.deleteFee(feeId);
		return "Deleted Fee id - " + feeId;
	}
	
	@GetMapping("/fees/con/{id}")
	public List<Fee> getCountryById(@PathVariable int id){
		//Fee theid = feeService.getCountryById(id);
		//return theid;
		return feeService.getCountryById(id);
		
	}
	
	

}
