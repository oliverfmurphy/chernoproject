package com.olivermurphy.chernoproject.level;

import com.olivermurphy.chernoproject.graphics.Screen;

// top level class (template) for levels, will be subclasses
public class Level {

	private int width, height;
	private int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
	    this.height = height;
	    tiles = new int[width * height];
	    generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}
	
	private void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	// Aritificial intelligence to be updated etc
	public void update() {
		
	}
	
	// manage the time
	private void time() {
		
	}
	
	public void render(int xScrol, int yScroll, Screen screen) {
		
	}
}
