package base.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Button extends AbstractGuiComponent{

	private int x, y, length, height;
	private String text = "";
	private Rectangle rect;
	
	private Font font;
	private Color textColor, borderColor, backgroundColor;

	public Button(int x, int y, int length, int height){
		super();
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
		rect = new Rectangle(x, y, length, height);
		font = new Font("arial", Font.BOLD, 25);
		textColor = Color.BLACK;
		borderColor = Color.BLACK;
		backgroundColor = Color.WHITE;
	}
	
	public void setText(String str){
		text = str;
	}

	public void render(Graphics2D g2d) {
		
		if(backgroundColor != null){
			renderBackground(g2d);
		}
		
		g2d.draw(rect);
		if(!text.equals("")){
			renderText(g2d);
		}
	}
	
	//Font font1 = new Font("arial", Font.BOLD, 25);
	
	protected void renderText(Graphics2D g2d){
		Font prev = null;
		if(font != null){
			prev = g2d.getFont();
			g2d.setFont(font);
		}

		FontMetrics fm = g2d.getFontMetrics();
		int cx = (x + (length / 2)) - (fm.stringWidth(text) / 2);
		int cy = (y + (height / 2)) + (fm.getHeight() / 3);
		
		g2d.drawString(text, cx, cy);
		
		if(prev != null){
			g2d.setFont(prev);
		}
		
	}
	
	protected void renderBackground(Graphics2D g2d){
		Color prev = g2d.getColor();
		g2d.setColor(backgroundColor);
		g2d.fill(rect);
		g2d.setColor(prev);
	}
	
	protected void renderBorder(Graphics2D g2d){
		g2d.drawRect(x, y, length, height);
	}
	
	public void tick(){

	}

	public boolean isMouseInBounds(int mx, int my){
		if(((mx > x) && (mx < x + length)) && ((my > y) && (my < y + height))){
			return true;
		}
		return false;
	}	
	
	protected int getX(){
		return x;
	}
	
	protected int getY(){
		return y;
	}
	
	protected int getLength(){
		return length;
	}
	
	protected int getHeight(){
		return height;
	}
	
	public void setFont(Font f){
		font = f;
	}
	
	public void setTextColor(Color c){
		textColor = c;
	}
	
	public void setBorderColor(Color c){
		borderColor = c;
	}
	
	public void setBackgroundColor(Color c){
		backgroundColor = c;
	}
	
}