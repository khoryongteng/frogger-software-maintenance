package frogger.models.levels;

import frogger.models.actors.BackgroundImage;
import frogger.models.actors.End;
import frogger.models.actors.Player;

/**
 * <p>The abstract class Level defines common methods and adds common {@link frogger.models.actors.Actor}s and objects of all Frogger Levels {@link frogger.models.levels.Level1}, {@link frogger.models.levels.Level2}, {@link frogger.models.levels.Level3}, {@link frogger.models.levels.Level4}, {@link frogger.models.levels.Level5}.</p>
 * <p>Level class cannot be initialized but a Level can be initialized through concrete classes that inherits Level.</p>
 */
public abstract class Level extends World {
	
	private BackgroundImage backgroundImage;
	private Scoreboard scoreboard;
	private Player player;
	private End[] end = new End[5];
	
	/**
     * <p>The constructor of Level abstract class.</p>
     * <p>Adds common {@link frogger.models.actors.Actor}s and objects present across Levels</p>
     */
	public Level() {
		
		backgroundImage = new BackgroundImage();
		add(backgroundImage);
		
		scoreboard = new Scoreboard(this);
		
		end[0] = new End(19, 95);
		end[1] = new End(148, 95);
		end[2] = new End(277, 95);
		end[3] = new End(405, 95);
		end[4] = new End(534, 95);
		
		for(int i = 0;i < end.length; i++) {
			
			add(end[i]);
			
		}
		
		player = new Player();
		add(player);
		
		
	}
	
	/**
	 * <p>Get whether score change conditions are met.</p>
	 * @return boolean whether score change conditions are met.
	 */
	public boolean changeScore() {
		
		return player.changeScore();
		
	}
	
	/**
	 * <p>Set score displayed in {@link frogger.models.levels.Scoreboard} added in constructor.</p>
	 * @param score int score to be displayed in {@link frogger.models.levels.Scoreboard}.
	 */
	public void setScore(int score) {
		
		scoreboard.setScore(score);
		
	}
	
	/**
	 * <p>Get whether level end conditions are met.</p>
	 * @return boolean whether level end conditions are met.
	 */
	public boolean getStop() {
		
		return player.getStop();
		
	}
	
	/**
	 * <p>Get points acquired by the {@link frogger.models.actors.Player}.</p>
	 * @return int of points acquired by the {@link frogger.models.actors.Player}.
	 */
	public int getPoints() {
		
		return player.getPoints();
		
	}
	
	/**
	 * <p>Move Player to the front of all {@link frogger.models.actors.Actor}s in Level.</p>
	 */
	protected void setPlayertoFront() {
		
		player.toFront();
		
	}
	
}
