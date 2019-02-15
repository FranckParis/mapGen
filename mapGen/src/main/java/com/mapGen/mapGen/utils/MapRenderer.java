package com.mapGen.mapGen.utils;

import com.mapGen.mapGen.model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapRenderer {

    private Map map;

    public MapRenderer(Map map) {
        this.map = map;
        this.renderMap();
    }

    private String renderMap(){

        int cellLength = 74;
        int cellWidth = 74;

        BufferedImage bufferedImage = new BufferedImage(map.getLength()*cellLength, map.getWidth()*cellWidth, BufferedImage.TYPE_INT_RGB);
        Graphics2D mainMap = bufferedImage.createGraphics();

        for (int i = 0; i < this.map.getLength(); i++) {
            for (int j = 0; j < this.map.getWidth(); j++) {
                BufferedImage texture = null;
                try {
                    texture = ImageIO.read(new File("C:\\Users\\FranckParis\\Documents\\mapGeneratorSpring\\mapGen\\src\\main\\resources\\static\\textures\\" + this.map.getMap().get(new Coordinate(i, j)).getTexture()));
                    mainMap.drawImage(texture, i*cellLength, j*cellWidth, cellLength, cellWidth, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        mainMap.dispose();

        File file = new File("C:\\Users\\FranckParis\\Documents\\mapGeneratorSpring\\mapGen\\src\\main\\resources\\static\\generated\\renderedMap.jpg");
        try {
            ImageIO.write(bufferedImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
