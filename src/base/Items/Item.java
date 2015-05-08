package base.Items;

import java.awt.Image;
import java.awt.Toolkit;

public class Item {
	
	private String name;
	
	private String id;
	
	private Image image;
	
	public Item(String name, String id, String img){
		
		this.name = name;
		this.id = id;
		
		image = Toolkit.getDefaultToolkit().createImage(img);
		
		if(image == null){
			System.err.println("coulden't create an image");
		}
		
	}
	
}
