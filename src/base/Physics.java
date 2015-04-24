package base;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;

import base.Map.Map;
import base.Map.MapID;
import base.Map.MapObject;
import base.Map.TileID;

public class Physics {
	
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
	public static boolean[] collisionDirection(GameObject go, TileID id){
		boolean[] directions = new boolean[4];
		Arrays.fill(directions, false);
		Rectangle goRect = go.getBounds();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX(),(int)go.getY()+1);
		if(Map.tileMap[goCoor.x][goCoor.y].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.x][goCoor.y].getBounds())){
			
		}
			
		return directions;
	}
	
	
	
	
	
	
	public static boolean clearLeft(GameObject go, TileID id){
		boolean notClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX()-1,(int)go.getY());
		notClear = Map.tileMap[goCoor.y][goCoor.x -1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y][goCoor.x - 1].getBounds());
		return !notClear;
	}
	
	public static boolean clearRight(GameObject go, TileID id){
		boolean notClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX()+1,(int)go.getY());
		notClear = Map.tileMap[goCoor.y][goCoor.x + 1].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y][goCoor.x + 1].getBounds());
		return !notClear;
	}
	
	public static boolean clearUp(GameObject go, TileID id){
		boolean notClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX(),(int)go.getY()+1);
		notClear = Map.tileMap[goCoor.y +1][goCoor.x].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y + 1][goCoor.x].getBounds());
		return !notClear;
	}
	
	public static boolean clearDown(GameObject go, TileID id){
		boolean notClear = false;
		Rectangle goRect = (Rectangle) go.getBounds().clone();
		Point goCoor = go.getNearestPoint();
		goRect.setLocation((int)go.getX(),(int)go.getY()-1);
		notClear = Map.tileMap[goCoor.y -1][goCoor.x].getId() == TileID.bedRock && goRect.intersects(Map.tileMap[goCoor.y -1][goCoor.x].getBounds());
		return !notClear;
	}

}