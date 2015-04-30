package base;

import java.awt.Point;
import java.util.Arrays;
import base.Map.LevelGenerator;

import base.Entities.Player;

public class AI {
	
	//Steven this is where all your static AI pathfinding stuff will go
	// Yay ty bb

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

	public static void main(String [] args){
		
		LevelGenerator hue = new LevelGenerator();
		
		int[][] testLevel = new int[][]
		{
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
		};
		int[][] newLevel = hue.CreateLevel();
		AI bennett = new AI();
		bennett.CalculateHeuristic(newLevel, 1, 50, 50);
		
		// sweet it works

	}

}
