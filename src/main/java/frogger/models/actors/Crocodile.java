package frogger.models.actors;

import javafx.scene.image.Image;

public class Crocodile extends Rideable {

	private Image crocodileRight = new Image("file:src/main/resources/images/crocodileRight.png", 160, 160, true, true);
	private Image crocodileLeft = new Image("file:src/main/resources/images/crocodileLeft.png", 160, 160, true, true);
	
	public Crocodile(int x, int y, double speed) {
		
		super(x, y, speed);
		setCrocodileImage(speed);
		
	}

	@Override
	protected void KeepWithinWindow(double speed) {
		
		
				
	}
	
	private void movement(double speed) {
		
		if((speed > 0)&&(getX() > 450)){
			
			this.speed = -speed;
			
		}
		else if((speed < 0)&&(getX() < 0)) {
			
			this.speed = -speed;
			
		}
		
	}
	
	private void setCrocodileImage(double speed) {
		
		if(speed > 0) {
			
			setImage(crocodileRight);
			
		}
		else {
			
			setImage(crocodileLeft);
		
		}
		
	}
	
	public void act(long now) {
		
		move(speed , 0);
		movement(speed);
		setCrocodileImage(speed);
		
	}
	
}
