package com.olivermurphy.chernoproject.graphics;

import java.util.Random;

public class Screen {

    private int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    
    private Random random = new Random();
    
    public Screen(int width, int height){
    	this.width = width;
    	this.height = height;
    	pixels = new int[width * height];
    	
    	for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
    		tiles[i] = random.nextInt(0xffffff);
    	}
    }
    
    public void clear(){
    	for (int i = 0; i < pixels.length; i++){
    		pixels[i] = 0;
    	}
    }
 
    public void render(int xOffset, int yOffset){ 	
    	for (int y = 0; y < height; y++){
    		int yp = y + yOffset;
    		if (yp < 0 || yp >= height) continue;
     		for (int x = 0; x < width; x++){
     			int xp = x + xOffset;
     			if (xp < 0 || xp >= width) continue;
     			pixels[xp  + (yp * width)] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
    		}
    	}
    }

/*    public void render(int xoffset, int yoffset){ 	
    	for (int y = 0; y < height; y++){
    		int yy = y + yoffset;
    		//if (yy < 0 || yy >= height) break;
     		for (int x = 0; x < width; x++){
     			int xx = x + xoffset;
     			//if (xx < 0 || xx >= width) break;
        		//int tileIndex = (x / 16) + (y / 16) * 64; // first 32 pixels of x to be same tile, 64 is the map width
    			// & 63 (0 -> 63) when it gets to 64th tile return back to zero
     			// int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE; // bitwise operator, quicker than division, 2 to the power of 4 = 16
    			//pixels[x + y * width] = 0xff00ff; // x + (y * width)
    			// pixels[x + y * width] = tiles[tileIndex];
     			pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
    		}
    	}
    }
*/    
}
