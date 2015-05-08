package base.Items;

import java.util.ArrayList;

public class Container {
	
	private ArrayList<ContainerHolder> contents;
	
	public Container(){
		
		contents = new ArrayList<ContainerHolder>();
		
	}
	
	public int getSize(){
		return contents.size();
	}
	
	public void addItem(Item item){
		addItem(item, 1);
	}
	
	public void removeItem(Item item){
		removeItem(item, 1);
	}
	
	public void addItem(Item item, int amt){		
		for(int i = 0; i < contents.size(); i++){
			if(contents.get(i).getItem().equals(item)){
				contents.get(i).changeAmount(1);
				return;
			}
		}
		contents.add(new ContainerHolder(item, amt));
	}
	
	public void removeItem(Item item, int amt){
		
		for(int i = 0; i < contents.size(); i++){
			if(contents.get(i).getItem().equals(item)){
				if(contents.get(i).getAmount() <= amt){
					contents.remove(i);
					return;
				}else{
					contents.get(i).changeAmount(-amt);
					return;
				}
			}
		}
		
	}
	
}
