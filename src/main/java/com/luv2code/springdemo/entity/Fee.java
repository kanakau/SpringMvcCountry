package com.luv2code.springdemo.entity;





import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="fee")
public class Fee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fee_id")
	private int feeId;
	
	@Column(name="fee_name")
	private String feeName;
	
	@Column(name="fee_code")
	private String feeCode;
	
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Country country;
	
	public Fee() {
		
	}
	
	public Fee(int feeId) {
		this.feeId = feeId;
	}
	
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getFeeCode() {
		return feeCode;
	}
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}
	
//	@OneToMany(mappedBy = "fee",targetEntity = Country.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	public List<Country> getCountry() {
//		return country;
//	}
//	public void setCountry(List<Country> country) {
//		this.country = country;
//	}
	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
	
//	@Override
//	public String toString() {
//		return "Fee [feeId=" + feeId + ", feeName=" + feeName + ", feeCode=" + feeCode + ", country=" + country + "]";
//	}

}
