package com.laptrinhjavaweb.server;

import java.util.List;

import com.laptrinhjavaweb.entity.StateEntity;

public interface StateServer {
	
	public List<StateEntity> findByCountry(int countryId);


}
