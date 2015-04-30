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
		LevelGenerator lg = new LevelGenerator();
		int[][] LG = lg.createLevel(128, 128);
		for(int r  = 0; r < tileMap.length; r++){
			for(int c = 0; c < tileMap[0].length; c++){
				
				if(r == 0 || c == 0 || r == tileMap.length-1 || c == tileMap[0].length -1){
					tileMap[r][c] = new Tile(r,c,TileID.bedRock);
				}
				else{
					if(LG[r][c] == 0)
						tileMap[r][c] = new Tile(r,c,TileID.wood);
					else if(LG[r][c] == 3)
						tileMap[r][c] = new Tile(r,c,TileID.cobble);
					else if(LG[r][c] == 1)
						tileMap[r][c] = new Tile(r,c,TileID.bedRock);
					else if(LG[r][c] == 2)
						tileMap[r][c] = new Tile(r,c,TileID.doorClose);
					else
						tileMap[r][c] = new Tile(r,c,TileID.missing);
				
				}
				//mapHandler.addObject(tileMap[r][c]);
				}
				
			}
		
		
		int size = tileMap.length*32;
		int size2 = tileMap[0].length*32;
		mapImage = new BufferedImage(size,size2, BufferedImage.TYPE_INT_ARGB);

		
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
