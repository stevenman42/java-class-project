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
	public static Point findScent(GameObject o){
		Point p = o.getNearestPoint();
		int maxScent = 0;
		Point maxScentPoint = p;
		for(int j = p.y-1; j < p.y+1 +1; j++){
			for(int k = p.x-1; k < p.x+1 +1; k++){
				int scent = Map.tileMap[j][k].getScent();
				if(scent > maxScent){
					maxScent = scent;
					maxScentPoint = new Point(k,j);
				}
			}
		}
		return maxScentPoint;
	}
}