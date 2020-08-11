package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.CityEntity;
import com.laptrinhjavaweb.entity.StateEntity;
import com.laptrinhjavaweb.repository.CityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cityDAO")
public class CityRepositoryImpl implements CityRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<CityEntity> findByState(int stateId) {
        List<CityEntity> cityEntities = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            cityEntities = session.createQuery("SELECT c.id as id,"+"c.name as name "+"FROM City c " + "WHERE state.id = :stateId")
                    .setInteger("stateId", stateId)
                    .setResultTransformer(
                            Transformers.aliasToBean(
                                    CityEntity.class))
                    .list();
            transaction.commit();

        } catch (Exception e) {
            cityEntities = null;
            if (transaction != null) {
                transaction.rollback();

            }
        } finally {
            session.close();

        }

        return cityEntities;
    }
}
