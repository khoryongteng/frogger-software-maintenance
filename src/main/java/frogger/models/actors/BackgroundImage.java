package frogger.models.actors;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	//Constructor 
	public BackgroundImage() {
		
		setImage(new Image("file:src/main/resources/images/GameBackground.png", 600, 800, true, true));
		
	}
	
	@Override
	public void act(long now) {
		
		
	}
	
}
