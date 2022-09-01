package com.luv2code.springdemo.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.dto.FeeLinkTo;
import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Fee;
import com.luv2code.springdemo.entity.FeeLink;

@Repository
public class FeeLinkDAOImpl implements FeeLinkDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<FeeLink> getFeeLinks(){
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<FeeLink> theQuery = 
				currentSession.createQuery("from FeeLink order by fee_Linkid",
						FeeLink.class);
		
		// execute query and get result list
		List<FeeLink> links = theQuery.getResultList();
				
		// return the results		
		return links;
	}
	@Override
	public void saveFeeLink(FeeLinkTo theFeeLink) {
		// save/upate the fee ... finally LOL
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			FeeLink savefeel = new FeeLink();
			savefeel.setCountry(new Country(theFeeLink.getCountry().getId()));
			savefeel.setFee(new Fee(theFeeLink.getFee().getFeeId()));
			SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date in = TimeFormat.parse(theFeeLink.getToDate());
			Date out = TimeFormat.parse(theFeeLink.getFromDate());
			savefeel.setToDate(in);
			savefeel.setFromDate(out);
			savefeel.setAmount(theFeeLink.getAmount());
			currentSession.saveOrUpdate(savefeel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public List<FeeLinkTo> getFeeLink(int theId) {
		List<FeeLinkTo> feeLinkDetails = new ArrayList<FeeLinkTo>();
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		FeeLink theFee = currentSession.get(FeeLink.class, theId);
		FeeLinkTo getFeeLinkDetails = new FeeLinkTo();
		getFeeLinkDetails.setFeeLinkId(theFee.getFeeLinkId());
		SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		getFeeLinkDetails.setFromDate(TimeFormat.format(theFee.getFromDate()));
		getFeeLinkDetails.setToDate(TimeFormat.format(theFee.getToDate()));
		getFeeLinkDetails.setCountryId(theFee.getCountry().getId());
		getFeeLinkDetails.setFeeId(theFee.getFee().getFeeId());
		getFeeLinkDetails.setAmount(theFee.getAmount());
		feeLinkDetails.add(getFeeLinkDetails);
		return feeLinkDetails;
	}
	
	@Override
	public void deleteFeeLink(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from FeeLink where fee_Linkid=:feeLinkId");
		theQuery.setParameter("feeLinkId", theId);
		
		theQuery.executeUpdate();		
	}
	
//	@Override
//	public List<FeeLink> getFeesForCountry(int countryId) {
//		StringBuilder query = new StringBuilder();
//		query.append("from FeeLink fl where date_trunc('day', fl.toDate) >= date_trunc('day', current_timestamp) ");
//		query.append("and fl.entityAssociatedWith = :country and fl.entityAssociatedId = :countryId");
//		Object[] values = new Object[]{"Country", countryId};
//		query.getFeesForCountry(values);
//	}
	
	

	
	

}
