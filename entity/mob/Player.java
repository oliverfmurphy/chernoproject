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
		if (input.up) y--;
		if (input.down) y++;
		if (input.left) x--;
		if (input.right) x++;
	}
	
	public void render() {		
	}
}
