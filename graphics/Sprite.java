package com.olivermurphy.chernoproject.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y; //sprite co-ordinates
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);//size, x, y, tile
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0); //www.colourpicker.com
	
	// dealing with 4 corners of 32*32 sprite
	// public static Sprite player0 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	// public static Sprite player1 = new Sprite(16, 1, 8, SpriteSheet.tiles);
	// public static Sprite player2 = new Sprite(16, 0, 9, SpriteSheet.tiles);
	// public static Sprite player3 = new Sprite(16, 1, 9, SpriteSheet.tiles);
	
	
	public static Sprite player_back = new Sprite(32, 0, 4, SpriteSheet.tiles );
	//public static Sprite player_left = new Sprite(32, 0, 5, SpriteSheet.tiles );
	//public static Sprite player_right = new Sprite(32, 0, 7, SpriteSheet.tiles );
	public static Sprite player_side = new Sprite(32, 0, 5, SpriteSheet.tiles );
	public static Sprite player_forward = new Sprite(32, 0, 6, SpriteSheet.tiles ); // co-ordinates are 0,4 when dealing with 32 pixel sprites
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE]; // creates new pixel array that is the size of the sprite
		this.x = x * size;//setting location of target sprite in spritesheet
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = colour;
		}
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
