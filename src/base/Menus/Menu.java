package base.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import base.Game;
import base.audio.Audio;


public class Menu {

	private ArrayList<AbstractGuiComponent> guiComponents = new ArrayList<AbstractGuiComponent>();
	
	public static Rectangle playButton = new Rectangle(Game.WIDTH/2-50, 200, 100, 50);
	public static Rectangle quitButton = new Rectangle(Game.WIDTH/2 -50, 300, 100, 50);

	private boolean audioPlaying = false;	
	private Audio audio;
	
	public void inil(){
		
		Button play = new Button(Game.WIDTH/2-50, 200, 100, 50);
		play.setText("123");
		
		Button quit = new Button(Game.WIDTH/2 -50, 300, 100, 50);
		quit.setText("QUIT");
		
		guiComponents.add(play);
		guiComponents.add(quit);
		
	}
	
	public void openMenu(){
		audio = new Audio("RES/Audio/Background1.wav");
		audio.play();
		audioPlaying = true;
		
	}
	
	public void closeMenu(){
		audio.stop();
	}
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
				
		Font font0 = new Font("arial", Font.BOLD, 100);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("Evader!", Game.WIDTH/2 - 180, Game.HEIGHT/2 -100);
		
		for(AbstractGuiComponent agc : guiComponents){
			agc.render(g2d);
		}
		
		/*
		Font font0 = new Font("arial", Font.BOLD, 100);
		g.setFont(font0);
		g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
		g.drawString("Evader!", Game.WIDTH/2 - 180, Game.HEIGHT/2 -100);
		g2d.draw(playButton);
		g2d.draw(quitButton);
		Font font1 = new Font("arial", Font.BOLD, 25);
		g.setFont(font1);
		g.drawString("Play", playButton.x + 25, playButton.y + 35);
		g.drawString("Quit", quitButton.x + 25, quitButton.y + 35);
		*/
		
		
		
		if(!audioPlaying){
			audio = new Audio("RES/Audio/Background1.wav");
			audio.play();
			audioPlaying = true;
		}
		
		
	}
	
	public void tick(){
		
		for(AbstractGuiComponent agc : guiComponents){
			agc.tick();
		}
		
	}
	
	public MouseListener getMenuMouseListener(){
		MouseListener ml = new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){
				if(Game.State == Game.STATE.MENU){
					
				}
			}
			public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		};
		return ml;
	}
	
}
