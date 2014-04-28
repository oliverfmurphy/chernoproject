package com.olivermurphy.chernoproject.level;

import com.olivermurphy.chernoproject.graphics.Screen;

// top level class (template) for levels, will be subclasses
public class Level {

	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
	    this.height = height;
	    tiles = new int[width * height]; // each number will represent a tile
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
		
		// left most vertical asymptote
		int x0 = xScroll  >> 4; // shifted right 4 = divide by 16(size of tile) because we want to deal at pixel level and not tile level
		// right most vertical asymptote
		int x1 = (xScroll + screen.width) >> 4;
		
		int y0 = yScroll >> 4;
		int y1= (yScroll + screen.height) >> 4;
	}
}
