package base.Input;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMover extends MouseAdapter{

	public static float mX, mY;
	
	public void mouseMoved(MouseEvent mM){
		mX = mM.getX();
		mY = mM.getY();
		
	}

}
