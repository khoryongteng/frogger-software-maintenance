package frogger.models.actors;

import javafx.scene.image.Image;

public class LongLog extends Rideable implements IRideable{
	
	//Constructor
	public LongLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/images/logs.png", 300, 300, true, true));
		
	}
	
	@Override
	protected void KeepWithinWindow(double speed) {
		
		if (getX()>600 && speed>0) {
			
			setX(-300);
			
		}
	
		if (getX()<-300 && speed<0) {
			
			setX(700);
			
		}
				
	}
}
