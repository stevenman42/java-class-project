package base.Pathfinding;

import java.awt.Point;

import base.Physics;
import base.Entities.GameObject;
import base.Entities.Player;
import base.Map.Map;
import base.Map.TileID;

public class Ray {

	public static boolean castRay(GameObject o){
		boolean LOS = true;
		Point start = new Point((int)o.getX(),(int)o.getY()), end = new Point((int)Player.staticX,(int)Player.staticY);
		for(int i = start.x; i < end.x; i++){
			double slope = (((double)end.y/start.y)/(double)end.x/start.x);
			int val = (int) ( -slope*i - start.y);
			Point test = Physics.getNearestPoint(i, val);
			if(Map.tileMap[test.y/32][test.x/32].getId() == TileID.bedRock){
				LOS = false;
			}
		}
		return LOS;
	}
}
