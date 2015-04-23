package base.Map;

import java.util.ArrayList;

public class Map {
	
	public static Tile[][] tileMap = new Tile[128][128];
	protected ArrayList<Room> rooms;
	protected MapHandler mapHandler;
	
	public Map(MapHandler mapHandler, ArrayList<Room> rooms, Tile[][] tileMap){
		this.tileMap = tileMap;
		this.rooms = rooms;
		this.mapHandler = mapHandler;
		for(int r  = 0; r < tileMap.length; r++){
			for(int c = 0; c < tileMap[0].length; c++){
				if(r == 0 || c == 0 || r == tileMap.length-1 || c == tileMap[0].length -1){
					tileMap[r][c] = new Tile(r,c,TileID.bedRock);
				}
				else if(tileMap[r][c] == null){
					tileMap[r][c] = new Tile(r,c,TileID.wood);
				}
				//mapHandler.addObject(tileMap[r][c]);
			}
		}
		
	}
	
	
	public Tile[][] getTileMap(){
		return tileMap;
	}
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}

}
