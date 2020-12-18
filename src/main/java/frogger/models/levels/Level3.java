package frogger.models.levels;

import frogger.models.actors.*;

/**
 * <p>The class Level3 is a level that is played by the user in the Frogger Game.</p>
 * <p>Level3 can be customized through adding different {@link frogger.models.actors.Actor}s in its constructor.</p>
 */
public class Level3 extends Level {
	
	/**
	 * <p>The constructor of Level3</p>
	 * <p>{@link frogger.models.actors.Actor}s added in the constructor to customize the level.</p>
	 */
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
		
		setPlayertoFront();
		
	}
	
}
