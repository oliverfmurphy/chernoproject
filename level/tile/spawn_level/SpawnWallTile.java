package com.olivermurphy.chernoproject.level.tile.spawn_level;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;
import com.olivermurphy.chernoproject.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}

	// will be in pixel format and not tile format
    public void render(int x, int y, Screen screen) {	
	    // Do render stuff here!
		screen.renderTile(x << 4, y << 4, this); //multiply by 16 to get back to tile level precision
	}
    
    public boolean solid() {
        return true;	
    }
	
}
