package base.Entities;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy_Knight extends Enemy{

	public Enemy_Knight(float x, float y, ID id, float width, float height) {
		super(x, y, id, width, height);
	}

	public void tick() {
		float lastX = x;
		float lastY = y;
		x += dX;
		y += dY;
		if(lastX == x)
			dX = -dX;
		if(lastY == y)
			dY = -dY;
	}
	
	public void render(Graphics g){
		super.render(g);
		g.setColor(Color.white);
		g.fillRect((int)x+6,(int)y+6, (int)width-12, (int)height-12);
	}

}
