package p4_group_8_repo;

public abstract class Level extends World {
	
	private Scoreboard scoreboard;
	private Animal animal;
	
	public Level() {
		
		add(new BackgroundImage());
		scoreboard = new Scoreboard(this);
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
