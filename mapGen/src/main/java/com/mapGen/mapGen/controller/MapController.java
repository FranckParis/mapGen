package com.mapGen.mapGen.controller;

import com.mapGen.mapGen.model.Map;
import com.mapGen.mapGen.utils.JsonFileParser;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MapController {

    public MapController(){}

    @RequestMapping(value = "/randomMap", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Map returnRandomMap() {
        return new JsonFileParser().parseJsonfromFile("C:\\Users\\FranckParis\\Desktop\\mapGen\\mapGen\\src\\main\\resources\\static\\randomMap.json");
    }

    @RequestMapping(value = "/requestMap", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public void diplayFormPage() {
        //Load form page
    }

    @RequestMapping(value = "/requestMap", consumes = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public Map returnRequestedMap(HttpEntity<String> httpEntity) {
        return new JsonFileParser().parseFromString(httpEntity.getBody());
    }
}
