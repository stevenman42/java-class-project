package base.Map;

import java.awt.Graphics;
import java.util.LinkedList;

public class MapHandler {

	public LinkedList<MapObject> object = new LinkedList<MapObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){ //do this for all objects
			MapObject tempObject = object.get(i); //gets current object id in list
			
			tempObject.tick(); //updates object
		}
	}
	
	public void render(Graphics g, Graphics g2){
		for(int i = 0; i < object.size(); i++){ //renders all objects
			MapObject tempObject = object.get(i); 
			
			tempObject.render(g);
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