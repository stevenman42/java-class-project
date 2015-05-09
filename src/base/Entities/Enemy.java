package base.Entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import base.Pathfinding.Ray;

public abstract class Enemy extends GameObject{

	protected float width, height;
	protected int health;
	protected boolean dormant;
	
	public Enemy(float x, float y, ID id, float width, float height, int health) {
		super(x, y, id);
		this.width = width;
		this.height = height;
		this.health = health;
		dormant = true;
	}

	public void tick(){
		if(Ray.castRay(this)){
			System.out.println("Has LOS");
		}
	}
	
	public void render(Graphics2D g2) {
		Color temp = g2.getColor();
		g2.setColor(Color.red);
		g2.fillRect((int)x, (int)y, (int)width, (int)height);
		g2.setColor(temp);
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
	public int getHealth(){
		return health;
	}
	public void setHealth(int health){
		this.health = health;
	}

}
