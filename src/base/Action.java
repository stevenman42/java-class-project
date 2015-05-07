package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;

import base.Entities.Player;
import base.Items.Base_Sword;

public class Action{
	
	private Graphics g;
	private Graphics2D g2;
	private Arc2D.Double arc = new Arc2D.Double();
	
	public Action(Graphics g, Graphics2D g2){
		this.g = g;
		this.g2 = g2;
	}
	
	public void SwingSword(Base_Sword sword){
		/*Shape a = g2.getClip();
		double pangle = Player.getAngle();
		arc.setArcByCenter(Player.staticX, Player.staticY, 50, pangle-25, 50, Arc2D.PIE);
		g2.setClip(arc);
		g2.setColor(Color.white);
		*/
		double pangle = Player.getAngle();
		arc.setArcByCenter(Player.staticX, Player.staticY, 50, pangle-25, 50, Arc2D.PIE);
		g2.fill(arc);
		
	}

}
