package base.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
	
	public int[][] CreateLevel(ArrayList<Room> rooms){ //the List of rooms is being created and handled by the MapHandler
		int[][] newLevel = new int[128][128];
		
		return newLevel;
	};
	
	
	/**
	 * 
	 * This class only needs to be used when creating a "default" room with no parameters
	 * Calm down bennett, we probably won't need this
	 * I hate defualt constructors -Bennett
	 * Fortunately this isn't even a constructor, it's a method, sooo.....
	 * 
	 * @return newRoom
	 */
	private int[][] GenerateRoom(){
		
		// creates a 2d array with a minimum length and width of 10, and a maximum of 16
		// Note: this does not include the walls.  The total length and width are in [12, 18]
		int[][] newRoom = new int[(int)(Math.random() * 7) + 12][(int)(Math.random() * 7) + 12]; // 12 to 18 
		
		
		for (int i = 0; i < newRoom[0].length; i ++){
			newRoom[0][i] = wallID;
			newRoom[newRoom.length - 1][i] = wallID;
		}
		
		for (int i = 0; i < newRoom.length; i ++){
			newRoom[i][0] = wallID;
			newRoom[i][newRoom[0].length - 1] = wallID;
		}
		
		return newRoom;
	}
	
	/** This just creates a random number of rooms, and then gives them to the CreateLevel method to make a level out of them
	 * It's an array of TempRoom objects, because the other option was a 3D array, and that's not something you want to be messing with,
	 * especially with rooms of different sizes
	 * */
	private TempRoom[] makeRooms(){
		TempRoom[] rooms = new TempRoom[(int) (Math.random() * 6) + 5]; // 5 to 10 rooms
		
		for (int i = 0; i < rooms.length; i ++){
			rooms[i] = new TempRoom(GenerateRoom());
			for (int j = 0; j < rooms[i].length; j ++){
				System.out.println(Arrays.toString(rooms[i].roomArray[j]));
			}
		}
		
		return rooms;
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
		
		TempRoom[] rooms = makeRooms();
		// upper left corners of all the rooms
		int[] originXList = new int[rooms.length];
		int[] originYList = new int[rooms.length];
		// lower right corners of all the rooms (actually one below and to the right of the corner)
		int[] oppositeXList = new int[rooms.length];
		int[] oppositeYList = new int [rooms.length];
		int x = 0;
		for (int i = 0; i < rooms.length; i ++){
			
			
			int max = (i + 1) * ((int) 110 / rooms.length);
			int min = i * ((int) 110 / rooms.length) + 1;
			originXList[i] = (int) (Math.random() * (max - min + 1) ) + min;
			originYList[i] = (int)(Math.random() * (128) + 1);
			oppositeXList[i] = originXList[i] + rooms[i].width;
			oppositeYList[i] = originYList[i] + rooms[i].length;
			
			System.out.print("(" + originXList[i] + ", " + originYList[i] + ") ");
			System.out.println("[" + oppositeXList[i] + ", " + oppositeYList[i] + "] ");
		}
		
		// this is the loop that actually merges the room matrices with the super level matrix 
		for (int i = 0; i < newLevel.length; i ++){
			for (int j = 0; j < newLevel[0].length; j ++){
				
			}
		}
		
		for (int i = 0; i < newLevel.length; i ++){
			for (int j = 0; j < newLevel[0].length; i ++){
				
			}
		}
		
		
		
		
		return newLevel;
	}
	
	public static void main(String [] args){
		
		
		LevelGenerator l = new LevelGenerator();
		l.CreateLevel();
		

		
		// stoopid is now a list of TempRooms (essentially a list of 2D lists)
		//TempRoom[] stoopid = l.makeRooms();
	}

}

/**
 * 
 * @author Steven
 * If you are using this class, and you're not generating levels, YOU ARE DOING SOMETHING WRONG AND YOU NEED TO STOP NOW STOP PLEASE DON'T DON'T DO THIS YOU THINK YOU KNOW WHAT YOU'RE DOING BUT YOU DON'T
 *
 */
class TempRoom{
	
	int[][] roomArray;
	int length;
	int width;
	
	public TempRoom(int[][] roomittyRoomRoomRoomerRoomRoomRoom){
		roomArray = roomittyRoomRoomRoomerRoomRoomRoom;
		length = roomArray.length;
		width = roomArray[0].length;
	}
	
	
	public String toString(){
		return "This is not the Room you're looking for";
	}
	
}
