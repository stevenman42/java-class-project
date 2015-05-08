package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import base.Physics;
import base.Map.TileID;
import base.Pathfinding.Scent;

public class Enemy_Knight extends Enemy{

	public Enemy_Knight(float x, float y, ID id, float width, float height, int health) {
		super(x, y, id, width, height, health);
		setDX(1);
		setDY(2);
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
		if(Scent.isScent(this)){
			int dir = Scent.findScent(this);
			if(dir == 0){
				dX = 1;
				dY = 0;
			}else if(dir == 1){
				dX = 0;
				dY = -1;
			}else if(dir == 2){
				dX = -1;
				dY = 0;
			}else if(dir == 3){
				dX = 0;
				dY = 1;
			}
		}
		else{
			if(lastX == x)
				dX = -dX;
			if(lastY == y)
				dY = -dY;
		}
	}
	
	public void render(Graphics g, Graphics2D g2){
		super.render(g2);
		g2.setColor(Color.white);
		g2.fillRect((int)x+6,(int)y+6, (int)width-12, (int)height-12);
	}

}
