package base;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;

import base.Entities.GameObject;
import base.Entities.ID;
import base.Entities.Player;
import base.Map.Map;
import base.Map.MapObject;
import base.Map.TileID;

public class Physics {
	
	public static Point getNearestPoint(int x, int y){
		return new Point((x+16)/32,(y+16)/32);
	}
	public static Point getNearestPoint(float x, float y){
		return getNearestPoint((int)x,(int)y);
	}
	public static boolean collisionList(GameObject go, LinkedList<MapObject> moList, TileID id){
		for(int i = 0; i < moList.size(); i++){
			if(moList.get(i).getId() == id){
				if(go.getBounds().intersects(moList.get(i).getBounds())){
					return true;
				}
			}
		}
	return false;
		
	}
	
	/**
	 * 
	 * @return Returns the direction(s) in which a collision will occur within a move of a pixel of object A in that direction
	 */

	public static boolean collision(Player p, ID[] id, Handler handler){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			for(ID Id: id)
				if(tempObject.getId() == Id && tempObject.getBounds().intersects(p.getBounds())){
					return true;
				}
		}
		return false;
	}
	
	
	
	
	
	
	public static boolean clearLeft(GameObject go, TileID id){
		boolean notClear = false, cornerTopClear = false, cornerBottomClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX()-3,(int)go.getY());
		notClear = Map.tileMap[goCoor.y][goCoor.x - 1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y][goCoor.x - 1].getBounds());
		cornerTopClear = (Map.tileMap[goCoor.y-1][goCoor.x-1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y-1][goCoor.x-1].getBounds()));
		cornerBottomClear = (Map.tileMap[goCoor.y+1][goCoor.x-1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y+1][goCoor.x-1].getBounds()));
		return !notClear && !cornerTopClear && !cornerBottomClear;
	}
	
	public static boolean clearRight(GameObject go, TileID id){
		boolean notClear = false, cornerTopClear = false, cornerBottomClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX()+2,(int)go.getY());
		notClear = Map.tileMap[goCoor.y][goCoor.x + 1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y][goCoor.x + 1].getBounds());
		cornerTopClear = (Map.tileMap[goCoor.y-1][goCoor.x+1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y-1][goCoor.x+1].getBounds()));
		cornerBottomClear = (Map.tileMap[goCoor.y+1][goCoor.x+1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y+1][goCoor.x+1].getBounds()));
		return !notClear && !cornerTopClear && !cornerBottomClear;
	}
	
	public static boolean clearDown(GameObject go, TileID id){
		boolean notClear = false, cornerLeftClear = false, cornerRightClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX(),(int)go.getY()+2);
		notClear = Map.tileMap[goCoor.y+1][goCoor.x].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y+1][goCoor.x].getBounds());
		cornerLeftClear = (Map.tileMap[goCoor.y+1][goCoor.x-1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y+1][goCoor.x-1].getBounds()));
		cornerRightClear = (Map.tileMap[goCoor.y+1][goCoor.x+1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y+1][goCoor.x+1].getBounds()));
		return !notClear && !cornerLeftClear && !cornerRightClear;
	}
	
	public static boolean clearUp(GameObject go, TileID id){
		boolean notClear = false, cornerLeftClear = false, cornerRightClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX(),(int)go.getY()-3);
		notClear = Map.tileMap[goCoor.y-1][goCoor.x].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y-1][goCoor.x].getBounds());
		cornerLeftClear = (Map.tileMap[goCoor.y-1][goCoor.x-1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y-1][goCoor.x-1].getBounds()));
		cornerRightClear = (Map.tileMap[goCoor.y-1][goCoor.x+1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y-1][goCoor.x+1].getBounds()));
		return !notClear && !cornerLeftClear && !cornerRightClear;
	}

}
