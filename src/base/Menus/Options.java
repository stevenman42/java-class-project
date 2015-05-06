package base.Menus;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Options {
	
	private JFrame frame;
	
	private final JPanel MainMenu = getMainMenu();
	private final JPanel KeyBindMenu = getKeyBindMenu();
	
	public Options(){
		frame = new JFrame();
		frame.setTitle("Evader! options menu");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		frame.add(MainMenu);
		
	}
	
	public JPanel getMainMenu(){
		JPanel ret = new JPanel();		
		ret.setLayout(new GridLayout(1, 1));
		
		JButton keyBinds = new JButton("KeyBinds");
		keyBinds.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.remove(MainMenu);
				frame.add(KeyBindMenu);
			}
		});
		
		ret.add(keyBinds);		
		return ret;
	}
	
	public JPanel getKeyBindMenu(){
		JPanel ret = new JPanel();
		
		return ret;
	}
	
	public void open(){
		frame.setVisible(true);
	}
	
}
