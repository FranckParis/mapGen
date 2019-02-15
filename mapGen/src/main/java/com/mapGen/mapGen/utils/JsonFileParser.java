package com.mapGen.mapGen.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mapGen.mapGen.model.Map;

import java.io.*;

public class JsonFileParser {

    public JsonFileParser(){ }

    public Map parseJsonfromFile(String fileName){

        String line;
        StringBuilder jsonDataString = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while((line = bufferedReader.readLine()) != null) {
                jsonDataString.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Parsing JSON
        return parseFromString(String.valueOf(jsonDataString));
    }

    public Map parseFromString(String s){
        Gson g = new Gson();
        JsonObject jobj = g.fromJson(s, JsonObject.class);

        return new Map (
                jobj.get("length").getAsInt(),
                jobj.get("width").getAsInt(),
                jobj.get("cities").getAsBoolean(),
                jobj.get("citiesProba").getAsInt(),
                jobj.get("citiesIterNb").getAsInt(),
                jobj.get("forests").getAsBoolean(),
                jobj.get("forestsProba").getAsInt(),
                jobj.get("forestsIterNb").getAsInt(),
                jobj.get("water").getAsBoolean(),
                jobj.get("waterProba").getAsInt(),
                jobj.get("waterIterNb").getAsInt()
        );
    }
}
