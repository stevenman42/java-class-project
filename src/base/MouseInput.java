package base;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput implements MouseListener{
	
	public static Point mPoint;


	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if(Game.State == Game.STATE.MENU){
			if(mx >= Game.WIDTH/2-50 && mx <= Game.WIDTH/2 -50 + 100){
				if(my >= 200 && my <= 250){
					//Pressed play/resume
					Game.State = Game.STATE.GAME;
				}
			}

			if(mx >= Game.WIDTH/2-50 && mx <= Game.WIDTH/2 -50 + 100){
				if(my >= 300 && my <= 350){
					//Pressed quit
					System.exit(1);
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

}
