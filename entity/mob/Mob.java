package com.olivermurphy.chernoproject.entity.mob;

import com.olivermurphy.chernoproject.entity.Entity;
import com.olivermurphy.chernoproject.graphics.Sprite;

// Mob is a template for all Mobs we create
public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0; // direction -> 0 - North, 1 - East, 2 - South, 3 - West
	protected boolean moving = false;
	
	public void move(int xa, int ya) {
        
		// if advancing on both axis, split the movement
		if (xa != 0 && ya !=0) {
			move(xa,0);
			move(0, ya);
			return;
		}
		
		if (xa > 0) dir = 1; // East
        if (xa < 0) dir = 3; // West
        if (ya > 0) dir = 2; // South
        if (ya < 0) dir = 0; // North
		
		// if no collision then advance
		if (!collision(xa, ya)) {
		    x += xa;
		    y += ya;
		}
	}
	
	public void update () {		
	}
	
	protected void shoot(int x, int y, double dir) {
		System.out.println("Angle: " + dir);
	}
	
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		// check all four corners for collision
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid()) solid = true; // if the tile we want to go to is solid do not advance
		}
		return solid;
	}
	
	public void render() {		
	}
}
