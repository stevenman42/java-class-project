package base.Map;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

public abstract class MapObject {
	
	protected float x,y,dX,dY;
	protected TileID id;
	protected Point tilePoint;
	public MapObject(float x, float y, TileID id){
		this.x = x;
		this.y = y;
		this.id = id;
		tilePoint = new Point((int)x,(int)y);
		
	}

	public abstract void tick();
	public abstract void render(Graphics2D g2d);
	
	public abstract Rectangle getBounds();
	public abstract Shape getShapeBounds();
	
	public Point getPoint(){
		return tilePoint;
	}
	public void setX(float x){
		this.x = x;
		tilePoint = new Point((int)x,(int)y);
	}
	public void setY(float y){
		this.y = y;
		tilePoint = new Point((int)x,(int)y);
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setId(TileID id){
		this.id = id;
	}
	public TileID getId(){
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
