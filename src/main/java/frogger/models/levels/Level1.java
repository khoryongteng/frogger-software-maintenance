package frogger.models.levels;

import frogger.models.actors.*;

public class Level1 extends Level {
	
	public Level1() {
		
		add(new Digit(1, 30, 155, 17));
		
		add(new LongLog(0, 166, 0.75));
		add(new LongLog(450, 166, 0.75));
		
		add(new Crocodile(0, 217, 1.5));
		
		add(new WetTurtle(0, 276, -0.5));
		add(new Turtle(250, 276, -0.5));
		add(new WetTurtle(500, 276, -0.5));
		
		add(new ShortLog(0, 329, 1));
		add(new ShortLog(300, 329, 1));
		add(new ShortLog(500, 329, 1));
		
		add(new MediumLog(0, 376, 0.75));
		add(new ShortLog(300, 376, 0.75));
		add(new MediumLog(500, 376, 0.75));
		
		add(new Car(500, 490, 3));
		
		add(new Spikes(110, 535));
		add(new Spikes(160, 535));
		add(new Spikes(210, 535));
		add(new Spikes(345, 535));
		add(new Spikes(395, 535));
		add(new Spikes(445, 535));
		
		add(new LongTruck(0, 600, -1.5));
		add(new LongTruck(400, 600, -1.5));
		
		add(new Spikes(0, 640));
		add(new Spikes(50, 640));
		add(new Spikes(100, 640));
		add(new Spikes(225, 640));
		add(new Spikes(275, 640));
		add(new Spikes(325, 640));
		add(new Spikes(450, 640));
		add(new Spikes(500, 640));
		add(new Spikes(550, 640));
		
		setAnimaltoFront();
		
	}
	
}
