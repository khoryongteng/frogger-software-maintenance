package frogger.models.levels;

import frogger.models.actors.*;

public class Level2 extends Level {
	
	public Level2() {
		
		add(new Digit(2, 30, 155, 17));
		
		add(new ShortLog(0, 166, 0.75));
		add(new ShortLog(220, 166, 0.75));
		add(new ShortLog(440, 166, 0.75));
		
		add(new LongLog(0, 276, -2));
		add(new LongLog(400, 276, -2));
		
		add(new ShortLog(50, 329, 0.75));
		add(new ShortLog(270, 329, 0.75));
		add(new ShortLog(490, 329, 0.75));
		
		add(new Turtle(500, 376, -1));
		add(new Turtle(300, 376, -1));
		add(new WetTurtle(700, 376, -1));
		
		add(new WetTurtle(600, 217, -1));
		add(new WetTurtle(400, 217, -1));
		add(new WetTurtle(200, 217, -1));
		
		add(new ShortTruck(0, 649, 1));
		add(new ShortTruck(300, 649, 1));
		add(new ShortTruck(600, 649, 1));
		
		add(new Car(100, 597, -1));
		add(new Car(250, 597, -1));
		add(new Car(400, 597, -1));
		add(new Car(550, 597, -1));
		add(new Car(700, 597, -1));
		
		add(new LongTruck(0, 540, 1));
		add(new LongTruck(500, 540, 1));
		
		add(new Car(500, 490, -5));
		
		setPlayertoFront();
		
	}
	
}
