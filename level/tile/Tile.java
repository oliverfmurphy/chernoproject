package com.olivermurphy.chernoproject.level.tile;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;

// each tile needs a position and a sprite
public class Tile {
    
	public int x, y;
	public Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {	
	}
	
	public boolean solid() {
		return false; // false by default if not over-ridden in a sub-class
	}
}
