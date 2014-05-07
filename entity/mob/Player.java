package com.olivermurphy.chernoproject.entity.mob;

import com.olivermurphy.chernoproject.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	public Player(Keyboard input) {	
		this.input = input;
	}
	
	// Create a player in a specific location
	public Player(int x, int y, Keyboard input) {
		this.x = x; // Defined in the entity class
		this.y = y; // Defined in the entity class
		this.input = input;
	}
	
	// effects entities x & y co-ordinates
	public void update() {
		int xa = 0, ya = 0; // Direction player is supposed to move
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) move(xa, ya);
		
	}
	
	public void render() {		
	}
}
