package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Fee;

@Repository
public class FeeDAOImpl implements FeeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Fee> getFees() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Fee> theQuery = 
				currentSession.createQuery("from Fee order by fee_name",
											Fee.class);
		
		// execute query and get result list
		List<Fee> fees = theQuery.getResultList();
				
		// return the results		
		return fees;
	}

	@Override
	public void saveFee(Fee theFee) {
		// save/upate the fee ... finally LOL
		Session currentSession = sessionFactory.getCurrentSession();
		Fee savefee = new Fee();
		savefee.setFeeName(theFee.getFeeName());
		savefee.setFeeCode(theFee.getFeeCode());
		savefee.setCountry(new Country(theFee.getCountry().getId()));
		currentSession.saveOrUpdate(savefee);
		
	}

	@Override
	public Fee getFee(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Fee theFee = currentSession.get(Fee.class, theId);
		
		return theFee;
	}

	@Override
	public void deleteFee(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Fee where fee_id=:feeId");
		theQuery.setParameter("feeId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<Fee> getCountryById(int id){
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
////	//	Query theQuery = 
////	//			currentSession.createQuery("select distinct fe from Fee fe,Country cn where cn.fees.feeId=fe.feeId and cn.Country.country_id=:id");
		Query<Fee> theQuery = 
				currentSession.createQuery("from Fee order by id ",Fee.class);
		List<Fee> fees = theQuery.getResultList();
		return fees;
	}
	

		
	


}
