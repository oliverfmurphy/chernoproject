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
	
	public void render(int xScrol, int yScroll, Screen screen) {
		
	}
}
