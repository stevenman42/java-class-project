package base.Items;

public abstract class GameItem {
	
	private String name;
	private ItemID id;
	
	
	public GameItem(String name, ItemID id){
		this.name = name;
		this.id = id;		
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
	
	

}
