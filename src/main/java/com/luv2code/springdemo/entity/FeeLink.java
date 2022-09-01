package com.luv2code.springdemo.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fee_link")
public class FeeLink {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fee_Linkid")
	private int feeLinkId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Country country;
	
	@ManyToOne
	@JoinColumn(name = "fee_Id")
	private Fee fee;
	
	@Column(name="fee_amount")
	private int amount;
	
	@Column(name = "to_date")
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	@Column(name = "from_date")
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	public FeeLink() {
		
	}

	public int getFeeLinkId() {
		return feeLinkId;
	}

	public void setFeeLinkId(int feeLinkId) {
		this.feeLinkId = feeLinkId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	

}
