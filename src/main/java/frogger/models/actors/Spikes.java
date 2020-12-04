package frogger.models.actors;

import javafx.scene.image.Image;

public class Spikes extends Obstacle {

	private Image spike1 = new Image("file:src/main/resources/images/spike1.png", 50, 50, true, true);
	private Image spike2 = new Image("file:src/main/resources/images/spike2.png", 50, 50, true, true);
	private Image spike3 = new Image("file:src/main/resources/images/spike3.png", 50, 50, true, true);
	private boolean spikeup = false;
	private long spikeuptime;
	
	public Spikes(int x, int y) {
		
		super(x, y, 0);
		setImage(spike1);
		
	}
	
	private boolean isIntersectAnimal() {
		
		if(getIntersectingObjects(Animal.class).size() >= 1) {
			
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
	
	@Override
	public void act(long now) {
		
		if (isIntersectAnimal()&&!spikeup) {
			
			spikeup = true;	
			spikeuptime = now;
			
		}
		
		spikeAnimation(now);
		
	}
	
}
