/*package com.mapGen.mapGen.utils;

import com.mapGen.mapGen.model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MapRenderer {

    private Map map;
    private String renderedMap64;

    public MapRenderer(Map map) {
        this.map = map;
        this.renderedMap64 = "";
        this.renderMapTo64();
    }

    private void renderMapTo64(){

        int cellLength = 74;
        int cellWidth = 74;

        BufferedImage bufferedImage = new BufferedImage(map.getLength()*cellLength, map.getWidth()*cellWidth, BufferedImage.TYPE_INT_RGB);
        Graphics2D mainMap = bufferedImage.createGraphics();

        for (int i = 0; i < this.map.getLength(); i++) {
            for (int j = 0; j < this.map.getWidth(); j++) {
                BufferedImage texture = null;
                try {
                    texture = ImageIO.read(new File("C:\\Users\\FranckParis\\Desktop\\mapGen\\mapGen\\src\\main\\resources\\static\\textures\\" + this.map.getMap().get(new Coordinate(i, j)).getTexture()));
                    mainMap.drawImage(texture, i*cellLength, j*cellWidth, cellLength, cellWidth, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        mainMap.dispose();

        File renderedMap = new File("C:\\Users\\FranckParis\\Desktop\\mapGen\\mapGen\\src\\main\\resources\\static\\generated\\renderedMap.jpg");
        try {
            ImageIO.write(bufferedImage, "jpg", renderedMap);
            this.renderedMap64 = this.imgToBase64String(ImageIO.read(renderedMap), "jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String imgToBase64String(final RenderedImage img, final String formatName) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, formatName, Base64.getEncoder().wrap(os));
            return os.toString(StandardCharsets.ISO_8859_1.name());
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    public String getRenderedMap64() {
        return renderedMap64;
    }
}*/
