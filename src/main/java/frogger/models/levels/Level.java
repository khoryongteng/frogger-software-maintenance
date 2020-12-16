package frogger.models.levels;

import frogger.models.actors.*;

public abstract class Level extends World {
	
	private Scoreboard scoreboard;
	private Player player;
	
	public Level() {
		
		add(new BackgroundImage());
		scoreboard = new Scoreboard(this);
		add(new End(19, 95));
		add(new End(148, 95));
		add(new End(277, 95));
		add(new End(405, 95));
		add(new End(534, 95));
		player = new Player();
		add(player);
		
		
	}
	
	public boolean changeScore() {
		
		return player.changeScore();
		
	}
	
	public void setScore(int score) {
		
		scoreboard.setScore(score);
		
	}
	
	public boolean getStop() {
		
		return player.getStop();
		
	}
	
	public int getPoints() {
		
		return player.getPoints();
		
	}
	
	public void setPlayertoFront() {
		
		player.toFront();
		
	}
	
}
