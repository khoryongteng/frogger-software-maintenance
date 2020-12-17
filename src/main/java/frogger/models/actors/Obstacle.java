package frogger.models.actors;

public abstract class Obstacle extends Actor {
	
	protected double speed;
	
	//Constructor
	public Obstacle(int x, int y, double speed) {

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
	
	//Keep obstacle within game window borders
	private void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0) {
			
			setX(-200);
			
		}
			
		if (getX() < -200 && speed<0) {
			
			setX(600);
			
		}
			
	}
	
}