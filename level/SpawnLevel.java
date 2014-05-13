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
        	image.getRGB(0, 0, w, h, levelPixels, 0, w); // Converting image into an array of pixels
        } catch (IOException e){
        	e.printStackTrace();
        	System.out.println("Exception: Could not load level file");
        }
	}
	
	// needs to convert an array of pixels into an array of tiles
	protected void generateLevel() {
	    
	}

}
