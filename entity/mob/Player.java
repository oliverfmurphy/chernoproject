package com.olivermurphy.chernoproject.entity.mob;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;
import com.olivermurphy.chernoproject.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	
	public Player(Keyboard input) {	
		this.input = input;
		sprite = Sprite.player_forward; // default the sprite to face forward
	}
	
	// Create a player in a specific location
	public Player(int x, int y, Keyboard input) {
		this.x = x; // Defined in the entity class
		this.y = y; // Defined in the entity class
		this.input = input;
		sprite = Sprite.player_forward; // default the sprite to face forward
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
	
	public void render(Screen screen) {	
		if (dir == 0) sprite = Sprite.player_forward;
		if (dir == 1) sprite = Sprite.player_right;
		if (dir == 2) sprite = Sprite.player_back;
		if (dir == 3) sprite = Sprite.player_left;
		screen.renderPlayer(x - 16, y - 16, sprite);
	}
}
