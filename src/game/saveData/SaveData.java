package game.saveData;

public class SaveData {
	
	private String key;
	private String data;
	
	public SaveData(String key, String data){
		this.key = key;
		this.data = data;
	}
	
	public String getKey(){
		return key;
	}
	
	public String getData(){
		return data;
	}
	
}
