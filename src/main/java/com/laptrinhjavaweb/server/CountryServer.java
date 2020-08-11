package com.laptrinhjavaweb.server;

import java.util.List;

import com.laptrinhjavaweb.entity.Country;

public interface CountryServer {
	
	public List<Country> findAll();
	
	public Country find(int id);


}
