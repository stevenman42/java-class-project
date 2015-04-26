package base.Menus;

import java.awt.Graphics2D;

public abstract class AbstractGuiComponent {
	
	public AbstractGuiComponent(){
		
	}
	
	public abstract void render(Graphics2D g2d);
	public abstract void tick();
	public abstract boolean isMouseInBounds();
	
}
