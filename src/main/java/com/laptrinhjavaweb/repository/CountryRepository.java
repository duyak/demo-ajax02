package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.Country;

public interface CountryRepository {

	public List<Country> findAll();

	public Country find(int id);

}
