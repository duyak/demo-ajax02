package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CityEntity;

import java.util.List;

public interface CityRepository {

    public List<CityEntity> findByState(int stateId);
}
