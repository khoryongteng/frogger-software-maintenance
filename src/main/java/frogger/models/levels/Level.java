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
	
	public Scoreboard getScoreboard() {
		
		return scoreboard;
		
	}
	
	public Animal getAnimal() {
		
		return animal;
		
	}
	
	public void setAnimaltoFront() {
		
		animal.toFront();
		
	}
	
}
