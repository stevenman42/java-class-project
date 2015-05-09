package base.Menus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import base.Entities.Player;
import base.Items.Container;
import base.Items.ContainerHolder;

public class OpenInvintory {
	
	private JFrame frame;
	
	private InvintoryButton[] items;
	
	public OpenInvintory(){
		
		frame = new JFrame();
		
		Container c = Player.container;
		
		int i = c.getSize();
		if(i == 0){
			i = 1;
		}
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		
		frame.setTitle("Invintory");
		frame.setSize(250, i * 70);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.BOTH;
		con.gridx = 0;
		con.gridy = 0;
		
		items = new InvintoryButton[i];
		ContainerHolder[] ch = Player.container.getContents();
		
		for(int j = 0; j < ch.length; j++){
			//items[i] = new InvintoryButton(ch[i]);
		}
		
		
		
	}
	
}


class InvintoryButton{
	
	private ContainerHolder conh;
	private JButton button;
	
	public InvintoryButton(ContainerHolder ch){
		
		conh = ch;
		
		button = new JButton(new ImageIcon(conh.getItem().getImage()));
		button.setToolTipText(conh.getItem().getName());
		
	}
	
	public JButton getJButton(){
		return button;
	}
	
}
