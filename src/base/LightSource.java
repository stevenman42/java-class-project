package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;

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
				new Color[]{new Color(0,0,0,0), new Color(0,0,0,255)});
		g2.setPaint(p);
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
	
	public String toString(){
		return "(" + x + ", " + y + ")  || r = " + staticRadius;  
	}

}