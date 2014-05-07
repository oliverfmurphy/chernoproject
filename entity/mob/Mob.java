package com.olivermurphy.chernoproject.entity.mob;

import com.olivermurphy.chernoproject.entity.Entity;
import com.olivermurphy.chernoproject.graphics.Sprite;

// Mob is a template for all Mobs we create
public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0; // direction -> 0 - North, 1 - East, 2- South, 3 - West
	protected boolean moving = false;
	
	public void move() {		
	}
	
	public void update () {		
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {		
	}
}
