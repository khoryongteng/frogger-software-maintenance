package p4_group_8_repo;

public abstract class Rideable extends Actor {

	private double speed;
	
	public Rideable(int x, int y, double speed) {
		
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	private void KeepWithinWindow(double speed) {
			
		if (getX()>600 && speed>0) {
			
			setX(-180);
			
		}
	
		if (getX()<-300 && speed<0) {
			
			setX(700);
			
		}
				
			
	}
		
	@Override
	public void act(long now) {
		
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
		
	public double getSpeed() {
			
		return speed;
			
	}
	
}
