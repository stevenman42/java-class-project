package base.Map;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import base.Game;

public class Tile extends MapObject{
	

	public Tile(float x, float y, TileID id) {
		super(x*32, y*32, id);
		Map.tileMap[(int)x][(int)y] = this;
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		
	}

	public void render(Graphics2D g2) {
		g2.drawImage(Game.getIDImg(id), (int)x, (int)y, null);
		/*
		Color tempColor = g2.getColor();
		g2.setColor(Color.white);
		g2.fillRect((int)x,(int)y,32,32);
		g2.setColor(tempColor);
		*/
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	public Shape getShapeBounds(){
		return getBounds();
	}
	
	public void addObject(){
	}
	
	public String toString(){
		return id + "";
	}
	

}
