package p4_group_8_repo;

public interface Level {
	
	public Scoreboard getScoreboard();
	
	public Animal getAnimal();
	
	public void add(Actor actor);
	
	public void stop();
	
	public void start();
	
}
