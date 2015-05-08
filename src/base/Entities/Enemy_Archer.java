package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import base.Physics;
import base.Map.TileID;

public class Enemy_Archer extends Enemy{

	public Enemy_Archer(float x, float y, ID id, float width, float height, int health) {
		super(x, y, id, width, height, health);
		//setDX(1);
		//setDY(2);
	}

	public void tick() {
		if(dX > 0 && Physics.clearRight(this, TileID.bedRock))
			x += dX;
		if(dX < 0 && Physics.clearLeft(this, TileID.bedRock))
			x += dX;
		if(dY > 0 && Physics.clearUp(this, TileID.bedRock))
			y += dY;
		if(dY < 0 && Physics.clearDown(this, TileID.bedRock))
			y += dY;
		if(x < Player.staticX)
			dX = 1;
		if(x > Player.staticX)
			dX = -1;
		if(y > Player.staticY)
			dY = -1;
		if(y < Player.staticY)
			dY = 1;
	}
	
	public void render(Graphics g, Graphics2D g2){
		super.render(g2);
		g2.setColor(Color.white);
		g2.fillRect((int)x+6,(int)y+6, (int)width-12, (int)height-12);
	}

}