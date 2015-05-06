package base.Menus;

import java.awt.Graphics2D;
import java.awt.Image;

public class ButtonImage extends Button{
	
	private Image image;
	
	public ButtonImage(int x, int y, int length, int height, Image img) {
		super(x, y, length, height);
		image = img;
	}
	
	public void render(Graphics2D g2d) {
		
		if(image != null){
			g2d.drawImage(image, getX(), getY(), getLength(), getHeight(), null);
		}else{
			super.renderBackground(g2d);
			System.err.println("couldent render an image");
		}
		super.renderBorder(g2d);
		super.renderText(g2d);

	}
	
}
