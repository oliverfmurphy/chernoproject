package com.olivermurphy.chernoproject.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y; //sprite co-ordinates
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);//size, x, y, 
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE]; // creates new pixel array that is the size of the sprite
		this.x = x * size;//setting location of target sprite in spritesheet
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	// extracting a single sprite from spritesheet
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x= 0; x < SIZE; x++) {
				// setting pixels to a specific sprite in sprite sheet
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
