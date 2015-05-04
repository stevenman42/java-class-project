package base.Menus;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class MenuItem {
	
	private ArrayList<AbstractGuiComponent> guiComponents;
	
	public MenuItem(){
		guiComponents = new ArrayList<AbstractGuiComponent>();
	}
	
	public void addAbstractGuiComponent(AbstractGuiComponent agc){
		guiComponents.add(agc);
	}
	
	public void removeAbstractGuiComponent(AbstractGuiComponent agc){
		guiComponents.remove(agc);
	}
	
	public ArrayList<AbstractGuiComponent> getGuiComponents(){
		return guiComponents;
	}
	
	public void render(Graphics2D g2d){
		for(AbstractGuiComponent agc : guiComponents){
			agc.render(g2d);
		}
	}
	
	public void tick(){
		for(AbstractGuiComponent agc : guiComponents){
			agc.tick();
		}
	}
	
}
