package base;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMover extends MouseAdapter{

	public static Point mPoint;
	
	public void mouseMoved(MouseEvent mM){
		mPoint = mM.getPoint();
		
	}

}
