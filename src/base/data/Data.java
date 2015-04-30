package base.data;

public class Data {
	
	private String key;
	private String data;
	
	public Data(String key, String data){
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