package frogger.models.levels;

import frogger.models.actors.Digit;

public class Scoreboard {

	private Digit[] scoreDigit;
	
	public Scoreboard(Level level) {
		
		scoreDigit =  new Digit[4];
		
		scoreDigit[0] = new Digit(0, 30, 360, 25);
		scoreDigit[1] = new Digit(0, 30, 330, 25);
		scoreDigit[2] = new Digit(0, 30, 300, 25);
		scoreDigit[3] = new Digit(0, 30, 270, 25);
		
		for(int i = 0;i < scoreDigit.length; i++) {
			
			level.add(scoreDigit[i]);
			
		}
		
	}
	
	protected void setScore(int n) {
		
    	for(int i=0;i<4;i++) {
    		
    		int d = n / 10;
    		int k = n - d * 10;
    		scoreDigit[i].setDigit(k);
    		n = d;
    		
    	}
		
	}
	
}
