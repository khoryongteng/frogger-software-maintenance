package p4_group_8_repo;

import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public abstract class Level extends World {

	private Digit[] scoreDigit =  new Digit[4];
	public Animal animal;
	
	public Level() {
		
		BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/iKogsKW.png");
		add(froggerback);
		
		scoreDigit[0] = new Digit(0, 30, 360, 25);
		scoreDigit[1] = new Digit(0, 30, 330, 25);
		scoreDigit[2] = new Digit(0, 30, 300, 25);
		scoreDigit[3] = new Digit(0, 30, 270, 25);
				
		add(scoreDigit[0]);
		add(scoreDigit[1]);
		add(scoreDigit[2]);
		add(scoreDigit[3]);
		
	}
	
	public void setScore(int n) {
		
    	for(int i=0;i<4;i++) {
    		
    		int d = n / 10;
    		int k = n - d * 10;
    		scoreDigit[i].setDigit(k);
    		n = d;
    		
    	}
		
	}
	
	@Override
	public void controlsHandler(KeyEvent event){
		
		animal.playerControls(event);
		
	}
	
	@Override
	public void act(long now) {
		
		
		
	}

}
