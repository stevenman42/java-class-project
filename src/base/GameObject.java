package base;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;



public abstract class GameObject {
	//everything needs a location
	//everything is a gameobject
	

	protected float x,y,z;
	protected ID id;
	protected float dX,dY;
	protected float ddX, ddY;
	
	//constructor which creates objects based on data
	public GameObject(float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}

	
	//pass abstract classes to children
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//test for if two objects intersect
	public abstract Rectangle getBounds();
	public abstract Ellipse2D getCircleBounds();
	
	
	//accesors and mutators for the vars
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setDX(float dX){
		this.dX = dX;
	}
	public void setDY(float dY){
		this.dY = dY;
	}
	public float getDX(){
		return dX;
	}
	public float getDY(){
		return dY;
	}
	public float getDDX(){
		return ddX;
	}
	public void setDDX(float ddX){
		this.ddX = ddX;
	}
	public float getDDY(){
		return ddY;
	}
	public void setDDY(float ddY){
		this.ddY = ddY;
	}
	
	
}
	