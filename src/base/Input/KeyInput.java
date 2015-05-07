package base.Input;

import game.saveData.SaveDataHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import base.Game;
import base.Handler;
import base.StaticGame;
import base.Entities.GameObject;
import base.Entities.ID;
import base.Menus.HUD;

public class KeyInput extends KeyAdapter{

	private boolean[] keyDown = new boolean[4];
	private Handler handler;

	private static int keyMovementForward;
	private static int keyMovementLeft;
	private static int keyMovementBackward;
	private static int keyMovementRight;

	public KeyInput(Handler handler){
		this.handler = handler;
		for(int i = 0; i < keyDown.length; i++){
			keyDown[i] = false;
		}
		SaveDataHandler sdh = StaticGame.getGame().getSaveDataHandler();
		keyMovementForward = Integer.parseInt(sdh.getDataFromKey("KEY_MOVEMENT_FORWARD").getData());
		//System.out.println("KMF = " + keyMovementForward);
		keyMovementLeft = Integer.parseInt(sdh.getDataFromKey("KEY_MOVEMENT_LEFT").getData());
		keyMovementBackward = Integer.parseInt(sdh.getDataFromKey("KEY_MOVEMENT_BACKWARD").getData());
		keyMovementRight = Integer.parseInt(sdh.getDataFromKey("KEY_MOVEMENT_RIGHT").getData());
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		//System.out.println("Key Pressed: Code [" + key + "]");

		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.Player){
				if(key == keyMovementForward){
					tempObject.setDY(-3);
					keyDown[0] = true;
				}

				if(key == keyMovementLeft){
					tempObject.setDX(-3);
					keyDown[1] = true;
				}

				if(key == keyMovementBackward){
					tempObject.setDY(3);
					keyDown[2] = true;

				}
				if(key == keyMovementRight){
					tempObject.setDX(3);
					keyDown[3] = true;
				}
				if(key == KeyEvent.VK_E){
					HUD.openInvintory();
				}
			}

			/*
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W){
					tempObject.setDY(-3);
					keyDown[0] = true;
				}
			}
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_A){
					tempObject.setDX(-3);
					keyDown[1] = true;
				}
			}
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_S){
					tempObject.setDY(3);
					keyDown[2] = true;
				}
			}
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_D){
					tempObject.setDX(3);
					keyDown[3] = true;
				}
			}
			 */

		}
		if(key == KeyEvent.VK_ESCAPE){
			Game.State = Game.STATE.MENU;
		}

	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.Player){
				//key events for player one

				/*
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_A) keyDown[1] = false;
				if(key == KeyEvent.VK_S) keyDown[2] = false;
				if(key == KeyEvent.VK_D) keyDown[3] = false;
				 */

				if(key == keyMovementForward) keyDown[0] = false;
				if(key == keyMovementLeft) keyDown[1] = false;
				if(key == keyMovementBackward) keyDown[2] = false;
				if(key == keyMovementRight) keyDown[3] = false;


				//stop movement
				if(!keyDown[0] && !keyDown[2])
					tempObject.setDY(0);
				if(!keyDown[1] &&!keyDown[3])
					tempObject.setDX(0);

			}

		}
	}

}
