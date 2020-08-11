package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.CityEntity;
import com.laptrinhjavaweb.repository.CityRepository;
import com.laptrinhjavaweb.server.CityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cityServer")
@Transactional
public class CityServerImpl implements CityServer {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityEntity> findByState(int stateId) {
        return cityRepository.findByState(stateId);
    }
}
