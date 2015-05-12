package base.Pathfinding;

import java.awt.Point;

import base.Physics;
import base.Entities.GameObject;
import base.Entities.Player;
import base.Map.Map;
import base.Map.TileID;

public class Ray {

	public static boolean castRay(GameObject obj){
		boolean LOS = true;

		Point p = Physics.getNearestPoint(Player.staticX, Player.staticY);
		Point o = obj.getNearestPoint();
		int deltaX = o.x-p.x, deltaY = o.y-p.y;
		int y = p.y;
		if(Math.abs(deltaX) < Math.abs(deltaY) || Math.abs(deltaX) <= 10){

		}
		else{ //(Math.abs(deltaX) > Math.abs(deltaY)){
			int slope = Math.abs(deltaY/deltaX);
			if(deltaX > 0){
				for(int x = p.x; x <= o.x;x++){
					if(deltaY > 0){
						y -= slope;
					}
					else if(deltaY < 0){
						y += slope;
					}
					if(Map.tileMap[y][x].getId() == TileID.bedRock){
						return false;
					}
				}
			}
			else if(deltaX < 0){
				for(int x = p.x; x >= o.x;x--){
					if(deltaY > 0){
						y -= slope;
					}
					else if(deltaY < 0){
						y += slope;
					}
					if(Map.tileMap[y][x].getId() == TileID.bedRock){
						return false;
					}
				}

			}

		}



		return LOS;

	}
}
