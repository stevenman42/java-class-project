package base.audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Audio {
	
	static AudioClip sound;
	public final File path;
	
	@SuppressWarnings("deprecation")
	public Audio(String PATH){
		path = new File(PATH);
		try{
			sound = Applet.newAudioClip(path.toURL());
		} catch(Exception e){
			
		}
	}
	
	public void play(){
		sound.play();
	}
	
	public void loop(){
		sound.loop();
	}
	
	public void stop(){
		sound.stop();
	}
	
	public void pause(){
		try {
			sound.wait();
		} catch (InterruptedException e) {
			System.err.println("COULD NOT PAUSE SOUND FILE");
		}
	}
	
	public void resume(){
		sound.notify();
	}
	
}
