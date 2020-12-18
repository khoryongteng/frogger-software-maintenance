package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class WetTurtle is a {@link frogger.models.actors.Rideable} that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>WetTurtles are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a WetTurtle in the level.</p>
 */
public class WetTurtle extends Rideable implements ISinkable{
	
	private Image turtleframe1 = new Image("file:src/main/resources/images/TurtleAnimation1.png", 130, 130, true, true);
	private Image turtleframe2 = new Image("file:src/main/resources/images/TurtleAnimation2Wet.png", 130, 130, true, true);
	private Image turtleframe3 = new Image("file:src/main/resources/images/TurtleAnimation3Wet.png", 130, 130, true, true);
	private Image turtleframe4 = new Image("file:src/main/resources/images/TurtleAnimation4Wet.png", 130, 130, true, true);
	private double speed;
	private boolean sunk = false;
	
	/**
	 * <p>The constructor of WetTurtle.</p>
	 * <p>The initial image of WetTurtle is set here.</p>
	 * @param x the initial position of WetTurtle on the x-axis.
	 * @param y the initial position of WetTurtle on the y-axis.
	 * @param speed the speed that the WetTurtle will move at.
	 */
	public WetTurtle(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(turtleframe2);
		
	}
	
	private void TurtleState(long now) {
				
		if (now/900000000  % 4 ==0) {
			setImage(turtleframe2);
			sunk = false;
				
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtleframe1);
			sunk = false;
		}
		else if (now/900000000 % 4 == 2) {
			setImage(turtleframe3);
			sunk = false;
		} else if (now/900000000 % 4 == 3) {
			setImage(turtleframe4);
			sunk = true;
		}
				
	}
	
	/**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause WetTurtle to act every game frame.</p>
     * <p>Moves the WetTurtle based on speed every frame and ensures the WetTurtle objects will be in game bounds. WetTurtle animation is also animated here.</p>
     * <p>WetTurtle state of whether it is sunk is also set here.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {

		TurtleState(now);
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
	
	/**
	 * <p>Get whether the WetTurtle is sunk and cannot be ridden on by {@link frogger.models.actors.Player}.</p>
	 * @return the boolean whether the WetTurtle is sunk and cannot be ridden on.
	 */
	@Override
	public boolean isSunk() {
		return sunk;
	}
	
	
}
