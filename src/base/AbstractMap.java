package base;

import java.awt.Graphics;

public abstract class AbstractMap {
	
	protected State state;
	protected Handler handler;
	
	public AbstractMap(State state, Handler handler){
		this.handler = handler;
		this.state = state;		
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();

	public State getState(){
		return state;
	}
	
}
