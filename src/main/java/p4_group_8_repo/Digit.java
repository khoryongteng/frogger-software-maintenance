package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{

	private Image[] number = new Image[10];
	
	//constructor
	public Digit(int n, int dimensions, int x, int y) {
		
		number[0] = new Image("file:src/main/resources/0.png", dimensions, dimensions, true, true);
		number[1] = new Image("file:src/main/resources/1.png", dimensions, dimensions, true, true);
		number[2] = new Image("file:src/main/resources/2.png", dimensions, dimensions, true, true);
		number[3] = new Image("file:src/main/resources/3.png", dimensions, dimensions, true, true);
		number[4] = new Image("file:src/main/resources/4.png", dimensions, dimensions, true, true);
		number[5] = new Image("file:src/main/resources/5.png", dimensions, dimensions, true, true);
		number[6] = new Image("file:src/main/resources/6.png", dimensions, dimensions, true, true);
		number[7] = new Image("file:src/main/resources/7.png", dimensions, dimensions, true, true);
		number[8] = new Image("file:src/main/resources/8.png", dimensions, dimensions, true, true);
		number[9] = new Image("file:src/main/resources/9.png", dimensions, dimensions, true, true);
		
		setImage(number[n]);
		setX(x);
		setY(y);
		
	}
	
	public void setDigit(int n) {
		
		setImage(number[n]);
		
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
