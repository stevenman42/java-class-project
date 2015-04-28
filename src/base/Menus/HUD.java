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
			int fps = game.getFPS();
			g2d.drawString("FPS:" + fps, Game.WIDTH-((""+fps).length()*6+37), Game.HEIGHT-35);
		}
		
	}
	
}
