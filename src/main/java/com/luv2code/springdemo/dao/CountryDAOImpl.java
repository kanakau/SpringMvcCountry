package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Country> getCountrys() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Country> theQuery = 
				currentSession.createQuery("from Country order by country_name",
											Country.class);
		
		// execute query and get result list
		List<Country> countrys = theQuery.getResultList();
				
		// return the results		
		return countrys;
	}

	@Override
	public void saveCountry(Country theCountry) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Country ... finally LOL
		currentSession.saveOrUpdate(theCountry);
		
	}

	@Override
	public Country getCountry(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Country theCountry = currentSession.get(Country.class, theId);
		
		return theCountry;
	}

	@Override
	public void deleteCountry(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Country where id=:countryId");
		theQuery.setParameter("countryId", theId);
		
		theQuery.executeUpdate();		
	}

}











