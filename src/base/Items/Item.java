package base.Items;

import java.awt.Image;
import java.awt.Toolkit;

public class Item {
	
	protected String name;
	
	protected ItemID id;
	
	protected Image image;
	
	protected boolean isActive;
	
	public Item(String name, ItemID id, String img){
		
		this.name = name;
		this.id = id;
		
		image = Toolkit.getDefaultToolkit().createImage(img);
		
		if(image == null){
			System.err.println("coulden't create an image");
		}
		isActive = false;		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public ItemID getID(){
		return id;
	}
	
	public Image getImage(){
		return image;
	}
	
	public boolean equals(Object obj){
		Item i = (Item) obj;
		return i.getID().equals(id) && i.getName().equals(name);
	}
	public void setIsActive(boolean b){
		isActive = b;
	}
	public boolean isActive(){
		return isActive;
	}
	
}
