package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.server.CityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.laptrinhjavaweb.server.CountryServer;
import com.laptrinhjavaweb.server.StateServer;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private CountryServer countryServer;

    @Autowired
    private StateServer stateServer;

    @Autowired
    private CityServer cityServer;


    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("countries", countryServer.findAll());
        return "demo/index";
    }

    @RequestMapping(value = "loadStates/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String loadStates(@PathVariable("id") int id) {
        Gson gson = new Gson();
        return gson.toJson(stateServer.findByCountry(id));

    }

    @RequestMapping(value = "loadCities/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String loadCities(@PathVariable("id") int id) {
        Gson gson = new Gson();
        return gson.toJson(cityServer.findByState(id));

    }

}
