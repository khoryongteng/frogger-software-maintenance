package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	
	
	public End(int x, int y) {
		setImage(new Image("file:src/main/resources/images/End.png", 60, 60, true, true));
		setX(x);
		setY(y);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	//set activated to true when frog reached end, change to corresponding image
	public void setEnd() {
		setImage(new Image("file:src/main/resources/images/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	//Return if frog reached and activated End
	public boolean isActivated() {
		return activated;
	}
	

}
