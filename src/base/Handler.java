package base;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){//dothis for all objects
			GameObject tempObject = object.get(i); //gets current object id in list
			
			tempObject.tick(); //updates object
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){ //renders all objects
			GameObject tempObject = object.get(i); 
			
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
