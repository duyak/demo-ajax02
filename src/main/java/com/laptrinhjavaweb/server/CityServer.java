package com.laptrinhjavaweb.server;

import com.laptrinhjavaweb.entity.CityEntity;

import java.util.List;

public interface CityServer {
    public List<CityEntity> findByState(int stateId);
}
