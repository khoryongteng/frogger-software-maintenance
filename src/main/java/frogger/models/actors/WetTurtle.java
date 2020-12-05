package frogger.models.actors;

import javafx.scene.image.Image;

public class WetTurtle extends Rideable {
	Image turtleframe1 = new Image("file:src/main/resources/images/TurtleAnimation1.png", 130, 130, true, true);
	Image turtleframe2 = new Image("file:src/main/resources/images/TurtleAnimation2Wet.png", 130, 130, true, true);
	Image turtleframe3 = new Image("file:src/main/resources/images/TurtleAnimation3Wet.png", 130, 130, true, true);
	Image turtleframe4 = new Image("file:src/main/resources/images/TurtleAnimation4Wet.png", 130, 130, true, true);
	private double speed;
	boolean sunk = false;
	
	//Constructor
	public WetTurtle(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(turtleframe2);
		
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
		else if (now/900000000 % 4 == 2) {
			setImage(turtleframe3);
			sunk = false;
		} else if (now/900000000 % 4 == 3) {
			setImage(turtleframe4);
			sunk = true;
		}
				
	}
	
	//Action when method called
	@Override
	public void act(long now) {

		TurtleState(now);
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
	
	//Keep turtle within game window borders
	protected void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0) {
			
			setX(-200);
			
		}
		
		if (getX() < -130 && speed<0) {
			
			setX(600);
			
		}

	}
	
	//Return if turtle is sunk
	protected boolean isSunk() {
		return sunk;
	}
	
	
}
