package base.Pathfinding;

import java.awt.Point;

import com.sun.corba.se.spi.ior.iiop.MaxStreamFormatVersionComponent;

import base.Entities.GameObject;
import base.Map.Map;


public class Scent{
	
	
	public static boolean isScent(GameObject o){
		Point p = o.getNearestPoint();
		if(Map.tileMap[p.y][p.x].getScent() > 0){
			return true;
		}
		return false;
		
	}

	/*
	 * @return next move (0 = right, 1 = up, 2 = left, 3 = down)
	 */
	public static int findScent(GameObject o){
		Point p = o.getNearestPoint();
		int maxScent = 0;
		int maxScentDirection = -1;
		if(Map.tileMap[p.y][p.x+1].getScent() > maxScent){
			maxScent = Map.tileMap[p.y][p.x].getScent();
			maxScentDirection = 0;
		}
		if(Map.tileMap[p.y-1][p.x].getScent() > maxScent){
			maxScent = Map.tileMap[p.y][p.x].getScent();
			maxScentDirection = 1;
		}
		if(Map.tileMap[p.y][p.x-1].getScent() > maxScent){
			maxScent = Map.tileMap[p.y][p.x].getScent();
			maxScentDirection = 2;
		}
		if(Map.tileMap[p.y+1][p.x].getScent() > maxScent){
			maxScent = Map.tileMap[p.y][p.x].getScent();
			maxScentDirection = 3;
		}
		if(Map.tileMap[p.y][p.x].getScent() > maxScent){
			maxScent = Map.tileMap[p.y][p.x].getScent();
			maxScentDirection = -1;
		}
		return maxScentDirection;
	}
}