package base.Menus;

import java.awt.Graphics;

public class Button extends AbstractGuiComponent{
	
	private int x, y, length, height;
	private String text = "";
	
	public Button(int x, int y, int length, int height){
		super();
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
	}
	
	public void setText(String str){
		text = str;
	}
	
	public void render(Graphics g) {
		
	}
	public void tick(){
		
	}
	public boolean isMouseInBounds() {
		return false;
	}
	
	
	
}