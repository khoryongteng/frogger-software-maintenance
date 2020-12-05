package frogger.models.levels;

import frogger.models.actors.*;

public class Level4 extends Level {

	public Level4() {
		
		add(new Turtle(100, 166, 0.5));
		add(new Turtle(500, 166, 0.5));
		
		add(new MediumLog(0, 217, -2.5));
		
		add(new Crocodile(0, 276, 2));
		
		add(new Crocodile(440, 329, -2));
		
		add(new WetTurtle(0, 376, -1.5));
		add(new WetTurtle(250, 376, -1.5));
		add(new WetTurtle(500, 376, -1.5));
		
		add(new Car(0, 490, -1.1));
		add(new Car(200, 490, -1.1));
		add(new Car(400, 490, -1.1));
		add(new Car(600, 490, -1.1));
		
		add(new ShortTruck(0, 545, -1));
		add(new ShortTruck(270, 545, -1));
		add(new ShortTruck(540, 545, -1));
		
		add(new LongTruck(400, 600, 3));
		
		add(new Car(0, 655, 1));
		add(new Car(200, 655, 1));
		add(new Car(400, 655, 1));
		add(new Car(600, 655, 1));
		
		setAnimaltoFront();
	
	}
	
}
