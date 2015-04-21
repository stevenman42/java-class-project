package base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Menu {

	public Rectangle playButton = new Rectangle(Game.WIDTH/2-50, 200, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2 -50, 300, 100, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		Font font0 = new Font("arial", Font.BOLD, 100);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("Evader!", Game.WIDTH/2 - 180, Game.HEIGHT/2 -100);
		g2d.draw(playButton);
		g2d.draw(quitButton);
		Font font1 = new Font("arial", Font.BOLD, 25);
		g.setFont(font1);
		g.drawString("Play", playButton.x + 25, playButton.y + 35);
		g.drawString("Quit", quitButton.x + 25, quitButton.y + 35);
	}
}
