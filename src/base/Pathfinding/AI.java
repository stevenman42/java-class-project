package base.Pathfinding;

import java.awt.Point;
import java.util.Arrays;

import base.Entities.Player;
import base.Map.LevelGenerator;

public class AI {
	
	//Steven this is where all your static AI pathfinding stuff will go
	// Yay ty bb
	
/*

I have had some ideas about pathfinding
I feel like this pathfinding will be a major drag on the CPU
since we have no clue how to use gpu in Java2d basic programming @jepling thanks
Ive been thinking, what if we used Rays or Scent for pathfinding?
Or both?
Ray pathfinding is just a FOV/LOS pathfinding thing where we cast rays from the enemy to the player, and if
that ray intersects a nonwalkable tile, the enemy doesnt move(or we can have it move randomly in small amounts)

That gives us start for pathfinding, but what if the player hides behind a wall after seeing a enemy?
The enemy would stop in its tracks.  That could be good and bad.

So what if it is a scent based pathfinding???

The ray will start the pathfinding process and then each tile can hold a scent
the scent is stronger closer to the player
so any tiles the player walks on, the scent goes up and then follows a counter back down to 0
enemies follow the path of most scent if they find one or start by a ray


*/
	public int[][] CalculateHeuristic(int[][] level, int cost_of_movement, int target_node_X, int target_node_Y){


		int[][] h_vals = new int[level.length][level[0].length];

		for (int i = 0; i < level.length; i ++){ // y
			for (int j = 0; j < level[0].length; j ++){ // x
				int dx = Math.abs(j - target_node_X);
				int dy = Math.abs(i - target_node_Y);
				h_vals[i][j] = cost_of_movement * (dx + dy);
			}
		}

		
		
		for (int[] i: h_vals){
			System.out.println(Arrays.toString(i));
		}
		
		return h_vals;

	}
	
	public static Point findPlayer(){
		return new Point((int)Player.staticX, (int)Player.staticY);
	}


}
