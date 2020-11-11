package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	
	//Constructor
	public Log(String imageLink, int size, int x, int y, double speed) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	//Action when method called
	@Override
	public void act(long now) {
		move(speed , 0);
		KeepWithinWindow(speed);
	}
	
	//Keep Log within game window borders
	private void KeepWithinWindow(double speed) {
		
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
		
	}
	
	//Check if log is moving left
	public boolean getLeft() {
		return speed < 0;
	}
}
