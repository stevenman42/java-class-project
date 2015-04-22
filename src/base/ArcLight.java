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
	protected double pangle, bangle, eangle;


	public ArcLight(float x, float y, ID id, float radius, float spread, Player player) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.radius = radius;
		this.staticRadius = radius;
		this.spread = spread;
		this.player = player;
		arc.setArcByCenter(x, y, radius, player.getAngle()-spread/2, player.getAngle()+spread/2, Arc2D.PIE);
	}

	public void tick() {
		pangle = player.getAngle();
		bangle = pangle - spread;
		eangle = pangle + spread;
		System.out.println("Angle: " + (int)pangle + "  B: " + (int)bangle + " E: " + (int)eangle);
		arc.setArcByCenter(player.getX()+16, player.getY()+16, radius, bangle, eangle, Arc2D.CHORD);
		System.out.println(arc);

	}

	public void render(Graphics2D g2) {
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
