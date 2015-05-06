package base.Menus;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import base.Game;
import base.audio.Audio;


public class Menu {

	//private ArrayList<AbstractGuiComponent> guiComponents = new ArrayList<AbstractGuiComponent>();

	private boolean audioPlaying = false;	
	private Audio audio;

	private boolean neo = false;

	private MenuItem current;

	private MenuItem main;

	public void inil(){
		
		main = new MenuItem();
		
		Image image, image2, image3, image4;
		//Font buttonFont = new Font("arial", Font.BOLD, 25);

		if(neo){
			image = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp.gif");
			image2 = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp2.gif");
			image3 = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp3.gif");
			image4 = Toolkit.getDefaultToolkit().createImage("RES/Textures/MenuTemp4.jpg");
		}else{
			image = Toolkit.getDefaultToolkit().createImage("RES/Textures/.gif");
			image2 = Toolkit.getDefaultToolkit().createImage("RES/Textures/.gif");
			image3 = Toolkit.getDefaultToolkit().createImage("RES/Textures/.gif");
			image4 = Toolkit.getDefaultToolkit().createImage("RES/Textures/.jpg");
		}

		//Button play = new ButtonImage(Game.WIDTH/2-50, 200, 100, 50, image2);
		Button play = new ButtonImage(Game.WIDTH/2-200, 200, 400, 50, image2);
		play.setText("PLAY");
		//play.setFont(buttonFont);
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Game.State = Game.STATE.GAME;
				closeMenu();
			}		
		});

		//Button quit = new Button(Game.WIDTH/2 -50, 300, 100, 50);
		Button quit = new ButtonImage(Game.WIDTH/2-200, 300, 400, 50, image3);
		quit.setText("QUIT");
		//play.setFont(buttonFont);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		
		Button options = new ButtonImage(Game.WIDTH - 35, 3, 25, 25, image4);
		options.setText("");
		options.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}		
		});
		
		Text title = new Text("Evader!", Game.WIDTH/2, Game.HEIGHT/2 - Game.HEIGHT/4);
		title.setFont(new Font("arial", Font.BOLD, 75));
		
		//guiComponents.add(play);
		//guiComponents.add(quit);
		//guiComponents.add(options);
		
		main.addAbstractGuiComponent(play);
		main.addAbstractGuiComponent(quit);
		main.addAbstractGuiComponent(options);
		main.addAbstractGuiComponent(title);
		
		current = main;

	}
	
	public void openMenu(){
		audio = new Audio("RES/Audio/Background1.wav");
		audio.loop();
		audioPlaying = true;

	}

	public void closeMenu(){
		audio.stop();
	}

	/*
		if(image != null){
			g2d.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		}else{
			System.err.println("Could not render background image!");
		}

		Font font0 = new Font("arial", Font.BOLD, 100);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("Evader!", Game.WIDTH/2 - 180, Game.HEIGHT/2 -100);

		for(AbstractGuiComponent agc : guiComponents){
			agc.render(g2d);
		}
	 */

	public void render(Graphics2D g2d){
		if(main != null)	
			main.render(g2d);
	}

	public void tick(){
		current.tick();
	}

	public MouseListener getMenuMouseListener(){
		MouseListener ml = new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){
				if(Game.State == Game.STATE.MENU){
					int mx = e.getX();
					int my = e.getY();

					for(AbstractGuiComponent agc : current.getGuiComponents()){
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
