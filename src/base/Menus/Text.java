package base.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Text extends AbstractGuiComponent{
	
	private String text;
	private int x, y;
	private Font font;
	private Color color;
	
	public Text(String text, int x, int y){
		this.x = x;
		this.y = y;
		font = new Font("arial", Font.BOLD, 25);
		color = Color.BLACK;
	}
	
	public void render(Graphics2D g2d){
		
		FontMetrics fm = g2d.getFontMetrics();
		int cx = x - (fm.stringWidth(text) / 2);
		int cy = y + (fm.getHeight() / 3);
		
		g2d.drawString(text, cx, cy);
		
	}

	public void tick() {
		
	}

	public boolean isMouseInBounds(int mx, int my) {
		return false;
	}
	
	public String getText(){
		return text;
	}
	
}
