package base.Map;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 
 * @author Steven
 * Makes a bunch of rooms, which are either 2d arrays, or objects that have a field that's a 2d array
 * Then it builds a level by putting together the rooms
 * 
 */
public class LevelGenerator {
	
	private int nullID = 0; // this is the empty spaces in the map
	private int floorID = 1; //wood floor
	private int wallID = 2; //bedrock
	private int doorID = 3; //door
	private int hallID = 4; //gravel floor
	
	private int minRooms = 4;
	
	//i changed this number and now nothing works
	//gg
	private int maxRooms = 5;
	
	private int maxRoomSize = 18;
	private int minRoomSize = 12;
	
	private int[] centerXList;
	private int[] centerYList;
	

	/**
	 * 
	 * This class only needs to be used when creating a "default" room with no parameters
	 * Actually it looks like it's going to be the main class used when creating a room
	 * 
	 * @return newRoom
	 */
	private int[][] GenerateRoom(){
		
		// creates a 2d array with a minimum length and width of maxRoomSize - 2, and a maximum of minRoomSize - 2
		// Note: this does not include the walls.  The total length and width are in [maxRoomSize, minRoomSize]
		int[][] newRoom = new int[(int)(Math.random() * (maxRoomSize - minRoomSize + 1)) + minRoomSize][(int)(Math.random() * (maxRoomSize - minRoomSize + 1)) + minRoomSize];
		
		
		for (int i = 0; i < newRoom[0].length; i ++){
			newRoom[0][i] = wallID;
			newRoom[newRoom.length - 1][i] = wallID;
		}
		
		for (int i = 0; i < newRoom.length; i ++){
			newRoom[i][0] = wallID;
			newRoom[i][newRoom[0].length - 1] = wallID;
		}
		for(int r = 0; r < newRoom.length;r++){
			for(int c = 0; c < newRoom[r].length; c++){
				if(newRoom[r][c] == 0){
					newRoom[r][c] = floorID;
				}
			}
		}
		
		return newRoom;
	}
	
	/** This just creates a random number of rooms, and then gives them to the CreateLevel method to make a level out of them
	 * It's an array of TempRoom objects, because the other option was a 3D array, and that's not something you want to be messing with,
	 * especially with rooms of different sizes
	 * */
	private TempRoom[] makeRooms(){
		

		
		TempRoom[] rooms = new TempRoom[(int) (Math.random() * (maxRooms - minRooms + 1)) + minRooms];
		
		for (int i = 0; i < rooms.length; i ++){
			rooms[i] = new TempRoom(GenerateRoom());
			for (int j = 0; j < rooms[i].length; j ++){
				//System.out.println(Arrays.toString(rooms[i].roomArray[j]));
			}
		}
		
		return rooms;
	}
	
	private int[][] makeHalls(int[] originXList, int[] originYList, int[] oppositeXList, int[] oppositeYList, int[][] level){
		
		centerXList = new int[originXList.length];
		centerYList = new int[originXList.length];
		
		
		// creates two lists with all the coordinates of the centers of the rooms
		// the hallways are going to be drawn from center to center before the rooms are placed, and then the rooms are going to be placed over the halls
		for (int i = 0; i < originXList.length; i ++){
			centerXList[i] = (originXList[i] + oppositeXList[i]) / 2;
			centerYList[i] = (originYList[i] + oppositeYList[i]) / 2;
		}
		
		for (int a = 0; a < centerXList.length - 1; a ++){
			
			for (int i = centerXList[a]; i < centerXList[a + 1]; i ++){
				// creates the horizontal halls
				if (level[centerYList[a] + 2][i] == 0)
					level[centerYList[a] + 2][i] = wallID;
				if (level[centerYList[a] - 2][i] == 0) 
					level[centerYList[a] - 2][i] = wallID;
				level[centerYList[a]][i] = hallID;
				level[centerYList[a]-1][i] = hallID;
				level[centerYList[a]+1][i] = hallID;
				
				try{
					if (level[centerYList[a] + 2][i] == 0)
						level[centerYList[a] + 2][i] = wallID;
					if (level[centerYList[a] - 2][i] == 0) 
						level[centerYList[a] - 2][i] = wallID;
					level[centerYList[a]][i] = hallID;
					level[centerYList[a]-1][i] = hallID;
					level[centerYList[a]+1][i] = hallID;
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println(i);
					System.out.println(Arrays.toString(centerXList));
				}
			}
			
			if (centerYList[a] < centerYList[a + 1]){
				for (int i = centerYList[a]; i < centerYList[a + 1]; i ++){
					if (level[i][centerXList[a + 1] + 2] == 0)
						level[i][centerXList[a + 1] + 2] = wallID;
					if (level[i][centerXList[a + 1] - 2] == 0) 
						level[i][centerXList[a + 1] - 2] = wallID;
					level[i][centerXList[a + 1]] = hallID;
					level[i][centerXList[a + 1]-1] = hallID;
					level[i][centerXList[a + 1]+1] = hallID;
				}				
			}
			
			else if (centerYList[a] > centerYList[a + 1]){
				for (int i = centerYList[a]; i > centerYList[a + 1]; i --){
					if (level[i][centerXList[a + 1] + 2] == 0)
						level[i][centerXList[a + 1]+2] = wallID;
					if (level[i][centerXList[a + 1] - 2] == 0) 
						level[i][centerXList[a + 1]-2] = wallID;
					level[i][centerXList[a + 1]] = hallID;
					level[i][centerXList[a + 1]+1] = hallID;
					level[i][centerXList[a + 1]-1] = hallID;
				}
			}
			
			
		}
		
		return level;
		
	}
	


	
	
