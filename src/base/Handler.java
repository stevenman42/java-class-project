package base;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){//dothis for all objects
			GameObject tempObject = object.get(i); //gets current object id in list
			
			tempObject.tick(); //updates object
		}
	}
	
	public void render(Graphics g, Graphics2D g2){
		for(int i = 0; i < object.size(); i++){ //renders all objects
			GameObject tempObject = object.get(i); 
			if(tempObject.getId() == ID.Light || tempObject.getId() == ID.ArcLight){
				tempObject.render(g2);
			}
			else
				tempObject.render(g);
		}
		for(int i = 0; i < object.size(); i++){ //renders player on top
			GameObject tempObject = object.get(i); 
			if(tempObject.getId() == ID.Player)
				tempObject.render(g);
		}
		
		
	}
	
	//public void 
	//	for(int i = 0; i < object.size(); i++){ //renders all objects
	//  		GameObject tempObject = object.get(i); 
   //	}

	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	} 
	
}
