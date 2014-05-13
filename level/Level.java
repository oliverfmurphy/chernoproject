package com.olivermurphy.chernoproject.level;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.level.tile.Tile;

// top level class (template) for levels, will be subclasses
public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected Tile[] tiles ;
	
	public Level(int width, int height) {
		this.width = width;
	    this.height = height;
	    tilesInt = new int[width * height]; // each number will represent a tile
	    generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	// Aritificial intelligence to be updated etc
	public void update() {
		
	}
	
	// manage the time
	protected void time() {
		
	}
	
	// render tiles until edge of screen using corner pins(co-ordinates of corners)
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll, yScroll);
		
		// left most vertical asymptote
		int x0 = xScroll  >> 4; // shifted right 4 = divide by 16(size of tile) because we want to deal at pixel level and not tile level
		// right most vertical asymptote
		int x1 = (xScroll + screen.width + 16) >> 4;
		
		int y0 = yScroll >> 4;
		int y1= (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) { // want to render from top part of the screen y0 to the bottom part of the screen y1
			for (int x = x0; x < x1; x++){ // all pixels left x0 to right x1
				//getTile(x, y).render(x, y, screen);
				if (x < 0 || y < 0 || x >= width || y >= height) Tile.voidTile.render(x, y, screen);
				else tiles[x + y * 16].render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tilesInt[x + y * width] == 0 ) return Tile.grass;
		if (tilesInt[x + y * width] == 1 ) return Tile.flower;
		if (tilesInt[x + y * width] == 2 ) return Tile.rock;
		return Tile.voidTile;
	}
}
