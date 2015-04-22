package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Player extends GameObject{
	
	Handler handler;
	LightSource playerLight;
	private float playerWidth = 32, playerHeight = 32;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		playerLight = new LightSource(x+playerWidth/2, y+playerHeight/2, ID.Light, 100);
		handler.addObject(playerLight);
	}

	public void tick() {
		x += dX;
		y += dY;
		playerLight.setX(x+playerWidth/2);
		playerLight.setY(y+playerHeight/2);
		
		
				
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, (int)playerWidth, (int)playerHeight);
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)playerWidth,(int)playerHeight);
	}

	
	public Ellipse2D getCircleBounds() {
		return null;
	}
	
	public double getAngle(){
		double ang = 0, adj, opp, dist;
		
		adj = MouseMover.mX - (x+16);
		opp = MouseMover.mY - (y+16);
		
		ang = Math.atan2(adj,opp);
		ang = Math.toDegrees(ang);
		
		return ang;
	}

	

}
