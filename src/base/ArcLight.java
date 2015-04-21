package base;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;

public class ArcLight{
	
	protected float x,y;
	protected ID id;
	protected float radius, staticRadius, spread;
	protected float glowCount = 0;
	protected float dR = -1;
	protected Player player;
	protected Arc2D.Double arc = new Arc2D.Double();


	public ArcLight(float x, float y, ID id, float radius, float spread, Player player) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.radius = radius;
		this.staticRadius = radius;
		this.spread = spread;
		this.player = player;
	}

	public void tick() {
		
	}

	public void render(Graphics2D g2) {
		arc.setArcByCenter(player.getX()+16, player.getY()+16, radius, player.getAngle()-spread, 2*spread, Arc2D.PIE);
		GradientPaint gp = new GradientPaint(100,
											 50,
											 new Color(0,0,0,0),
											 10+radius*(float)Math.cos(Math.toRadians(player.getAngle())),
											 50-radius*(float)Math.sin(Math.toRadians(player.getAngle())),
											 new Color(0,0,0,255));
		g2.setPaint(gp);
		g2.fill(arc);
		g2.draw(arc);
	}

	public Rectangle getBounds() {
		return null;
	}

	public Shape getCircleBounds() {
		return arc;
	}

	public void render(Graphics g) {
		render((Graphics2D)g.create());
	}

}
