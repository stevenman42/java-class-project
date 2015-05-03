package base;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LoadMenu extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 3282828537337888361L;
	public LoadMenu(){
		int w = 720, h = 405;
		final JFrame j = new JFrame("Loader");
		JButton newGame = new JButton("Create New Game");
		JButton load1 = new JButton("Load Game 1");
		JButton load2 = new JButton("Load Game 2");
		JButton load3 = new JButton("Load Game 3");
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				j.dispose();
				new Game();
				
			}
		});
		load1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.out.println("1");
			}
		});
		load2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.out.println("2");
			}
		});
		load3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.out.println("3");
			}
		});
		
		j.setPreferredSize(new Dimension(w, h));
		j.setMaximumSize(new Dimension(w,h));
		j.setMinimumSize(new Dimension(w,h));
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes Exit button work
		j.setResizable(false); //makes game window not resizable (fixes strecthes)
		j.setLocationRelativeTo(null); //not needed but window would start in topleft otherwise
		j.setVisible(true); // have to see it
		JPanel jp = new JPanel();
		jp.add(newGame);
		jp.add(load1);
		jp.add(load2);
		jp.add(load3);
		j.add(jp);
	}
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
