package base.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import base.Physics;
import base.Map.TileID;
import base.Pathfinding.Ray;
import base.Pathfinding.Scent;

public class Enemy_Knight extends Enemy{

	private boolean following, firstFollow = true;
	private boolean isRandom = true;
	private int lastDir = -1;
	protected float PX,PY;
	protected boolean LOC = false;
	

	public Enemy_Knight(float x, float y, ID id, float width, float height, int health) {
		super(x, y, id, width, height, health);
		setDX(0);
		setDY(0);
	}

	public void tick() {
		super.tick();
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

		if(Ray.castRay(this)){
			LOC = true;
			PX = Player.staticX;
			PY = Player.staticY;
			System.out.println(LOC);
			if(x > PX)
				dX = -speed;
			else if (x < PX)
				dX = speed;
			else dX = 0;

			if(y > PY)
				dY = -speed;
			else if(y < PY)
				dY = speed;
			else dY = 0;
		} else if(LOC){
			if((PX/32 == x/32 && PY/32 == y/32) || (lastX == x && lastY == y)){
				LOC = false;
			}
			if(x > PX)
				dX = -speed;
			else if (x < PX)
				dX = speed;
			else dX = 0;

			if(y > PY)
				dY = -speed;
			else if(y < PY)
				dY = speed;
			else dY = 0;

		} else if (Scent.isScent(this)){
			Point p = getNearestPoint();

			Point nextPoint = Scent.findScent(this);
			if(nextPoint.x > p.x){
				dX = 1;
			} else if(nextPoint.x < p.x){
				dX = -1;
			} else if(nextPoint.x == p.x){
				dX = 0;
			}
			if(nextPoint.y > p.y){
				dY = 1;
			} else if(nextPoint.y < p.y){
				dY = -1;
			} else if(nextPoint.y == p.y){
				dY = 0;
			}
		}
		else {
			dX = speed;
			dY = speed;
		}


	}

	public void render(Graphics g, Graphics2D g2){
		super.render(g2);
		g2.setColor(Color.white);
		g2.fillRect((int)x+6,(int)y+6, (int)width-12, (int)height-12);
	}

}
