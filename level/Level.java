package com.olivermurphy.chernoproject.level;

import java.util.ArrayList;
import java.util.List;

import com.olivermurphy.chernoproject.entity.Entity;
import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.level.tile.Tile;

// top level class (template) for levels, will be subclasses
public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;// will contain all the level tiles
	
	private List<Entity> entities = new ArrayList<Entity>(); // Array f all entities in level, Arraylist as it needs to be dynamic
	
	public static Level spawn = new SpawnLevel("/levels/spawn.png"); // levels always static as only ever one instance of a level
	
	public Level(int width, int height) {
		this.width = width;
	    this.height = height;
	    tilesInt = new int[width * height]; // each number will represent a tile
	    generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	// Artificial intelligence to be updated etc
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();	
		}
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
		
		// render the level
		for (int y = y0; y < y1; y++) { // want to render from top part of the screen y0 to the bottom part of the screen y1
			for (int x = x0; x < x1; x++){ // all pixels left x0 to right x1
				getTile(x, y).render(x, y, screen);
			}
		}
		
		// render the entities
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);	
		}

	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	// Grass = 0xff00ff00
	// Flower = 0xffffff00
	// Rock = 0xff7f7f7f
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_spawn_floor ) return Tile.spawn_floor;
		if (tiles[x + y * width] == Tile.col_spawn_grass ) return Tile.spawn_grass;
		if (tiles[x + y * width] == Tile.col_spawn_hedge ) return Tile.spawn_hedge;
		if (tiles[x + y * width] == Tile.col_spawn_wall1 ) return Tile.spawn_wall1;
		if (tiles[x + y * width] == Tile.col_spawn_wall2 ) return Tile.spawn_wall2;
		if (tiles[x + y * width] == Tile.col_spawn_water ) return Tile.spawn_water;
		return Tile.voidTile;
	}
}
