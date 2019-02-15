package com.mapGen.mapGen.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.util.*;
import java.util.List;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

@Getter @Setter
@ToString @EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Map {

    private HashMap<Coordinate, Case> map;

    private int length;
    private int width;

    private Boolean cities;
    private int citiesProba;
    private int citiesIterNb;

    private Boolean forests;
    private int forestsProba;
    private int forestsIterNb;

    private Boolean water;
    private int waterProba;
    private int waterIterNb;

    public Map(int length, int width, Boolean cities, int citiesProba, int citiesIterNb, Boolean forests, int forestsProba, int forestsIterNb, Boolean water, int waterProba, int waterIterNb) {

        this.length = length;
        this.width = width;
        this.cities = cities;
        this.citiesProba = citiesProba;
        this.citiesIterNb = citiesIterNb;
        this.forests = forests;
        this.forestsProba = forestsProba;
        this.forestsIterNb = forestsIterNb;
        this.water = water;
        this.waterProba = waterProba;
        this.waterIterNb = waterIterNb;

        this.map = new HashMap<>();
        this.initializeMap();
    }

    public Map(){}

    private void initializeMap(){

        //Populating wth grass
        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.width; j++){
                this.map.put(new Coordinate(i, j), new Case(CaseType.GRASS));
            }
        }

        //Forest
        if(this.forests){
            this.initComponent(CaseType.FOREST);
            this.propagate(CaseType.FOREST, this.forestsIterNb, new Random(), this.forestsProba);
        }

        //Water
        if(this.water){
            this.initComponent(CaseType.WATER);
            this.propagate(CaseType.WATER, this.waterIterNb, new Random(), this.waterProba);
        }

        //Cities
        if(this.cities){
            this.initComponent(CaseType.CITY);
            this.propagate(CaseType.CITY, this.citiesIterNb, new Random(), this.citiesProba);
            this.populateWalls();
        }
    }

    private void initComponent(CaseType type) {
        Random rand = new Random();

        int coeff = (type == CaseType.WATER) ? 20 : 10;
        int nbIter = (int) ceil(sqrt((this.length * this.width)) / coeff);

        for (int i = 0; i < nbIter; i++) {

            int w = rand.nextInt(this.width - 1);
            int l = rand.nextInt(this.length - 1);

            while (this.map.get(new Coordinate(l, w)).getType() == type) {
                w = rand.nextInt(this.width - 1);
                l = rand.nextInt(this.length - 1);
            }

            this.map.put(new Coordinate(l, w), new Case(type));
        }
    }

    private void propagate (CaseType type, int iterNb, Random rand, int proba){

        //System.out.println(iterNb);
        if (iterNb > 0) {
            this.findAllByTag(type)
                    .forEach(c -> this.getNeighbors(c.getX(), c.getY(), type)
                            .forEach(e -> {
                                if (this.map.get(e).getType() != type && rand.nextInt(10) > proba) {
                                    this.map.put(e, new Case(type));
                                }
                            }));
            this.propagate(type, iterNb - 1, rand, proba);
        }
    }

    private void populateWalls(){
        this.findAllByTag(CaseType.CITY)
                .forEach(c -> this.getNeighbors(c.getX(), c.getY(), CaseType.WALL)
                        .forEach(e -> {
                            if (this.map.get(e).getType() != CaseType.CITY && this.map.get(e).getType() != CaseType.WATER) {
                                this.map.put(e, new Case(CaseType.WALL));
                            }
                        }));
    }

    private List<Coordinate> getNeighbors ( int i, int j, CaseType type){

        List<Coordinate> list = new ArrayList<>();
        List<Coordinate> directNeighbors = Arrays.asList(new Coordinate(i - 1, j), new Coordinate(i + 1, j), new Coordinate(i, j - 1), new Coordinate(i, j + 1));
        //List<resources.Coordinate> diagNeighbors = Arrays.asList(new resources.Coordinate(i - 1, j - 1), new resources.Coordinate(i + 1, j + 1), new resources.Coordinate(i + 1, j - 1), new resources.Coordinate(i - 1, j + 1));

        switch (type) {
            case CITY:
                return this.validateList(directNeighbors);

            case WATER:
                return this.validateList(directNeighbors);

            case FOREST:
                return this.validateList(directNeighbors);

            case WALL:
                for (int l = i - 1; l <= i + 1; l++) {
                    for (int w = j - 1; w <= j + 1; w++) {
                        if (this.validateCoord(l, w)) {
                            list.add(new Coordinate(l, w));
                        }
                    }
                }
                return list;

            default:
                return list;
        }
    }

    private List<Coordinate> findAllByTag (CaseType type){
        List<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.map.get(new Coordinate(i, j)).getType() == type) {
                    list.add(new Coordinate(i, j));
                }
            }
        }
        return list;
    }

    private boolean validateCoord ( int i, int j){
        return (i <= this.length - 1 && i >= 0 && j <= this.width - 1 && j >= 0);
    }

    private List<Coordinate> validateList(List<Coordinate> list){
        List<Coordinate> returnedList = new ArrayList<>();
        list.forEach(e -> {
            if (this.validateCoord(e.getX(), e.getY())) {
                returnedList.add(e);
            }
        });
        return returnedList;
    }

    @Override
    public String toString(){
        StringBuilder mapString = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                mapString.append(this.map.get(new Coordinate(i, j)).getTexture()).append("   ");
            }
            mapString.append("\n\n");
        }
        return mapString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map1 = (Map) o;
        return length == map1.length &&
                width == map1.width &&
                citiesProba == map1.citiesProba &&
                citiesIterNb == map1.citiesIterNb &&
                forestsProba == map1.forestsProba &&
                forestsIterNb == map1.forestsIterNb &&
                waterProba == map1.waterProba &&
                waterIterNb == map1.waterIterNb &&
                map.equals(map1.map) &&
                cities.equals(map1.cities) &&
                forests.equals(map1.forests) &&
                water.equals(map1.water);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, length, width, cities, citiesProba, citiesIterNb, forests, forestsProba, forestsIterNb, water, waterProba, waterIterNb);
    }
}
