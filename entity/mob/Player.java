package com.olivermurphy.chernoproject.entity.mob;

import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.graphics.Sprite;
import com.olivermurphy.chernoproject.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
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
		if (anim < 7500) anim++; 
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
	}
	
	public void render(Screen screen) {	
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.player_forward;
			if (walking) {
				if (anim % 30 < 6) {
					sprite = Sprite.player_forward;
				}else if (anim % 30 < 12) {
					sprite = Sprite.player_forward_1;
				}else if (anim % 30 < 18) {
					sprite = Sprite.player_forward_2;
				}else if (anim % 30 < 24) {
					sprite = Sprite.player_forward_3;
				} else {
					sprite = Sprite.player_forward_4;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 30 < 6) {
					sprite = Sprite.player_side;
				}else if (anim % 30 < 12) {
					sprite = Sprite.player_side_1;
				}else if (anim % 30 < 18) {
					sprite = Sprite.player_side_2;
				}else if (anim % 30 < 24) {
					sprite = Sprite.player_side_3;
				} else {
					sprite = Sprite.player_side_4;
				}
			}
			flip = 1; // flip the sprite in the renderPlayer method
		}
		if (dir == 2) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 30 < 6) {
					sprite = Sprite.player_back;
				}else if (anim % 30 < 12) {
					sprite = Sprite.player_back_1;
				}else if (anim % 30 < 18) {
					sprite = Sprite.player_back_2;
				}else if (anim % 30 < 24) {
					sprite = Sprite.player_back_3;
				} else {
					sprite = Sprite.player_back_4;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 30 < 6) {
					sprite = Sprite.player_side;
				}else if (anim % 30 < 12) {
					sprite = Sprite.player_side_1;
				}else if (anim % 30 < 18) {
					sprite = Sprite.player_side_2;
				}else if (anim % 30 < 24) {
					sprite = Sprite.player_side_3;
				} else {
					sprite = Sprite.player_side_4;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
