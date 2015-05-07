package base.Visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;

import base.Game;
import base.Handler;
import base.Entities.GameObject;
import base.Entities.ID;
import base.Entities.Player;

public class ArcLight extends GameObject{

	protected float radius, staticRadius, spread;
	protected float glowCount = 0;
	protected float dR = -1;
	protected Player player;
	public static Arc2D.Double arc = new Arc2D.Double();
	protected double pangle;
	protected Handler handler;


	public ArcLight(float x, float y, ID id, float radius, float spread, Player player, Handler handler) {
		super(x,y,id);
		this.radius = radius;
		this.staticRadius = radius;
		this.spread = spread;
		this.player = player;
		this.handler = handler;
	
	}

	public void tick() {
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ID.Player){
				x = handler.object.get(i).getX() + 16;
				y = handler.object.get(i).getY() + 16;
			}
		}
		pangle = Player.getAngle();
		arc.setArcByCenter(x, y, radius, pangle-spread, 2*spread, Arc2D.PIE);
		}

	public void render(Graphics g, Graphics2D g2) {
		Paint p = new RadialGradientPaint(
				new Point((int)x,(int)y),
				radius,
				new float[]{0,1f},
				new Color[]{new Color(50,50,0,50), new Color(0,0,0,255)});
		g2.setClip(arc);
		g2.setPaint(p);
		g2.fillRect(0,0,Game.MAPWIDTH,Game.MAPHEIGHT);
		g2.setPaint(null);
	}

	public Rectangle getBounds() {
		return null;
	}

	public Shape getShapeBounds() {
		return arc;
	}
	
	public double getStartAngle(){
		return pangle - spread;
	}
	
	public double getExtentAngle(){
		return 2*spread;
	}
	
 

}
