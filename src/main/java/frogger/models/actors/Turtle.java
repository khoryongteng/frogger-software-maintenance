package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class Turtle is a {@link frogger.models.actors.Rideable} that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>Turtles are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Turtle in the level.</p>
 */
public class Turtle extends Rideable implements IRideable{
	
	private Image turtleframe1 = new Image("file:src/main/resources/images/TurtleAnimation1.png", 130, 130, true, true);
	private Image turtleframe2 = new Image("file:src/main/resources/images/TurtleAnimation2.png", 130, 130, true, true);
	private Image turtleframe3 = new Image("file:src/main/resources/images/TurtleAnimation3.png", 130, 130, true, true);
	private double speed;
	
	/**
	 * <p>The constructor of Turtle.</p>
	 * <p>The initial image of Turtle is set here.</p>
	 * @param x the initial position of Turtle on the x-axis.
	 * @param y the initial position of Turtle on the y-axis.
	 * @param speed the speed that the Turtle will move at.
	 */
	public Turtle(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(turtleframe2);
		
	}
	
	private void turtleAnimation(long now) {
			
		if (now/900000000  % 3 ==0) {
			
			setImage(turtleframe2);
				
		}
		else if (now/900000000 % 3 == 1) {
			
			setImage(turtleframe1);
				
		}
		else if (now/900000000 %3 == 2) {
			
			setImage(turtleframe3);
				
		}
			
	}
	
	/**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Turtle to act every game frame.</p>
     * <p>Moves the Turtle based on speed every frame and ensures the Turtle objects will be in game bounds. Turtle animation is also animated here.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {

		turtleAnimation(now);	
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
	@Override
	protected void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0) {
			
			setX(-200);
			
		}
		
		if (getX() < -130 && speed<0) {
			
			setX(600);
			
		}

	}
	
}
