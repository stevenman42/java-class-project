package base.Menus;

import javax.swing.JFrame;
import base.Entities.Player;
import base.Items.Container;

public class OpenInvintory {
	
	private JFrame frame;
	
	public OpenInvintory(){
		
		frame = new JFrame();
		
		Container c = Player.container;
		
		int i = c.getSize();
		if(i == 0){
			i = 1;
		}
		
		frame.setTitle("Invintory");
		frame.setSize(250, i * 70);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}


class invintoryButton{
	
	
	
	public invintoryButton(){
		
		
		
	}
	
}