	/**
	 * 
	 * This method doesn't take parameters because it just generates a bunch of empty rooms
	 * You don't have to have created any rooms to use it
	 * 
	 * @return newLevel
	 */
	public int[][] createLevel(int width, int height){
		int[][] newLevel = new int[width][height];


		
		int minY = 0;
		int maxY = (int)(newLevel.length / 2) - maxRoomSize;
		
		TempRoom[] rooms = makeRooms();
		
		int min = 0;
		int max = 10;
		
		
		// upper left corners of all the rooms
		int[] originXList = new int[rooms.length];
		int[] originYList = new int[rooms.length];
		// lower right corners of all the rooms (actually one below and to the right of the corner)
		int[] oppositeXList = new int[rooms.length];
		int[] oppositeYList = new int [rooms.length];
		
		for (int i = 0; i < rooms.length; i ++){
			
			//min = i * ((int) (width-maxRoomSize) / rooms.length) + 1;
			
			//if (i > 0)
			//	min = originXList[i - 1] + rooms[i].roomArray[0].length + 1;
			
			//max = min + 3;
			
			max += maxRoomSize / 2 + 2;
			min += maxRoomSize / 2 + 2;
			
			//System.out.println("max " + max);
			//System.out.println("min " + min);
			
			if (minY == 0)
				minY = (int)(newLevel.length / 2) - maxRoomSize;
			else
				minY = 0;
			
			if (maxY == (int)(newLevel.length / 2) - maxRoomSize)
				maxY = newLevel.length - maxRoomSize;
			else
				maxY = (int)(newLevel.length / 2) - maxRoomSize;
			
			
			originXList[i] = (int)(Math.random() * (max - min + 1) ) + min;
			originYList[i] = (int)(Math.random() * (maxY - minY + 1) ) + minY;
			while (originXList[i] > (128 - maxRoomSize)){
				
				for (int x = 0; x < i; x ++){
					originXList[x] = (int) (originXList[x] * .9);
					//System.out.print(originXList[x] + " " + x);
				}
				//System.out.println();
				
			}
				
				
			oppositeXList[i] = originXList[i] + rooms[i].width;
			oppositeYList[i] = originYList[i] + rooms[i].length;
		}
		
		newLevel = makeHalls(originXList, originYList, oppositeXList, oppositeYList, newLevel);
		
		// this is the bit that actually puts the stupid rooms into the stupid level
		for (int a = 0; a < originXList.length; a ++){ // loops through the originXList (and YList I guess)
			for (int i = originYList[a]; i < oppositeYList[a]; i ++){ // rows
				for (int j = originXList[a]; j < oppositeXList[a]; j ++){ // columns
					
					if (newLevel[i][j] == hallID && rooms[a].roomArray[i - originYList[a]][j-originXList[a]] == wallID)
						newLevel[i][j] = hallID;
					else if (newLevel[i][j] == wallID && rooms[a].roomArray[i - originYList[a]][j - originXList[a]] == floorID)
						newLevel[i][j] = floorID;
					else
						newLevel[i][j] = rooms[a].roomArray[i - originYList[a]][j - originXList[a]];
					
					
				}
			}
			
		}
		
		
		// prints the giant honkin' level after it's made (testing purposes)
		for (int[] stupid: newLevel){
			System.out.println(Arrays.toString(stupid));
		}
		
		
		return newLevel;
	}
	
	public int[] getSpawnPoint(){
		int[] spawn = new int[2];
		spawn[0] = centerXList[0];
		spawn[1] = centerYList[0];
		
		return spawn;
	}
	
	/*
	public static void main(String [] args){
		
		System.out.println("hur");
		LevelGenerator l = new LevelGenerator();
		l.createLevel(128, 128);

	}
	*/
	
	
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
		return "This is not the Room you're looking for.  Unless it is, which I guess it could be, but it really isn't.";
	}
	
}
