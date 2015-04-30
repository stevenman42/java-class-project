package base.data;

import java.util.ArrayList;

public class DataHandler {
	
	private ArrayList<GameData> data;
	
	public DataHandler(){		
		data = new ArrayList<GameData>();		
	}
	
	public GameData getDataByKey(String key){
		
		for(GameData da : data){
			if(da.getKey().equals(key)){
				return da;
			}
		}
		
		return null;
		
	}
	
}
