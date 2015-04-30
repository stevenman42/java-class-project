package base.data;

public class GameData {
	
	private String key;
	private String data;
	
	public GameData(String key, String data){
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