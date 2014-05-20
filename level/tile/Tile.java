package com.olivermurphy.chernoproject.level.tile;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;
import com.olivermurphy.chernoproject.level.tile.spawn_level.SpawnFloorTile;
import com.olivermurphy.chernoproject.level.tile.spawn_level.SpawnGrassTile;
import com.olivermurphy.chernoproject.level.tile.spawn_level.SpawnHedgeTile;
import com.olivermurphy.chernoproject.level.tile.spawn_level.SpawnWallTile;
import com.olivermurphy.chernoproject.level.tile.spawn_level.SpawnWaterTile;

// each tile needs a position and a sprite
public class Tile {
    
	public int x, y;
	public Sprite sprite;
	
	//static object of grass - only ever need once instance
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	
	public final static int col_spawn_grass = 0xff00ff00;
	public final static int col_spawn_hedge = 0; // unused
	public final static int col_spawn_water = 0; // unused 
	public final static int col_spawn_wall1 = 0xff404040;
	public final static int col_spawn_wall2 = 0xff000000;
	public final static int col_spawn_floor = 0xff7f3300;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {	
	}
	
	public boolean solid() {
		return false; // false by default if not over-ridden in a sub-class
	}
}
