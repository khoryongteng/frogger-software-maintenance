package frogger.models.levels;

import frogger.models.actors.Digit;

/**
 * <p>The Scoreboard class is a class that generates a 4 digit scoreboard in a {@link frogger.models.levels.Level} using {@link frogger.models.actors.Digit}s.</p>
 * <p>Score on Scoreboard can be set using {@link #setScore(int)} method.</p>
 */
public class Scoreboard {

	private Digit[] scoreDigit;
	
	/**
	 * <p>The constructor of Scoreboard that constructs a 4 digit scoreboard in a {@link frogger.models.levels.Level}.</p>
	 * @param level {@link frogger.models.levels.Level} that Scoreboard should be added in.
	 */
	public Scoreboard(Level level) {
		
		scoreDigit =  new Digit[4];
		
		scoreDigit[0] = new Digit(0, 30, 550, 17);
		scoreDigit[1] = new Digit(0, 30, 520, 17);
		scoreDigit[2] = new Digit(0, 30, 490, 17);
		scoreDigit[3] = new Digit(0, 30, 460, 17);
		
		for(int i = 0;i < scoreDigit.length; i++) {
			
			level.add(scoreDigit[i]);
			
		}
		
	}
	
	/**
	 * <p>Set score displayed up to 4 digits.</p>
	 * @param n int score to be displayed up to 4 digits.
	 */
	protected void setScore(int n) {
		
    	for(int i=0;i<4;i++) {
    		
    		int d = n / 10;
    		int k = n - d * 10;
    		scoreDigit[i].setDigit(k);
    		n = d;
    		
    	}
		
	}
	
}
