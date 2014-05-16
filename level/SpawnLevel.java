package com.olivermurphy.chernoproject.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.olivermurphy.chernoproject.level.tile.Tile;

public class SpawnLevel extends Level{
    
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
        	levelPixels = new int[w * h];
        	image.getRGB(0, 0, w, h, levelPixels, 0, w); // Converting image into an array of pixels
        } catch (IOException e){
        	e.printStackTrace();
        	System.out.println("Exception: Could not load level file");
        }
	}
	
	// needs to convert an array of pixels into an array of tiles
	// returns void and not Tile or Tile[] for instance to help performance and keep tile array intact
	// Grass = 0xff00ff00
	// Flower = 0xffffff00
	// Rock = 0xff7f7f7f
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i++) {
			if (levelPixels[i] == 0xff00ff00) tiles[i] = Tile.grass; // preceding ff to fill up alpha channel, 00 opague, ff full opacity
			else if (levelPixels[i] == 0xffffff00) tiles[i] = Tile.flower;
			else if (levelPixels[i] == 0xff7f7f7f) {tiles[i] = Tile.rock;
		    		System.out.println("Rock levelPixels[i]:" + levelPixels[i]);
		    }
		    else tiles[i] = Tile.voidTile;
	    }
	}

}
