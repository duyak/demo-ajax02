package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.StateEntity;

public interface StateRepository {

	public List<StateEntity> findByCountry(int countryId);

}
