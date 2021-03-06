package game.saveData;

public class SaveData {
	
	/**
	 * the key that was read
	 */
	private String key;
	
	/**
	 * the data that was read
	 */
	private String data;
	
	/**
	 * constructor
	 * @param key	the key
	 * @param data	the data
	 */
	public SaveData(String key, String data){
		this.key = key;
		this.data = data;
	}
	
	/**
	 * returns the key
	 * @return
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * returns the data
	 * @return
	 */
	public String getData(){
		return data;
	}
	
	/**
	 * default toString
	 */
	public String toString(){
		return "SaveData \"" + key + "=" + data + "\"";
	}
	
	/**
	 * formats for re-writing
	 * @return
	 */
	public String format(){
		if(key.equals("COMMENT")){
			return "//" + data;
		}else{
			return key + "=" + data;
		}
	}
	
}
