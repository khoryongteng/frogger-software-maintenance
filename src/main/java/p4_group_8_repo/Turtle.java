package p4_group_8_repo;

import javafx.scene.image.Image;

public class Turtle extends Rideable{
	Image turtleframe1 = new Image("file:src/main/resources/TurtleAnimation1.png", 130, 130, true, true);
	Image turtleframe2 = new Image("file:src/main/resources/TurtleAnimation2.png", 130, 130, true, true);
	Image turtleframe3 = new Image("file:src/main/resources/TurtleAnimation3.png", 130, 130, true, true);
	private double speed;
	
	//Constructor
	public Turtle(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(turtleframe2);
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
	
	//Action when method called
	@Override
	public void act(long now) {

		TurtleAnimation(now);	
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
	//Keep turtle within game window borders
	private void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
		
	}
	
}
