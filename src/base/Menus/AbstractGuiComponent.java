package base.Menus;

import java.awt.Graphics;

public abstract class AbstractGuiComponent {
	
	public AbstractGuiComponent(){
		
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	public abstract boolean isMouseInBounds();
	
}
