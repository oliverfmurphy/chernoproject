package com.olivermurphy.chernoproject.entity;

import java.util.Random;
import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.level.Level;

public abstract class Entity {

	public int x, y; // control location of entity on a map
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	// updates at tick rate (60 tps)
	public void update() {	
	}
	
	// Entities do not necessarily have sprites
	public void render(Screen screen) {	
	}
	
	public void remove() {
		// remove entity from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
