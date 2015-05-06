package base;

public class StaticGame {
	
	private static Game game;
	
	public static void setGame(Game g){
		game = g;
	}
	
	public static Game getGame(){
		return game;
	}
	
}
