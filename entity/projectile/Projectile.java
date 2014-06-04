package com.olivermurphy.chernoproject.entity.projectile;

import com.olivermurphy.chernoproject.entity.Entity;
import com.olivermurphy.chernoproject.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin; // spawn location
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny; // new x, new y
	protected double speed, rateOfFire, range, damage; 
	
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSpriteSize() {
		return sprite.SIZE;
	}

	protected void move() {
		
	}
}
