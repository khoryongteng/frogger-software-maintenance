package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer{

	private MediaPlayer mediaPlayer;
	
	public MusicPlayer(){
		
		String musicFile = "src/main/resources/audio/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		
	}
	
	public void play() {
		
	    mediaPlayer.play();
	}
	
	public void stop() {
		mediaPlayer.stop();
	}
	
}
