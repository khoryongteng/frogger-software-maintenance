package p4_group_8_repo;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	Image turtleframe1;
	Image turtleframe2;
	Image turtleframe3;
	Image turtleframe4;
	private int speed;
	boolean sunk = false;
	
	//Constructor
	public WetTurtle(int x, int y, int speed, int width, int height) {
		
		turtleframe1 = new Image("file:src/main/resources/TurtleAnimation1.png", width, height, true, true);
		turtleframe2 = new Image("file:src/main/resources/TurtleAnimation2Wet.png", width, height, true, true);
		turtleframe3 = new Image("file:src/main/resources/TurtleAnimation3Wet.png", width, height, true, true);
		turtleframe4 = new Image("file:src/main/resources/TurtleAnimation4Wet.png", width, height, true, true);
		setX(x);
		setY(y);
		this.speed = speed;
		setImage(turtleframe2);
		
	}
	
	//Action when method called
	@Override
	public void act(long now) {

		TurtleState(now);
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
	//TurtleAnimation by set image
	private void TurtleState(long now) {
			
		if (now/900000000  % 4 ==0) {
			setImage(turtleframe2);
			sunk = false;
			
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtleframe1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtleframe3);
			sunk = false;
		} else if (now/900000000 %4 == 3) {
			setImage(turtleframe4);
			sunk = true;
		}
			
	}
		
	//Keep turtle within game window borders
	private void KeepWithinWindow(int speed) {
			
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
		
	}
	
	//Return if turtle is sunk
	public boolean isSunk() {
		return sunk;
	}
	
	
}
