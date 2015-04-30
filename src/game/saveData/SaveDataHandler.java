package game.saveData;

import java.io.File;
import java.util.ArrayList;

public class SaveDataHandler {
	
	private ArrayList<SaveData> data;
	
	boolean dataModified;
	
	public SaveDataHandler(){
		data = new ArrayList<SaveData>();
		dataModified = false;
	}
	
	public SaveData getDataFromKey(String key){
		for(SaveData sd : data){
			if(sd.getKey().equals(key)){
				return sd;
			}
		}
		return null;
	}
	
	public void readSaveData(String dir){
		File f = new File(dir);
		if(f.exists()){
			readSaveData(f);
		}
	}
	
	public void readSaveData(File file){
		
		FileReader fr = new FileReader(file);
		ArrayList<String> read = new ArrayList<String>();
		
		while(fr.hasNextLine()){
			read.add(fr.readLine());
		}
		
		for(String s : read){
			if(s.startsWith("//")){
				data.add(new SaveData("COMMENT", s.replaceFirst("//", "")));
				System.out.println("     +" + data.get(data.size() - 1));
			}else{
				String[] r = s.split("=");
				if(r.length != 2){
					System.err.println("Faulty Option: \"" + s + "\"");
				}
				data.add(new SaveData(r[0], r[1]));
				System.out.println("     +" + data.get(data.size() - 1));
			}
		}
		
	}
	
	public void writeSaveData(String s){
		
		FileWriter fw = new FileWriter(s);
		for(int i = 0; i < data.size(); i++){
			fw.printLn(data.get(i).format());
		}
		
	}
	
	public void addSaveData(SaveData sd){
		data.add(sd);
		dataModified = true;
	}
	
	public void removeSaveData(String key){
		for(int i = 0; i < data.size(); i++){
			if(data.get(i).getKey().equals(key)){
				data.remove(i);
				i--;
			}
		}
		dataModified = true;
	}
	
	public void writeDataIfNeeded(){
		if(dataModified){
			writeSaveData("RES/Options");
		}
	}
	
}
