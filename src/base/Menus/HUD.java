package base.Menus;

import java.awt.Graphics2D;
import java.util.ArrayList;

import base.Game;
import base.Entities.Player;
import base.Items.Container;

public class HUD {
	
	private Game game;
	
	private boolean showDebugData = true;
	
	private Container toRender;
	private boolean renderContainers;
	private boolean renderInvintory;
	
	public HUD(Game g){
		game = g;
		toRender = Player.container;
		renderContainers = false;
		renderInvintory = false;
	}
	
	public void render(Graphics2D g2d){
		
		if(showDebugData){
			int fps = game.getFPS();
			g2d.drawString("FPS:" + fps, Game.WIDTH-((""+fps).length()*6+37), Game.HEIGHT-35);
		}
		
		if(renderContainers){
			renderContainers(g2d);
		}else if(renderInvintory){
			renderInv(g2d);
		}
		
	}
	
	public void renderInvintory(){
		renderInvintory = true;
	}
	
	public void closeInvintory(){
		renderInvintory = false;
	}
	
	public void renderContainer(Container c){
		renderContainers = true;
		toRender = c;
	}
	
	public void stopRenderingContainer(){
		renderContainers = false;
	}
	
	private void renderContainers(Graphics2D g2d){
		
	}
	
	private void renderInv(Graphics2D g2d){
		
		g2d.drawImage(null, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		
	}
	
}
