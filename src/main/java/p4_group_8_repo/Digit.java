package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dimensions;
	Image image1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dimensions, int x, int y) {
		image1 = new Image("file:src/main/resources/"+n+".png", dimensions, dimensions, true, true);
		setImage(image1);
		setX(x);
		setY(y);
	}
	
}
