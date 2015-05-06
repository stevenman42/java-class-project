package base.Map;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import base.Game;

public class Tile extends MapObject{
	

	public Tile(float x, float y, TileID id) {
		super(y*32, x*32, id);
		//Map.tileMap[(int)y][(int)x] = this;
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
		if(id == TileID.bedRock){
			return "bedRock";
		}
		if(id == TileID.wood){
			return "wood";
		}
		if(id == TileID.cobble){
			return "cobble";
		}
		if(id == TileID.chest){
			return "chest";
		}
		if(id == TileID.missing){
			return "missing";
		}
		if(id == TileID.doorClose){
			return "doorclose";
		}
		if(id == TileID.doorOpen){
			return "dooropen";
		}
		return "???";
	}
	

}
