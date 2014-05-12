package com.olivermurphy.chernoproject.level.tile;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;

// each tile needs a position and a sprite
public class Tile {
    
	public int x, y;
	public Sprite sprite;
	
	//static object of grass - only ever need once instance
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {	
	}
	
	public boolean solid() {
		return false; // false by default if not over-ridden in a sub-class
	}
}
