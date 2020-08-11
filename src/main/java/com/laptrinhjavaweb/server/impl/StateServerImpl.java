package com.laptrinhjavaweb.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.StateEntity;
import com.laptrinhjavaweb.repository.StateRepository;
import com.laptrinhjavaweb.server.StateServer;

@Service("stateServer")
public class StateServerImpl implements StateServer {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<StateEntity> findByCountry(int countryId) {

		return stateRepository.findByCountry(countryId);
	}

}
