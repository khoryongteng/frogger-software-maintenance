package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class Spikes is an {@link frogger.models.actors.Obstacle} that kills the {@link frogger.models.actors.Player} when intersected.</p>
 * <p>Spikes are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Spikes in the level.</p>
 */
public class Spikes extends Obstacle implements IObstacle{

	private Image spike1 = new Image("file:src/main/resources/images/spike1.png", 50, 50, true, true);
	private Image spike2 = new Image("file:src/main/resources/images/spike2.png", 50, 50, true, true);
	private Image spike3 = new Image("file:src/main/resources/images/spike3.png", 50, 50, true, true);
	private boolean spikeup = false;
	private long spikeuptime;
	
	/**
	 * <p>The constructor of Spikes.</p>
	 * <p>The initial image spike is set here.</p>
	 * @param x the position of Spikes on the x-axis.
	 * @param y the position of Spikes on the y-axis.
	 */
	public Spikes(int x, int y) {
		
		super(x, y, 0);
		setImage(spike1);
		
	}
	
	private boolean isIntersectPlayer() {
		
		if(getIntersectingObjects(Player.class).size() >= 1) {
			
			return true;
			
		}
		
		return false;
		
	}

	private void spikeAnimation(long now) {
		
		if(spikeup) {
		
			if (now == spikeuptime) {
				
				setImage(spike2);
				
			}
			
			if (now >= spikeuptime + 80000000) {
			
				setImage(spike3);
			
			}
		
			if (now >= spikeuptime + 500000000) {
				
				setImage(spike2);
			
			}
			
			if (now >= spikeuptime + 600000000) {
				
				setImage(spike1);
				spikeup = false;
				
			}
				
		}
		
	}
	
	/**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Spikes to act every game frame.</p>
     * <p>Spike detects if it is intersected by {@link frogger.models.actors.Player}, and animates spiking upwards if so.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {
		
		if (isIntersectPlayer()&&!spikeup) {
			
			spikeup = true;	
			spikeuptime = now;
			
		}
		
		spikeAnimation(now);
		
	}
	
}
