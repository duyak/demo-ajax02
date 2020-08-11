package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Country;
import com.laptrinhjavaweb.entity.StateEntity;
import com.laptrinhjavaweb.repository.StateRepository;

@Repository("stateDAO")
public class StateRepositoryImpl implements StateRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<StateEntity> findByCountry(int countryId) {
		List<StateEntity> stateEntities = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			stateEntities = session.createQuery("SELECT s.id as id,"+"s.name as name "+"FROM State s " + "WHERE country.id = :countryId")
					.setInteger("countryId", countryId)
					.setResultTransformer(
							Transformers.aliasToBean(
									StateEntity.class))
					.list();
			transaction.commit();

		} catch (Exception e) {
			stateEntities = null;
			if (transaction != null) {
				transaction.rollback();

			}
		} finally {
			session.close();

		}

		return stateEntities;
	}

}
