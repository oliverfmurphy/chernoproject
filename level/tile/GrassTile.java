package com.olivermurphy.chernoproject.level.tile;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;

// grass is not solid so no need to set solid/collision by over-riding it
public class GrassTile extends Tile{

    public GrassTile(Sprite sprite) {
    	super(sprite);
    	
    }
    
	// will be in pixel format and not tile format
    public void render(int x, int y, Screen screen) {	
	    // Do render stuff here!
		screen.renderTile(x << 4, y << 4, sprite.grass); //multiply by 16 to get back to tile level precision
	}

}
