package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

public abstract class Enemy extends GameObject{

	protected float width, height;
	
	public Enemy(float x, float y, ID id, float width, float height) {
		super(x, y, id);
		this.width = width;
		this.height = height;
	}

	

	
	public void render(Graphics g) {
		Color temp = g.getColor();
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		g.setColor(temp);
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

	
	public Shape getShapeBounds() {
		//until exact sprite bounds are needed, return the rect bounds
		return getBounds();
	}
	
	public float getWidth(){
		return width;
	}
	public float getHeight(){
		return height;
	}
	public void setWidth(float width){
		this.width = width;
	}
	public void setHeight(float height){
		this.height = height;
	}

}
