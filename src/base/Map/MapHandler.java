package base.Map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import base.Game;
import base.Player;

public class MapHandler {

	public LinkedList<MapObject> object = new LinkedList<MapObject>();
	
	public void tick(){
		/*for(int i = 0; i < object.size(); i++){ //do this for all objects
			if(object.get(i).getId() == TileID.doorClose){
				MapObject tempObject = object.get(i); //gets current object id in list
				tempObject.tick(); //updates object
			}
		}*/
	}
	
	public void render(Graphics g, Graphics2D g2){
		for(int i = 0; i < object.size(); i++){ //renders all objects
			MapObject tempObject = object.get(i); 
			if(tempObject.getX() > Player.staticX-Game.WIDTH/2 && tempObject.getX() < Player.staticX+Game.WIDTH/2 && tempObject.getY() < Player.staticY+Game.HEIGHT/2 && tempObject.getY() > Player.staticY-Game.HEIGHT/2)
				tempObject.render(g2);
		}
		
	}
	
	//public void 
	//	for(int i = 0; i < object.size(); i++){ //renders all objects
	//  		MapObject tempObject = object.get(i); 
   //	}

	public void addObject(MapObject object){
		this.object.add(object);
	}
	
	public void removeObject(MapObject object){
		this.object.remove(object);
	} 
	
	
}