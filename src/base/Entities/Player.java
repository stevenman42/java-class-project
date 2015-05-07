package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;

import base.Game;
import base.Handler;
import base.Physics;
import base.Input.MouseMover;
import base.Items.Container;
import base.Map.Map;
import base.Map.TileID;
import base.Visual.LightSource;
import base.audio.Audio;

public class Player extends GameObject{
	
	Handler handler;
	LightSource playerLight;
	Audio audio;
	int audioPlaying = 0;
	boolean leftFoot = true;
	private float playerWidth = 32, playerHeight = 32;
	public static float staticX, staticY;
	public static Container container;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		playerLight = new LightSource(x+playerWidth/2, y+playerHeight/2, ID.Light, 100, handler);
		handler.addObject(playerLight);
		staticX = x;
		staticY = y;
		container = new Container();
	}
	
	

	public void tick() {
		if(Physics.collision(this, Game.EnemyIDList, handler)){
			Game.State = Game.STATE.MENU;
		}
		if(dX > 0 && Physics.clearRight(this, TileID.bedRock))
			x += dX;
		if(dX < 0 && Physics.clearLeft(this, TileID.bedRock))
			x += dX;
		if(dY > 0 && Physics.clearUp(this, TileID.bedRock))
			y += dY;
		if(dY < 0 && Physics.clearDown(this, TileID.bedRock))
			y += dY;
		if(dY != 0 || dX != 0){
			Point p = getNearestPoint();
			if(audioPlaying <= 0 && Map.tileMap[p.y][p.x].getId() == TileID.wood){
				if(leftFoot || audioPlaying != 0){
					audio = new Audio("RES/Audio/GravelStep.wav");
					leftFoot = !leftFoot;
				}else{
					audio = new Audio("RES/Audio/GravelStepReverse.wav");
					leftFoot = !leftFoot;
				}
				audio.play();
				audioPlaying = 50;
			}
			//here is where you add TileID sounds for other blocks

		}
		audioPlaying--;
		
		playerLight.setX(x+playerWidth/2);
		playerLight.setY(y+playerHeight/2);
		staticX = x;
		staticY = y;
		
		
				
	}

	public void render(Graphics g, Graphics2D g2) {
		g.setColor(Color.green);
		g.fillRect((int)(Game.WIDTH/2), (int)(Game.HEIGHT/2), (int)playerWidth, (int)playerHeight);		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)playerWidth,(int)playerHeight);
	}

	
	public Shape getCircleBounds() {
		return null;
	}
	
	public static double getAngle(){
		double ang = 0, adj, opp, dist;
		
		adj = MouseMover.mX - (Game.WIDTH/2 +16);
		opp = MouseMover.mY - (Game.HEIGHT/2 + 16);
		
		ang = Math.atan2(adj,opp);
		ang = Math.toDegrees(ang);
		
		ang = ang - 90;
		
		if(ang < 0 && ang >= -270){
			ang = ang +360;
		}
		
		return ang;
	}

	@Override
	public Arc2D getShapeBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
