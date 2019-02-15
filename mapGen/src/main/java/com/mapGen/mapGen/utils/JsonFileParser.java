package com.mapGen.mapGen.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mapGen.mapGen.model.Map;

import java.io.*;

public class JsonFileParser {

    private String fileName;

    public JsonFileParser(String fileName) {
        this.fileName = fileName;
    }

    public Map parseJsonfromFile(){

        String line;
        StringBuilder jsonDataString = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
            while((line = bufferedReader.readLine()) != null) {
                jsonDataString.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Parsing JSON
        JsonObject jobj = new Gson().fromJson(String.valueOf(jsonDataString), JsonObject.class);

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
