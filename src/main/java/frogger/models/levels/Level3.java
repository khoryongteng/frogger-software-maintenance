package frogger.models.levels;

import frogger.models.actors.*;

public class Level3 extends Level {
	
	public Level3() {
		
		add(new Digit(3, 30, 155, 17));
		
		add(new Crocodile(0, 166, 3));
		
		add(new Crocodile(440, 217, -2.5));
		
		add(new Crocodile(0, 276, 2));
		
		add(new Crocodile(440, 329, -1.5));
		
		add(new Crocodile(0, 376, 1));
		
		add(new Car(0, 490, -1));
		add(new Car(200, 490, -1));
		add(new Car(400, 490, -1));
		add(new Car(600, 490, -1));
		
		add(new ShortTruck(0, 545, 1));
		add(new ShortTruck(270, 545, 1));
		add(new ShortTruck(540, 545, 1));
		
		add(new LongTruck(0, 600, -1));
		add(new LongTruck(400, 600, -1));
		
		add(new Car(0, 655, 1));
		add(new Car(200, 655, 1));
		add(new Car(400, 655, 1));
		add(new Car(600, 655, 1));
		
		setAnimaltoFront();
		
	}
	
}
