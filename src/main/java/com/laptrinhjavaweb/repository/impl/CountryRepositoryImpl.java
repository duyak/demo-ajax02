package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Country;
import com.laptrinhjavaweb.repository.CountryRepository;

@Repository("countryDAO")
public class CountryRepositoryImpl implements CountryRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findAll() {
		List<Country> countries = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			countries = session.createQuery("FROM Country").list();
			transaction.commit();

		} catch (Exception e) {
			countries = null;
			if (transaction != null) {
				transaction.rollback();

			}
		} finally {
			session.close();

		}

		return countries;
	}

	@Override
	public Country find(int id) {
		Country country = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			country = (Country) session.createQuery("FROM Country " + "WHERE id = :id").setInteger("id", id)
					.uniqueResult();
			transaction.commit();

		} catch (Exception e) {
			country = null;
			if (transaction != null) {
				transaction.rollback();

			}
		} finally {
			session.close();

		}

		return country;
	}

}
