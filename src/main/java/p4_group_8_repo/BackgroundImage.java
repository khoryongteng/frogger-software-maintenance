package p4_group_8_repo;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	public BackgroundImage(String imageLink) {
		
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}
	
	@Override
	public void act(long now) {
		
		
	}
	
	

}
