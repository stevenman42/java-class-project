package base.Menus;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class AbstractGuiComponent{

	private ArrayList<ActionListener> actionListeners;

	public AbstractGuiComponent(){
		actionListeners = new ArrayList<ActionListener>();
	}

	/**
	 * adds an ActionListener to the GuiComponent
	 * @param al
	 */
	public void addActionListener(ActionListener al){
		actionListeners.add(al);
	}

	/**
	 * removes the ActionListener from the GuiComponent
	 * @param al
	 */
	public void removeActionListener(ActionListener al){
		actionListeners.remove(al);
	}

	/**
	 * calls the actionPerformed methods
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){
		for(ActionListener  al : actionListeners){
			al.actionPerformed(e);
		}
	}

	public abstract void render(Graphics2D g2d);
	public abstract void tick();
	public abstract boolean isMouseInBounds(int mx, int my);
	
}
