package base;
import java.util.ArrayList;

class Room{
	// this is a stub
}

/**
 * 
 * @author Steven
 * Takes a bunch of rooms, which are either 2d arrays, or objects that have a field that's a 2d array
 * Then it builds a level by putting together the rooms
 * 
 */
public class LevelGenerator {
	
	public int[][] CreateLevel(ArrayList<Room> rooms){
		int[][] newLevel = new int[128][128];
		
		return newLevel;
	};
	
	
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
