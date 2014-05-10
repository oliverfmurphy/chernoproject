package com.olivermurphy.chernoproject.graphics;

import java.util.Random;

import com.olivermurphy.chernoproject.entity.mob.Player;
import com.olivermurphy.chernoproject.level.tile.Tile;

public class Screen {

    public int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    public int xOffset, yOffset;
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

/*  old method for rendering grass tiles    
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
*/
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
    
    //Rendering tile on offset based position
    // alternatively manage each tiles position manually
    public void renderTile(int xp, int yp, Tile tile) {
    	
    	xp -= xOffset; // minus as when we move right we want map to move left
    	yp -= yOffset;
    	
    	for (int y = 0; y < tile.sprite.SIZE; y++) {
    		int ya = y + yp; // ya => y absolute - y position + offset
        	for (int x = 0; x < tile.sprite.SIZE; x++) {
        		int xa = x + xp; // xa => x absolute
        		if (xa < -tile.sprite.SIZE || xa >= width || ya <0 || ya >= height) break; //only render tiles you see
        		if (xa < 0) xa = 0;
        		// where sprite is rendered = which pixels of sprite gets rendered
        		pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
        	}
    	}
    }
    
    // int flip instead of boolean as 4 states, x y/n & y y/n
    public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
    	xp -= xOffset; // minus as when we move right we want map to move left
    	yp -= yOffset;
    	
    	for (int y = 0; y < 32; y++) {
    		int ya = y + yp; // ya => y absolute - y position + offset
    		int ys = y;
    		if (flip == 2  || flip == 3) ys = 31 - y; // ys is ysprite
        	for (int x = 0; x < 32; x++) {
        		int xa = x + xp; // xa => x absolute
        		int xs = x;
        		if (flip == 1  || flip == 3) xs = 31 - x; // ys is ysprite
        		if (xa < -32 || xa >= width || ya <0 || ya >= height) break; //only render tiles you see
        		if (xa < 0) xa = 0;
        		
        		int col = sprite.pixels[xs + ys * 32];
        		
        		// only render if the colour is not a particular colour
        		// this is to remove the pink background from a sprite for example
        		// the additional leading ff is for the RGB alpha channel
        		if (col != 0xffda23ff) {
        		    // where sprite is rendered = which pixels of sprite gets rendered
        		    pixels[xa + ya * width] = col;
        		}
        	}
    	}
    	
    }
    
    
    public void setOffset(int xOffset, int yOffset) {
    	this.xOffset = xOffset;
    	this.yOffset = yOffset;
    }
    
    
    
    
    
    
    
    
    
    
}
