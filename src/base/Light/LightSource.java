package base.Light;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import base.Game;
import base.GameObject;
import base.ID;

public class LightSource extends GameObject{
	
	protected float radius, staticRadius;
	protected float glowCount = 0;
	protected float dR = -1;

	
	public LightSource(float x, float y, ID id, float radius) {
		super(x, y, id);
		this.radius = radius;
		this.staticRadius = radius;
	}

	public void render(Graphics2D g2){
		
		Paint p = new RadialGradientPaint(
				new Point((int)x,(int)y),
				radius,
				new float[]{0,1f},
				new Color[]{new Color(50,50,0,0), new Color(0,0,0,255)});
		g2.setPaint(p);
		Arc2D.Double clipArc = ArcLight.arc;
		Area out = new Area(new Rectangle(0,0,Game.WIDTH, Game.HEIGHT));
		out.subtract(new Area(clipArc));
		g2.setClip(out);
		g2.fillRect((int)(x-radius), (int)(y-radius), (int)(radius*2), (int)(radius*2));
		
	}
	
	public void tick(){
		
		if(glowCount >=5){
			radius += dR;
			glowCount = 0;
		}
		if(radius > staticRadius*1.1){ 
			dR = -1;
		}
		if(radius < staticRadius*.9){
			dR = 1;
		}
		glowCount++;


		
	}

	public void render(Graphics g) {
		render((Graphics2D)g.create());
	}

	public Rectangle getBounds() {
		return new Rectangle((int)(x-radius), (int)(y-radius), (int)(radius*2), (int)(radius*2));
	}
	
	public Ellipse2D getCircleBounds(){
		return new Ellipse2D.Double((int)(x-radius), (int)(y-radius), (int)(radius*2), (int)(radius*2));
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")  || r = " + staticRadius;  
	}

	@Override
	public Arc2D getShapeBounds() {
		// TODO Auto-generated method stub
		return null;
	}



}
