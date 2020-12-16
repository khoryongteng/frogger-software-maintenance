package frogger.models.levels;

import frogger.models.actors.*;

public class Level5 extends Level {

	public Level5() {
		
		add(new Digit(5, 30, 155, 17));
		
		add(new ShortLog(0, 166, -0.5));
		add(new ShortLog(250, 166, -0.5));
		add(new ShortLog(500, 166, -0.5));
		
		add(new WetTurtle(0, 217, 1.5));
		add(new WetTurtle(250, 217, 1.5));
		add(new WetTurtle(500, 217, 1.5));
		
		add(new Crocodile(0, 276, 0.75));
		
		add(new Turtle(0, 329, -1.25));
		add(new Turtle(250, 329, -1.25));
		add(new Turtle(500, 329, -1.25));
		
		add(new Crocodile(440, 376, -2));
		
		add(new Spikes(60, 433));
		add(new Spikes(110, 433));
		add(new Spikes(160, 433));
		add(new Spikes(395, 433));
		add(new Spikes(445, 433));
		add(new Spikes(495, 433));
		
		add(new Car(0, 490, 0.75));
		add(new Car(200, 490, 0.75));
		add(new Car(400, 490, 0.75));
		add(new Car(600, 490, 0.75));
		
		add(new LongTruck(0, 545, -1.5));
		add(new LongTruck(300, 545, -1.5));
		
		add(new Car(400, 600, -4));
		
		add(new ShortTruck(0, 655, 1));
		add(new ShortTruck(270, 655, 1));
		add(new ShortTruck(540, 655, 1));
		
		setPlayertoFront();
		
	}
}
