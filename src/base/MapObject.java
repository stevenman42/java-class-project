package base;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class MapObject {
	
	protected float x,y,dX,dY;
	protected MapID id;
	public MapObject(float x, float y, MapID id){
		this.x = x;
		this.y = y;
		this.id = id;
		
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	
	
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
	public void setId(MapID id){
		this.id = id;
	}
	public MapID getId(){
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
}
