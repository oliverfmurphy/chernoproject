package com.olivermurphy.chernoproject.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.olivermurphy.chernoproject.level.tile.Tile;

public class SpawnLevel extends Level{
    
	public SpawnLevel(String path) {
    	super(path);
    }
 
	protected void loadLevel(String path) {
        try {
        	BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path)); // loading image from a particular path
        	int w = image.getWidth();
        	int h = image.getHeight();
        	tiles = new int[w * h];
        	image.getRGB(0, 0, w, h, tiles, 0, w); // Converting image into an array of pixels
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
	}

}
