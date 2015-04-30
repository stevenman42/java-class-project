package game.saveData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	private Scanner scanner;
	
    private static final java.util.Locale usLocale = new java.util.Locale("en", "US");
	
	public FileReader(File file){
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.useLocale(usLocale);
	}
	
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }
	
    public String readLine() {
        String line = "";
        try{
        	line = scanner.nextLine();
        }catch(Exception e){
        	line = null;
        }
        return line;
    }
    
}
