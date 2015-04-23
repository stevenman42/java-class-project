package base.Map;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Room extends MapObject{

	protected TileID[][] tileMap;
	protected float roomNumber;
	
	
	public Room(float x, float y, float w, float h, MapID roomID) {
		super(x, y, TileID.wood); //needTOfiXSTHSI
		
		tileMap = new TileID[(int)h][(int)w];
		//generateRoom(tileMap, h, k, roomID);
	
	}

	public void tick() {
		
	}

	public void render(Graphics2D g2) {
		for(int r = 0; r < tileMap.length; r++){
			for(int c = 0; c < tileMap[0].length; c++){
				TileID tileID = tileMap[r][c];
				
			}
		}
	}

	public Rectangle getBounds() {
		return null;
	}

	public TileID[][] getTileMap(){
		return tileMap;
	}
}
