package p4_group_8_repo;

import javafx.scene.image.Image;

public abstract class Rideable extends Actor {

	private double speed;
	
	public Rideable(int x, int y, double speed) {
		
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
		@Override
		public void act(long now) {
			move(speed , 0);
			KeepWithinWindow(speed);
		}
		
		private void KeepWithinWindow(double speed) {
			
			if (getX()>600 && speed>0)
				setX(-180);
			if (getX()<-300 && speed<0)
				setX(700);
			
		}
	
}
