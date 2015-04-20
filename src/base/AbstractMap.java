package base;

import java.awt.Graphics;

public abstract class AbstractMap {
	
	/**
	 * the handler for the map
	 */
	private Handler handler;
	
	/**
	 * Default constructor
	 */
	public AbstractMap(Handler handler){
		this.handler = handler;
	}
	
	/**
	 * updtes the map
	 */
	public void tick(){
		
	}
	
	/**
	 * renders the map
	 * @param g
	 */
	public void render(Graphics g){
		
	}
	
	/**
	 * adds a GameObject to the map
	 * @param go
	 */
	public void addGameObject(GameObject go){
		handler.addObject(go);
	}
	
	/**
	 * removes the GameObject to the map
	 * @param go
	 */
	public void removeGameObject(GameObject go){
		handler.removeObject(go);

	}
	
}
