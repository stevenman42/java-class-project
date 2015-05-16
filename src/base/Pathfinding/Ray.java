package base.Pathfinding;

import java.awt.Point;

import base.Physics;
import base.Entities.GameObject;
import base.Entities.Player;
import base.Map.Map;
import base.Map.TileID;

public class Ray {

	public static boolean castRay(GameObject obj){
		Point p = new Point((int)Player.staticX+16, (int)Player.staticY+16);
		Point o = new Point((int)obj.getX()+16,(int)obj.getY()+16);
		int deltaX = Math.abs(o.x-p.x), deltaY = Math.abs(o.y-p.y);

		if(deltaX >= deltaY){
			int currX;
			double currY;
			//complete
			if(o.x > p.x && o.y < p.y){
				deltaX = o.x - p.x;
				deltaY = p.y - o.y;
				currY = p.y;
				Point t;
				for(currX = p.x; currX < o.x; currX++){
					currY -= (double)deltaY/deltaX;
					t = Physics.getNearestPoint(currX, (int)currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;

			}
			//complete
			else if(o.x > p.x && o.y > p.y){
				deltaX = o.x - p.x;
				deltaY = o.y - p.y;
				currY = p.y;
				Point t;
				for(currX = p.x; currX < o.x; currX++){
					currY += (double)deltaY/deltaX;
					t = Physics.getNearestPoint(currX, (int)currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;

			}
			//complete
			else if(o.x < p.x && o.y < p.y){
				deltaX = p.x - o.x;
				deltaY = p.y - p.x;
				currY = p.y;
				Point t;
				for(currX = p.x; currX > o.x; currX--){
					currY -= (double)deltaY/deltaX;
					t = Physics.getNearestPoint(currX, (int)currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;

			}
			//complete
			else if(o.x < p.x && o.y > p.y){
				deltaX = p.x - o.x;
				deltaY = o.y - p.y;
				currY = p.y;
				Point t;
				for(currX = p.x; currX > o.x; currX--){
					currY -= (double)deltaY/deltaX;
					t = Physics.getNearestPoint(currX, (int)currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;
			}
		} else { 
			int currY;
			double currX;
			//complete?
			if(o.x > p.x && o.y < p.y){
				deltaX = o.x - p.x;
				deltaY = p.y - o.y;
				currX = p.x;
				Point t;
				for(currY = p.y; currY > o.y; currY--){
					currX += (double)deltaX/deltaY;
					t = Physics.getNearestPoint((int)currX, currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;
			}
			//complete
			else if(o.x > p.x && o.y > p.y){
				deltaX = o.x - p.x;
				deltaY = o.y - p.y;
				currX = p.x;
				Point t;
				for(currY = p.y; currY < o.y; currY++){
					currX += (double)deltaX/deltaY;
					t = Physics.getNearestPoint((int)currX, currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;
			}
			else if(o.x < p.x && o.y > p.y){
				deltaX = p.x - o.x;
				deltaY = o.y - p.y;
				currX = p.x;
				Point t;
				for(currY = p.y; currY < o.y; currY++){
					currX -= (double)deltaX/deltaY;
					t = Physics.getNearestPoint((int)currX, currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;
			}
			else if(o.x < p.x && o.y < p.y){
				deltaX = p.x - o.x;
				deltaY = p.y - o.y;
				currX = p.x;
				Point t;
				for(currY = p.y; currY > o.y; currY--){
					currX -= (double)deltaX/deltaY;
					t = Physics.getNearestPoint((int)currX, currY);
					if(Map.tileMap[t.y][t.x].getId() == TileID.bedRock) return false;
				}
				return true;
			}
		}



		return false;

	}
}
