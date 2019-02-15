package com.mapGen.mapGen.controller;

import com.mapGen.mapGen.model.Map;
import com.mapGen.mapGen.utils.JsonFileParser;

import com.mapGen.mapGen.utils.MapRenderer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    public MapController(){}

    @GetMapping("/getMap")
    @CrossOrigin(origins = "http://localhost:4200")
    public Map generateMap() {
        Map m = new JsonFileParser("C:\\Users\\FranckParis\\Documents\\map.json").parseJsonfromFile();
        MapRenderer mr = new MapRenderer(m);
        return m;
    }
}
