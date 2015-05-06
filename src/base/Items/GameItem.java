package base.Items;

public abstract class GameItem {
	
	private String name;
	private ItemID id;
	private boolean isActive;
	
	public GameItem(String name, ItemID id){
		this.name = name;
		this.id = id;	
		isActive = false;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setID(ItemID id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public ItemID getID(){
		return id;
	}
	public void setIsActive(boolean b){
		isActive = b;
	}
	public boolean isActive(){
		return isActive;
	}
	
	

}
