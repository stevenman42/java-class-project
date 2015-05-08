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
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return id;
	}
	
	public Image getImage(){
		return image;
	}
	
	public boolean equals(Object obj){
		Item i = (Item) obj;
		return i.getID().equals(id) && i.getName().equals(name);
	}
	
}
