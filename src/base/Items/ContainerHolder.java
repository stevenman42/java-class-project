package base.Items;

public class ContainerHolder {
	
	private Item item;
	private int amount;
	
	public ContainerHolder(Item i, int amt){
		item = i;
		amount = amt;
	}
	
	public Item getItem(){
		return item;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public void changeAmount(int d){
		amount += d;
	}
	
	public void setAmount(int amt){
		amount = amt;
	}
	
}
