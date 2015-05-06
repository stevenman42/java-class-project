package base.Menus;

import javax.swing.JFrame;

public class Options {
	
	private JFrame frame;
	
	public Options(){
		frame = new JFrame();
		frame.setTitle("Evader! options menu");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void open(){
		frame.setVisible(true);
	}
	
}
