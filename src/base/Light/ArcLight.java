package base.Light;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;

import base.Game;
import base.GameObject;
import base.ID;
import base.Player;

public class ArcLight extends GameObject{

	protected float radius, staticRadius, spread;
	protected float glowCount = 0;
	protected float dR = -1;
	protected Player player;
	protected static Arc2D.Double arc = new Arc2D.Double();
	protected double pangle;


	public ArcLight(float x, float y, ID id, float radius, float spread, Player player) {
		super(x,y,id);
		this.radius = radius;
		this.staticRadius = radius;
		this.spread = spread;
		this.player = player;
	
	}

	public void tick() {
		pangle = player.getAngle();
		this.x = player.getX() + 16;
		this.y = player.getY() + 16;
		arc.setArcByCenter(x, y, radius, pangle-spread, 2*spread, Arc2D.PIE);
		}

	public void render(Graphics2D g2) {
		Paint p = new RadialGradientPaint(
				new Point((int)x,(int)y),
				radius,
				new float[]{0,1f},
				new Color[]{new Color(50,50,0,50), new Color(0,0,0,255)});
		g2.setPaint(p);
		g2.setClip(arc);
		g2.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
	}

	public Rectangle getBounds() {
		return null;
	}

	public Shape getShapeBounds() {
		return arc;
	}

	public void render(Graphics g) {
		render((Graphics2D)g.create());
	}
	
	public double getStartAngle(){
		return pangle - spread;
	}
	
	public double getExtentAngle(){
		return 2*spread;
	}
	
 

}
