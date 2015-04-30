package base.Map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import base.Game;

public class Map {
	
	public static Tile[][] tileMap = new Tile[128][128];
	protected MapHandler mapHandler;
	public static boolean rendered = false;
	public static BufferedImage mapImage;
	
	public Map(MapHandler mapHandler){
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
			
			tileMap[5][10] = new Tile(10,10,TileID.bedRock);
			tileMap[10][10] = new Tile(10,10,TileID.bedRock);
			tileMap[10][0] = new Tile(10,10,TileID.bedRock);
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
	


}
