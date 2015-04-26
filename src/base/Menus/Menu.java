package base.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import base.Game;
import base.audio.Audio;


public class Menu {

	private ArrayList<AbstractGuiComponent> guiComponents = new ArrayList<AbstractGuiComponent>();

	public static Rectangle playButton = new Rectangle(Game.WIDTH/2-50, 200, 100, 50);
	public static Rectangle quitButton = new Rectangle(Game.WIDTH/2 -50, 300, 100, 50);
	
	private Image image, image2, image3;
	
	private boolean audioPlaying = false;	
	private Audio audio;

	public void inil(){
		
		image = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp.gif");
		image2 = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp2.gif");
		image3 = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp3.gif");
		
		//Button play = new ButtonImage(Game.WIDTH/2-50, 200, 100, 50, image2);
		Button play = new ButtonImage(Game.WIDTH/2-200, 200, 400, 50, image2);
		play.setText("PLAY");
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Game.State = Game.STATE.GAME;
				closeMenu();
			}		
		});
		
		//Button quit = new Button(Game.WIDTH/2 -50, 300, 100, 50);
		Button quit = new ButtonImage(Game.WIDTH/2-200, 300, 400, 50, image3);
		quit.setText("QUIT");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		
		guiComponents.add(play);
		guiComponents.add(quit);
		
	}

	public void openMenu(){
		audio = new Audio("RES/Audio/Background1.wav");
		audio.loop();
		audioPlaying = true;

	}

	public void closeMenu(){
		audio.stop();
	}

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		if(image != null){
			g2d.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		}else{
			System.err.println("coulden't render background image!");
		}
		
		Font font0 = new Font("arial", Font.BOLD, 100);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("Evader!", Game.WIDTH/2 - 180, Game.HEIGHT/2 -100);

		for(AbstractGuiComponent agc : guiComponents){
			agc.render(g2d);
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
					int mx = e.getX();
					int my = e.getY();
					
					for(AbstractGuiComponent agc : guiComponents){
						if(agc.isMouseInBounds(mx, my)){
							agc.actionPerformed(null);
						}
					}
						
				}
			}
			public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		};
		return ml;
	}
	
}
