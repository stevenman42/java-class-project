package base;
import java.util.ArrayList;
import java.lang.Math;


class Room{
	// this is a stub, as you can see
	// I just made this to shut up the stupid IDE
	// I expect that we're going to have an actual class that represents the rooms at some point, and that will replace this one
	// Not in this file though probably, and it might not be called Room
	// System.out.println("YOLOOOO");
}

/**
 * 
 * @author Steven
 * Takes a bunch of rooms, which are either 2d arrays, or objects that have a field that's a 2d array
 * Then it builds a level by putting together the rooms
 * 
 */
public class LevelGenerator {
	
	private int floorID = 0;
	private int wallID = 1;
	private int doorID = 2;
	
	public int[][] CreateLevel(ArrayList<Room> rooms){
		int[][] newLevel = new int[128][128];
		
		return newLevel;
	};
	
	
	/**
	 * 
	 * This class only needs to be used when creating a "default" room with no parameters
	 * 
	 * @return newRoom
	 */
	private int[][] GenerateRoom(){
		int[][] newRoom = new int[(int)Math.random() * 7 + 10][(int)Math.random() * 7 + 10];
		for (int i = 0; i < newRoom[0].length; i ++){
			newRoom[0][i] = wallID;
		}
		
		
		
		
		return newRoom;
	}
	
	
	/**
	 * 
	 * This overloaded method doesn't take parameters because it just generates a bunch of empty rooms
	 * You don't have to have created any rooms to use it
	 * 
	 * @return newLevel
	 */
	public int[][] CreateLevel(){
		int[][] newLevel = new int[128][128];
		
		
		
		
		
		
		return newLevel;
	}

}
