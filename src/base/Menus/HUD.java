package base.Menus;

import java.awt.Graphics2D;

import base.Game;

public class HUD {
	
	private Game game;
	
	private boolean showDebugData = true;
	
	public HUD(Game g){
		game = g;
	}
	
	public void render(Graphics2D g2d){
		
		if(showDebugData){
			g2d.drawString("FPS:" + game.getFPS(), 1, 10);
		}
		
	}
	
}
