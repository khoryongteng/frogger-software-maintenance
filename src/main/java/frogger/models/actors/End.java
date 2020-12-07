package frogger.models.actors;

import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	private Image end = new Image("file:src/main/resources/images/End.png", 49, 49, true, true);
	private Image frogEnd = new Image("file:src/main/resources/images/FrogEnd.png", 49, 49, true, true);
	
	public End(int x, int y) {
		setImage(end);
		setX(x);
		setY(y);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	//set activated to true when frog reached end, change to corresponding image
	protected void setEnd() {
		setImage(frogEnd);
		activated = true;
	}
	
	//Return if frog reached and activated End
	protected boolean isActivated() {
		return activated;
	}
	

}
