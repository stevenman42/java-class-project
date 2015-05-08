package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import base.Physics;
import base.Map.TileID;
import base.Pathfinding.Scent;

public class Enemy_Knight extends Enemy{

	private boolean following, firstFollow = true;
	private boolean isRandom = true;
	private int lastDir = -1;
	
	public Enemy_Knight(float x, float y, ID id, float width, float height, int health) {
		super(x, y, id, width, height, health);
		setDX(1);
		setDY(-1);
	}

	public void tick() {
		float lastX = x;
		float lastY = y;
		if(dX > 0 && Physics.clearRight(this, TileID.bedRock))
			x += dX;
		if(dX < 0 && Physics.clearLeft(this, TileID.bedRock))
			x += dX;
		if(dY > 0 && Physics.clearDown(this, TileID.bedRock))
			y += dY;
		if(dY < 0 && Physics.clearUp(this, TileID.bedRock))
			y += dY;
		
		following = Scent.isScent(this);
		if(following){
			Point p = getNearestPoint();
			if(dormant){
				int dir = Scent.findScent(this);
				switch(dir){
				case 0:
					dX = 2;
					dY = 0;
				case 1:
					dX = 0;
					dY = -2;
				case 2:
					dX = -2;
					dY = 0;
				case 3:
					dX = 0;
					dY = 2;
				}
				dormant = false;
			} else {
				
				int dir = Scent.findScent(this);
				if(dX != 0){
					if(dir == 1){
						dX = 0;
						dY = -2;
					}
					else if(dir == 3){
						dX = 0;
						dY = 2;
					}
				}
				else if(dY != 0){
					if(dir == 0){
						dY = 0;
						dX = 2;
					}
					else if(dir == 2){
						dY = 0;
						dX = -2;
					}
				}
				
				
			}
		} else {
			if(lastX == x)
				dX = -dX;
			if(lastY == y){
				dY = -dY;
			}
		}

		
	}
	
	public void render(Graphics g, Graphics2D g2){
		super.render(g2);
		g2.setColor(Color.white);
		g2.fillRect((int)x+6,(int)y+6, (int)width-12, (int)height-12);
	}

}
