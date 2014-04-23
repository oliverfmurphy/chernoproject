package com.olivermurphy.chernoproject.level;

import java.util.Random;

public class RandomLevel extends Level {

	private final Random random = new Random();
	
	public RandomLevel(int width, int height) {
		super(width, height); // super refers to extending class and will execute code in super classes contructor
	}

    protected void generateLevel() {
    	for (int y = 0; y < height; y++){
    		for (int x = 0; x < width; x++) {
    			tiles[x + y * width] = random.nextInt(4); // 4 => 0-> 3
    			
    		}
    	}
    }
	
}
