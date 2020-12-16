package frogger.models.actors;

public abstract class Rideable extends Actor {

	protected double speed;
	
	public Rideable(int x, int y, double speed) {
		
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	protected abstract void KeepWithinWindow(double speed);
		
	@Override
	public void act(long now) {
		
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
		
	public double getSpeed() {
			
		return speed;
			
	}
	
}
