package base.Menus;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Button extends AbstractGuiComponent{
	
	private int x, y, length, height;
	private String text = "";
	private Rectangle rect;
	
	public Button(int x, int y, int length, int height){
		super();
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
		rect = new Rectangle(x, y, length, height);
	}
	
	public void setText(String str){
		text = str;
	}
	
	public void render(Graphics2D g2d) {
		
		g2d.draw(rect);
		if(!text.equals("")){
			Font font1 = new Font("arial", Font.BOLD, 25);
			g2d.setFont(font1);
			g2d.drawString(text, x + (length / 5), y + (height / 2));
		}
		
	}
	
	public void tick(){
		
	}
	
	public boolean isMouseInBounds() {
		return false;
	}
	
	
	
}