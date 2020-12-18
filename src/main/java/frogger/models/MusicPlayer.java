package frogger.models;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *	<p>The class MusicPlayer is used to play music in scene.</p>
 */
public class MusicPlayer{

	private MediaPlayer mediaPlayer;
	
	/**
	 * <p>The constructor of MusicPlayer.</p>
	 * <p>Music file to be played is set.</p>
	 * @throws URISyntaxException 
	 */
	public MusicPlayer() throws URISyntaxException{
		
		Media sound = new Media(getClass().getResource("/audio/Frogger Main Song Theme (loop).mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		
	}
	
	/**
	 * <p>Play Music.</p>
	 */
	public void play() {
	    mediaPlayer.play();
	}
	
	/**
	 * <p>Stop Music.</p>
	 */
	public void stop() {
		mediaPlayer.stop();
	}
	
}
