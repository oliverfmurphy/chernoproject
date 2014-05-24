package com.olivermurphy.chernoproject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.olivermurphy.chernoproject.entity.mob.Player;
import com.olivermurphy.chernoproject.graphics.Screen;
import com.olivermurphy.chernoproject.input.Keyboard;
import com.olivermurphy.chernoproject.input.Mouse;
import com.olivermurphy.chernoproject.level.Level;
import com.olivermurphy.chernoproject.level.TileCoordinate;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Rain";

	private Thread thread;
	private JFrame frame;
	private Keyboard key;  // keyboard class
	private Level level; // should only have one level loaded at one point in time
	private Player player;
	private boolean running = false;
	
	private Screen screen; // screen class

	// create the image
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // converting image object into an array of integers
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn; // because Level.spawn is static we can do this rather then level Level = new SpawnLevel etc..
		TileCoordinate playerSpawn = new TileCoordinate(20, 66);// 20, 67 is the location of where we want to spawn on the level(spawn.png))
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);// tile * pixels(16 pixels) customises spawn location when x and y defined
        player.init(level);
		
        Mouse mouse = new Mouse();
        
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");// i.e. thread = new Thread(new Game())
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Because it implements runnable it automatically calls the run() method
	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; // 1s / divided by tick length
		double delta = 0;
		int frames = 0; // count how many frames we have time to render every second
		int updates = 0; // how many times update method gets called every second -- should be 60
		requestFocus();  // Ensures you dont have to click screen to be able to control
		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) { // only happens 60 times a second
				update(); // tick , 60 per second
				updates++;
				delta--;
			}
			render(); // render as fast as we can
			frames++;
			
			// this will trigger once per second
			if (System.currentTimeMillis() - timer > 1000) { // 1000ms = 1s
				timer += 1000; //add 1000 to timer so it won't trigger again
				System.out.println(updates + "ups, " + frames + ", fps");
				frame.setTitle(title + " | " + updates + "ups, " + frames + ", fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	// i.e. ticks
	public void update() {
		key.update();
		player.update();
	}

	// 
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); //usually always 3 -- triple buffering, not much advantage going higher.
			return;
		}

		screen.clear(); // clears the screen
		int xScroll =  player.x - screen.width / 2; // putting player in the middle of the screen based on x
		int yScroll =  player.y - screen.height / 2; // putting player in the middle of the screen based on y
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();//creates a link between graphics and the bufferStrategy
		// all graphics must now be done here
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.setFont(new Font("Verdana", 0, 50));
		//g.drawString("X: " + player.x + ", Y: " + player.y, 350, 300);

		// test the mouse
		// g.fillRect(Mouse.getX() -32, Mouse.getY() -32, 64, 64);
		
		// test the button
		// if (Mouse.getButton() != -1) {
		// 	g.drawString("Button: " + Mouse.getButton(), 80, 80);
		//}
		
		
		g.dispose(); // releases system resources
		bs.show();   // displays next available buffer
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false); //always first for frame
		game.frame.setTitle(Game.title);
		game.frame.add(game); // add instance of game (component) to frame, can do this as Game extends canvas
		game.frame.pack();    // sizes up game to be the size of the component
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
