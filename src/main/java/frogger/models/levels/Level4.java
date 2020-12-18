package frogger.models.levels;

import frogger.models.actors.*;

/**
 * <p>The class Level4 is a level that is played by the user in the Frogger Game.</p>
 * <p>Level4 can be customized through adding different {@link frogger.models.actors.Actor}s in its constructor.</p>
 */
public class Level4 extends Level {

	/**
	 * <p>The constructor of Level4</p>
	 * <p>{@link frogger.models.actors.Actor}s added in the constructor to customize the level.</p>
	 */
	public Level4() {
		
		add(new Digit(4, 30, 155, 17));
		
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
		
		setPlayertoFront();
	
	}
	
}
