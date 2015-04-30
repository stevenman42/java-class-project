package base.Map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import base.Game;

public class Map {
	
	public static Tile[][] tileMap = new Tile[128][128];
	protected ArrayList<Room> rooms;
	protected MapHandler mapHandler;
	public static boolean rendered = false;
	public static BufferedImage mapImage;
	
	public Map(MapHandler mapHandler, ArrayList<Room> rooms, Tile[][] tileMap){
		this.tileMap = tileMap;
		this.rooms = rooms;
		this.mapHandler = mapHandler;
		for(int r  = 0; r < tileMap.length; r++){
			for(int c = 0; c < tileMap[0].length; c++){
				if(r == 0 || c == 0 || r == tileMap.length-1 || c == tileMap[0].length - 1){
					mapHandler.addObject(new Tile(r,c,TileID.bedRock));
				}
				else if(tileMap[r][c] == null){
					mapHandler.addObject(new Tile(r,c,TileID.wood));
				}
			}
		}
		mapImage = new BufferedImage(3000,3000, BufferedImage.TYPE_INT_ARGB);

		
	}
	
	public static void renderMap(){
		Graphics gTemp = mapImage.createGraphics();
		for(int r = 0; r < tileMap.length; r++){
			for(int c = 0; c < tileMap[r].length; c++){
				Tile temp = Map.tileMap[r][c];
				gTemp.drawImage(Game.getIDImg(temp.getId()), (int)temp.getX(), (int)temp.getY(), null);
			}
		}
		rendered = true;
		
	}
	
	
	public Tile[][] getTileMap(){
		return tileMap;
	}
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}

}
