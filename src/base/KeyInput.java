package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private boolean[] keyDown = new boolean[6];
	
	public KeyInput(){
		for(int i = 0; i < keyDown.length; i++){
			keyDown[i] = false;
		}
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}

}
