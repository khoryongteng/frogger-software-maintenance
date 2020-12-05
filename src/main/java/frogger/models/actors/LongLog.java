package frogger.models.actors;

import javafx.scene.image.Image;

public class LongLog extends Rideable {
	
	//Constructor
	public LongLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/images/logs.png", 300, 300, true, true));
		
	}
	
	@Override
	protected void KeepWithinWindow(double speed) {
		
		if (getX()>600 && speed>0) {
			
			setX(-180);
			
		}
	
		if (getX()<-300 && speed<0) {
			
			setX(700);
			
		}
				
	}
}
