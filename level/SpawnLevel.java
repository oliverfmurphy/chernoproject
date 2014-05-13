package com.olivermurphy.chernoproject.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.olivermurphy.chernoproject.level.tile.Tile;

public class SpawnLevel extends Level{
    
	private Tile[] tiles ;
	private int[] levelPixels; // RGB array
	
	public SpawnLevel(String path) {
    	super(path);
    }
 
	protected void loadLevel(String path) {
        try {
        	BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path)); // loading image from a particular path
        	int w = image.getWidth();
        	int h = image.getHeight();
        	tiles = new Tile[w * h];
        	image.getRGB(0, 0, w, h, levelPixels, 0, w); // Converting image into an array of pixels
        } catch (IOException e){
        	e.printStackTrace();
        	System.out.println("Exception: Could not load level file");
        }
	}
	
	// needs to convert an array of pixels into an array of tiles
	// returns void and not Tile or Tile[] for instance to help performance and keep tile array intact
	// Grass = 0xFF00
	// Flower = 0xFFFF00
	// Rock = 0x7F7F00
	protected void generateLevel() {
	    for (int i = 0; i < levelPixels.length; i++) {
		if (levelPixels[i] == 0xff00) tiles[i] = Tile.grass;
		if (levelPixels[i] == 0xffff00) tiles[i] = Tile.flower;
		if (levelPixels[i] == 0x7f7f00) tiles[i] = Tile.rock;
	    }
	}

}
