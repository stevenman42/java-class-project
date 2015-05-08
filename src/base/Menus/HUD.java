package base.Menus;

import java.awt.Graphics2D;
import java.util.ArrayList;

import base.Game;
import base.Items.Container;

public class HUD {
	
	private Game game;
	
	private boolean showDebugData = true;
	
	private ArrayList<Container> containers;
	private boolean renderContainers;
	
	public HUD(Game g){
		game = g;
		containers = new ArrayList<Container>();
		renderContainers = false;
	}
	
	public void render(Graphics2D g2d){
		
		if(showDebugData){
			int fps = game.getFPS();
			g2d.drawString("FPS:" + fps, Game.WIDTH-((""+fps).length()*6+37), Game.HEIGHT-35);
		}
		
		if(renderContainers){
			renderContainers();
		}
		
	}
	
	public void addContainerToRender(Container c){
		renderContainers = true;
		containers.add(c);
	}
	
	public void stopRenderingContainers(){
		renderContainers = false;
		containers.clear();
	}
	
	public void renderContainers(){
		
		
		
	}
	
}
