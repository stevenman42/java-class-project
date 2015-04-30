package game.saveData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileWriter {
	
	private PrintWriter writer;
	
    private static String cn = "UTF-8";
	
	public FileWriter(String str){
		
		OutputStream os;
		try {
			os = new FileOutputStream(str);
			OutputStreamWriter osw = new OutputStreamWriter(os, cn);
			writer = new PrintWriter(osw, true);
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(UnsupportedEncodingException uee){
			uee.printStackTrace();
		}
		
	}
	
	public void print(String s){
		writer.print(s);
	}
	
	public void printLn(String s){
		writer.println(s);
	}
	
	public void close(){
		writer.close();
	}
	
}
