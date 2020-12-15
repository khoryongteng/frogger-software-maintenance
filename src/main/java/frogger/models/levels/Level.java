package frogger.models.levels;

import frogger.models.Scoreboard;
import frogger.models.actors.*;

public abstract class Level extends World {
	
	private Scoreboard scoreboard;
	private Animal animal;
	
	public Level() {
		
		add(new BackgroundImage());
		scoreboard = new Scoreboard(this);
		add(new End(19, 95));
		add(new End(148, 95));
		add(new End(277, 95));
		add(new End(405, 95));
		add(new End(534, 95));
		animal = new Animal();
		add(animal);
		
		
	}
	
	public boolean changeScore() {
		
		return animal.changeScore();
		
	}
	
	public void setScore(int score) {
		
		scoreboard.setScore(score);
		
	}
	
	public boolean getStop() {
		
		return animal.getStop();
		
	}
	
	public int getPoints() {
		
		return animal.getPoints();
		
	}
	
	public void setAnimaltoFront() {
		
		animal.toFront();
		
	}
	
}
