package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;

import base.Input.MouseMover;
import base.Map.TileID;
import base.Visual.LightSource;

public class Player extends GameObject{
	
	Handler handler;
	LightSource playerLight;
	private float playerWidth = 32, playerHeight = 32;
	public static float staticX, staticY;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		playerLight = new LightSource(x+playerWidth/2, y+playerHeight/2, ID.Light, 100, handler);
		handler.addObject(playerLight);
		staticX = x;
		staticY = y;
	}

	public void tick() {
		if(dX > 0 && Physics.clearRight(this, TileID.bedRock))
			x += dX;
		if(dX < 0 && Physics.clearLeft(this, TileID.bedRock))
			x += dX;
		if(dY > 0 && Physics.clearUp(this, TileID.bedRock))
			y += dY;
		if(dY < 0 && Physics.clearDown(this, TileID.bedRock))
			y += dY;
		playerLight.setX(x+playerWidth/2);
		playerLight.setY(y+playerHeight/2);
		staticX = x;
		staticY = y;
		
		
				
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)(Game.WIDTH/2), (int)(Game.HEIGHT/2), (int)playerWidth, (int)playerHeight);
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)playerWidth,(int)playerHeight);
	}

	
	public Shape getCircleBounds() {
		return null;
	}
	
	public double getAngle(){
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
