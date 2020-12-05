package frogger.models.levels;

import frogger.models.Scoreboard;
import frogger.models.actors.*;

public abstract class Level extends World {
	
	private Scoreboard scoreboard;
	private Animal animal;
	
	public Level() {
		
		add(new BackgroundImage());
		scoreboard = new Scoreboard(this);
		add(new End(13, 80));
		add(new End(141, 80));
		add(new End(269, 80));
		add(new End(398, 80));
		add(new End(528, 80));
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
