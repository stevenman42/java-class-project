package base;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import base.Input.KeyInput;
import base.Input.MouseInput;
import base.Input.MouseMover;
import base.Map.Map;
import base.Map.MapHandler;
import base.Map.Room;
import base.Map.Tile;
import base.Map.TileID;
import base.Menus.HUD;
import base.Menus.Menu;
import base.Menus.Pause;
import base.Visual.ArcLight;
import base.Visual.Camera;
import base.Visual.LightSource;
import base.Visual.Overlay;


public class Game extends Canvas implements Runnable{

	//private static final long serialVersionUID = 3054892105735692509L;
	// thanks chad
	// private static final long serialVersionID = chad's_mom's_phone_number;
	private static final long serialVersionUID = 6969696969696969696L;
	
	//set window size
	public static final int WIDTH = 720, HEIGHT = WIDTH / 14 * 9;
	public static final int MAPWIDTH = 128*32, MAPHEIGHT = 128*32;


	//make a running instance thread for the game(what it runs on)
	private Thread thread;
	public boolean running = false;
	
	private Random r = new Random();
	//make a handler
	private Handler handler;
	private MapHandler mapHandler;
	private Camera cam;
	private Map map;
	
	
	//make the HUD
	private HUD hud;
	private Menu menu;
	private Pause pause;
	private Overlay overlay;
	private ArcLight arcLight;
	private Player p;
	
	private static BufferedImage background, missingTileImg, woodTileImg, cobbleTileImg, doorClosedTileImg;

	public static enum STATE{
		MENU,
		GAME,
		PAUSE
	};
	
	public static STATE State = STATE.MENU;

	
	public Game(){
		handler = new Handler();
		mapHandler = new MapHandler();
		map = new Map(mapHandler, new ArrayList<Room>(), new Tile[128][128]);

		
		new Window(WIDTH, HEIGHT, "Elite Group Project", this);
		
		addKeyListener(new KeyInput(handler));
		addMouseMotionListener(new MouseMover());
		addMouseListener(new MouseInput());
		
		hud = new HUD();
		menu = new Menu();
		menu.inil();
		menu.openMenu();//the first gamestate is defaultly menu, therefore openMenu should be called
		addMouseListener(menu.getMenuMouseListener());
		pause = new Pause();
		cam = new Camera(0,0);
		
		try {
            background = ImageIO.read(new File("RES/Textures/tank.png"));
            missingTileImg = ImageIO.read(new File("RES/Textures/missingTile.png"));
            woodTileImg = ImageIO.read(new File("RES/Textures/woodTile.png"));
            cobbleTileImg = ImageIO.read(new File("RES/Textures/cobbleTile.png"));
            doorClosedTileImg = ImageIO.read(new File("RES/Textures/doorClosedTile.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		for(int i =0; i < 80; i++){
			for(int j = 0; j < 80; j++){
				if(i == 0 || j == 0 || i == 79 || j == 79)
					mapHandler.addObject(new Tile(i,j,TileID.bedRock));
				else if(i%10 < 5 && j%10 < 5){
					mapHandler.addObject(new Tile(i,j,TileID.cobble));
				}
				else
					mapHandler.addObject(new Tile(i,j,TileID.wood));
			}
		}
		p = new Player(Game.WIDTH/2,Game.HEIGHT/2,ID.Player, handler);
		handler.addObject(p);
		arcLight = new ArcLight(p.getX()+16, p.getY()+16, ID.ArcLight, 300, 10, p, handler);
		handler.addObject(arcLight);
		overlay = new Overlay(handler, arcLight);

		
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
				System.out.println("FPS: " + frames);
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
		if(Game.State == Game.STATE.GAME){
			handler.tick();
			//mapHandler.tick();
			for(int i = 0; i < handler.object.size(); i++){
				if(handler.object.get(i).getId() == ID.Player){
					cam.tick(handler.object.get(i));
				}
			}
		}
		else if(Game.State == Game.STATE.MENU){
			
		}
			
		else{}
		
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
		
		
		if(State == Game.STATE.GAME){
			g2d.setColor(new Color(255,255,255,255));
		}
		else if(State == Game.STATE.PAUSE){
			g.setColor(Color.red);
		}
		else{
			g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
		}
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(Game.State == Game.STATE.GAME){
			
			g2d.translate(cam.getX(), cam.getY()); //begin cam
			
			g.setColor(Color.black);
			g.fillRect(0, 0, MAPWIDTH, MAPHEIGHT);
			Area in = new Area(new Rectangle());
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				if(tempObject.id == ID.Light){
					tempObject = (LightSource) tempObject;
					in.add(new Area(tempObject.getBounds()));
				}
			}
			Area arcIn = new Area(arcLight.getShapeBounds());
			in.add(arcIn);
			g2d.clip(in);
			
			g2d.drawImage(background, 0,0,this);
			mapHandler.render(g, g2d);


			
			g2d.setClip(null);
			
			
			handler.render(g, g2d);
			

			
			g2d.translate(-cam.getX(), -cam.getY()); //end of cam
			


		}
		else if (Game.State == Game.STATE.MENU){
			g.fillRect(0, 0, WIDTH, HEIGHT);
			if(menu != null)
				menu.render(g);
		}
		
		
		
		g2d.dispose();
		g.dispose();
		bs.show();
	}

	public static void main(String args[]){
		new Game();
	}

	
	public static BufferedImage getIDImg(TileID tileID){
		if(TileID.bedRock == tileID){
			return missingTileImg;
		}
		else if(TileID.wood == tileID){
			return woodTileImg;
		}
		else if(TileID.cobble == tileID){
			return cobbleTileImg;
		}
		return missingTileImg;
	}

}
