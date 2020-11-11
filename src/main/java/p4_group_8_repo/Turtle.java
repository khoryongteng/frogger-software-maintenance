package p4_group_8_repo;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtleframe1;
	Image turtleframe2;
	Image turtleframe3;
	private int speed;
	
	//Constructor
	public Turtle(int x, int y, int speed, int width, int height) {
		turtleframe1 = new Image("file:src/main/resources/TurtleAnimation1.png", width, height, true, true);
		turtleframe2 = new Image("file:src/main/resources/TurtleAnimation2.png", width, height, true, true);
		turtleframe3 = new Image("file:src/main/resources/TurtleAnimation3.png", width, height, true, true);
		setX(x);
		setY(y);
		this.speed = speed;
		setImage(turtleframe2);
	}
	
	//Action when method called
	@Override
	public void act(long now) {

		TurtleAnimation(now);	
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
	//TurtleAnimation by set image
	private void TurtleAnimation(long now) {
		
		if (now/900000000  % 3 ==0) {
			setImage(turtleframe2);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtleframe1);
			
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtleframe3);
			
		}
		
	}
	
	//Keep turtle within game window borders
	private void KeepWithinWindow(int speed) {
		
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
		
	}
	
}
