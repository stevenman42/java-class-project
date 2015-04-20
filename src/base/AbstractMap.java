package base;

import java.awt.Graphics;

public abstract class AbstractMap {
	
	/**
	 * the handler for the map
	 */
	private Handler handler;
	private MapID mapID;
	
	/**
	 * Default constructor
	 */
	public AbstractMap(Handler handler, MapID mapID){
		this.handler = handler;
		this.mapID = mapID;
	}
	
	/**
	 * updates the map
	 */
	public abstract void tick();
	
	/**
	 * renders the map
	 * @param g
	 */
	public abstract void render(Graphics g);

	
}
