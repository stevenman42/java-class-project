package base;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 3054892105735692509L;
	
	//set window size
	public static final int WIDTH = 720, HEIGHT = WIDTH / 14 * 9;

	//make a running instance thread for the game(what it runs on)
	private Thread thread;
	public boolean running = false;
	
	private Random r = new Random();
	//make a handler
	private Handler handler;
	
	//make the HUD
	private HUD hud;
	private Menu menu;
	private Pause pause;
	private Overlay overlay;
	
	private BufferedImage background;

	public static enum STATE{
		MENU,
		GAME,
		PAUSE
	};
	
	public static STATE State = STATE.MENU;

	
	public Game(){
		handler = new Handler();
		
		new Window(WIDTH, HEIGHT, "Elite Group Project", this);
		
		addKeyListener(new KeyInput(handler));
		addMouseListener(new MouseInput());
		
		hud = new HUD();
		menu = new Menu();
		pause = new Pause();
		overlay = new Overlay(handler);
		
		try {
            background = ImageIO.read(new File("tank.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

		handler.addObject(new LightSource(300,200,ID.Light,100));
		handler.addObject(new LightSource(100,100,ID.Light,50));
		handler.addObject(new LightSource(425, 200, ID.Light, 50));
		handler.addObject(new Player(Game.WIDTH/2,Game.HEIGHT/2,ID.Player, handler));
		
	}
	
	
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) /ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			//	System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	//start the game (through starting the thread)
	public synchronized void start(){
		thread  = new Thread(this);
		thread.start();
		running = true;
	}
	
	//if it fails give a reason why
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void tick(){
		handler.tick();
	}
	
	public void render(){
		this.requestFocus();
		
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g.create();
		
		g.drawImage(background, 0,0,this);
		
		if(State == Game.STATE.GAME){
			g.setColor(Color.green);
		}
		else if(State == Game.STATE.PAUSE){
			g.setColor(Color.red);
		}
		else{
			g.setColor(Color.blue);
		}
		
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		overlay.render(g2d);
		
		g2d.dispose();
		g.dispose();
		bs.show();
	}

	public static void main(String args[]){
		new Game();
	}
}
