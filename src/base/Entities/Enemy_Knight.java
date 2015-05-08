package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		if(!following){
			firstFollow = true;
			if(!isRandom){
				dX = 1;
				dY = 1;
				isRandom = true;
			}else if(isRandom){
				if(lastX == x){
					dX = -dX;
				}
				if(lastY == y){
					dY = -dY;
				}
			}
		}else if(following){
			isRandom = false;
		//code for scent movements start here
			int dir = Scent.findScent(this);

			if(firstFollow){
				firstFollow = false;
				switch(dir){
				case 0:
					dX = 2;
					dY = 0;
					break;
				case 1:
					dX = 0;
					dY = -2;
					break;
				case 2:
					dX = -2;
					dY = 0;
					break;
				case 3:
					dX = 0;
					dY = 2;
					break;
				default:
					dX = 0;
					dY = 0;
					break;
				}
			}
			if(lastDir == 1 || lastDir == 3){
				if(dir == 0){
					dX = 2;
					dY = 0;
					lastDir = dir;
				}
				if(dir == 2){
					dX = -2;
					dY = 0;
					lastDir = dir;
				}
			}
			else if(lastDir == 0 || lastDir == 2){
				if(dir == 1){
					dX = 0;
					dY = -2;
					lastDir = dir;
				}
				if(dir == 3){
					dX = 0;
					dY = 2;
					lastDir = dir;
				}
			}
		//code for scent movement ends here
		}
		
		
		
	}
	
	public void render(Graphics g, Graphics2D g2){
		super.render(g2);
		g2.setColor(Color.white);
		g2.fillRect((int)x+6,(int)y+6, (int)width-12, (int)height-12);
	}

}
