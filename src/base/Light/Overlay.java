package base.Light;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Area;

import base.Handler;

public class Overlay {

	private Handler handler;
	private ArcLight arcL;
	
	public Overlay(Handler handler, ArcLight arcL){
		this.handler = handler;
		this.arcL = arcL;
	}
	
	public void render(Graphics g){
		
		/*
		Graphics2D g2 = (Graphics2D) g.create();
		GameObject tempObject;
		Rectangle clipRect;
		Area out;
		for(int i = 0; i < handler.object.size(); i++){
			tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Light){
				tempObject = (LightSource) tempObject;
				clipRect = tempObject.getBounds();
				out = new Area(new Rectangle(0,0,Game.WIDTH, Game.HEIGHT));
				out.subtract(new Area(clipRect));
				g2.clip(out);
			}

		}
		Arc2D.Double clipArc = (Arc2D.Double) arcL.getShapeBounds();
		out = new Area(new Rectangle(0,0,Game.WIDTH, Game.HEIGHT));
		out.subtract(new Area(clipArc));
		g2.clip(out);
		
		/*
		Rectangle clipRect = new Rectangle(50,50,100,100);
		Area out = new Area(new Rectangle(0,0,Game.WIDTH, Game.HEIGHT));
		out.subtract(new Area(clipRect));
		g2.clip(out);
		*/
		
		/*
		g2.setColor(new Color(0,0,0, 255));
		g2.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
		
		g2.setClip(0, 0, Game.WIDTH, Game.HEIGHT);
		*/
	}
	
	public void tick(){
		
	}
}
