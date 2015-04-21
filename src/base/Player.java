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
		Point mP = MouseMover.mPoint;
		double opp, adj;
		opp = mP.getY() - y;
		adj = mP.getX() - x;
		if(adj < 0)
			return -Math.tanh(opp/adj)*360 + Math.PI;
		return -Math.tanh(opp/adj)*2*Math.PI;
	}
	

}
