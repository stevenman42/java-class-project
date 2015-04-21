package base;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class AbstractMap {
	
	/**
	 * the handler for the map
	 */
	private MapHandler handler;
	
	/**
	 * Default constructor
	 */
	public AbstractMap(){
		handler = new MapHandler();
	}
	
	/**
	 * runs the tick() method for all GameObjects in the map
	 */
	public void tick(){
		handler.tick();
	}
	
	/**
	 * runs the render() method for all the objects in the game
	 * @param g
	 */
	public void render(Graphics g){
		handler.render(g);
	}
	
	/**
	 * adds a GameObject to the map
	 * @param go
	 */
	public void addGameObject(MapObject go){
		handler.addObject(go);
	}
	
	/**
	 * removes the GameObject to the map
	 * @param go
	 */
	public void removeGameObject(MapObject go){
		handler.removeObject(go);
	}
	
	/**
	 * the custom handler for the map
	 */
	protected class MapHandler{
		
		/**
		 * arraylist of all map objects
		 */
		private ArrayList<MapObject> mapData;
		
		/**
		 * DEFAULT CONSTRUCTOR
		 */
		public MapHandler(){
			mapData = new ArrayList<MapObject>();
		}
		
		/**
		 * ticks all of the map objects
		 */
		public void tick(){
			for(MapObject mo : mapData){
				mo.tick();
			}
		}
		
		/**
		 * renders the map
		 * @param g
		 */
		public void render(Graphics g){
			for(MapObject mo : mapData){
				mo.render(g);
			}
		}
		
		/**
		 * adds an object to the map
		 * @param mo
		 */
		public void addObject(MapObject mo){
			mapData.add(mo);
		}
		
		/**
		 * removes an object from the map
		 * @param mo
		 */
		public void removeObject(MapObject mo){
			mapData.remove(mo);
		}
		
	}
	
	/**
	 * the MapObject, used for rendering / scaling of the objects in the map
	 */
	protected abstract class MapObject{
		
		/**
		 * the gameObject
		 */
		private GameObject gameObject;
		
		/**
		 * scaled x & y values
		 */
		double x, y;
		
		/**
		 * constructor
		 * @param go
		 * @param x
		 * @param y
		 */
		public MapObject(GameObject go, double x, double y){
			gameObject = go;
			this.x = x;
			this.y = y;
		}
		
		/**
		 * returns scaled x
		 * @return
		 */
		public double getX(){
			return x;
		}
		
		/**
		 * returns scaled y
		 * @return
		 */
		public double getY(){
			return y;
		}
		
		/**
		 * returns the GameObject
		 * @return
		 */
		public GameObject getGameObject(){
			return gameObject;
		}
		
		/**
		 * renders the object
		 * @param g
		 */
		public abstract void render(Graphics g);
		
		/**
		 * ticks the object
		 */
		public void tick(){
			gameObject.tick();
		}
		
		/**
		 * returns the screen pixel value of x
		 * @return
		 */
		private int getRenderXVal(){
			return 0;
		}
		
		/**
		 * return the screen pixel value of y
		 * @return
		 */
		private int getRenderYVal(){
			return 0;
		}
		
	}
	
}