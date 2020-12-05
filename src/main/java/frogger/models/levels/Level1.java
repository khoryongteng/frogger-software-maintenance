package frogger.models.levels;

import frogger.models.actors.*;

public class Level1 extends Level{
	
	public Level1() {
		
		add(new Crocodile(0, 166, 0.75));
		add(new Spikes(100, 590));
		//add(new ShortLog(0, 166, 0.75));
		//add(new ShortLog(220, 166, 0.75));
		//add(new ShortLog(440, 166, 0.75));
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
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
		setAnimaltoFront();
		/*
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
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/main/resources/froggerUp.png");
		add(animal);
		add(new ShortTruck(0, 649, 1));
		add(new ShortTruck(300, 649, 1));
		add(new ShortTruck(600, 649, 1));
		add(new Car(100, 597, -1));
		add(new Car(250, 597, -1));
		add(new Car(400, 597, -1));
		add(new Car(550, 597, -1));
		add(new LongTruck(0, 540, 1));
		add(new LongTruck(500, 540, 1));
		add(new Car(500, 490, -5));
		*/
	}
	
}
