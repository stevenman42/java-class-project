package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class KeyInput extends KeyAdapter{
	
	private boolean[] keyDown = new boolean[4];
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
		for(int i = 0; i < keyDown.length; i++){
			keyDown[i] = false;
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_UP){
					tempObject.setDY(-5);
					keyDown[0] = true;
				}
			}
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_LEFT){
					tempObject.setDX(-5);
					keyDown[1] = true;
				}
			}
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_DOWN){
					tempObject.setDY(5);
					keyDown[2] = true;
				}
			}
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_RIGHT){
					tempObject.setDX(5);
					keyDown[3] = true;
				}
			}
			
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
	
			if(tempObject.getId() == ID.Player){
				//key events for player one
				
				if(key == KeyEvent.VK_UP) keyDown[0] = false;
				if(key == KeyEvent.VK_DOWN) keyDown[2] = false;
				if(key == KeyEvent.VK_LEFT) keyDown[1] = false;
				if(key == KeyEvent.VK_RIGHT) keyDown[3] = false;

				
				//stop movement
				if(!keyDown[0] && !keyDown[1])
					tempObject.setDY(0);
				if(!keyDown[2] &&!keyDown[3])
					tempObject.setDX(0);
				
			}
			
		}
	}

}
