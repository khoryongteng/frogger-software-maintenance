package frogger.models.actors;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

/**
 * <p>The class Player is an {@link frogger.models.actors.Actor} representing the player in the Frogger game.</p>
 * <p>The class Player is added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Player in the level.</p>
 * <p>Player movement is handled by Player Class and translated into actual Player movement in the {@link frogger.models.levels.Level} classes.</p>
 * <p>Player animation is handled within Player Class.</p>
 * <p>Player class keeps track of points accumulated, point change compared to previous game state, and level end conditions. These values are passed to {@link frogger.models.levels.Level} classes when request methods are called.</p>
 */
public class Player extends Actor {
	
	private Image imgW1 = new Image("file:src/main/resources/images/froggerUp.png", 40, 40, true, true);
	private Image imgA1 = new Image("file:src/main/resources/images/froggerLeft.png", 40, 40, true, true);
	private Image imgS1 = new Image("file:src/main/resources/images/froggerDown.png", 40, 40, true, true);
	private Image imgD1 = new Image("file:src/main/resources/images/froggerRight.png", 40, 40, true, true);
	private Image imgW2 = new Image("file:src/main/resources/images/froggerUpJump.png", 40, 40, true, true);
	private Image imgA2 = new Image("file:src/main/resources/images/froggerLeftJump.png", 40, 40, true, true);
	private Image imgS2 = new Image("file:src/main/resources/images/froggerDownJump.png", 40, 40, true, true);
	private Image imgD2 = new Image("file:src/main/resources/images/froggerRightJump.png", 40, 40, true, true);
	private Image cardeath1 = new Image("file:src/main/resources/images/cardeath1.png", 40, 40, true, true);
	private Image cardeath2 = new Image("file:src/main/resources/images/cardeath2.png", 40, 40, true, true);
	private Image cardeath3 = new Image("file:src/main/resources/images/cardeath3.png", 40, 40, true, true);
	private Image waterdeath1 = new Image("file:src/main/resources/images/waterdeath1.png", 40, 40, true, true);
	private Image waterdeath2 = new Image("file:src/main/resources/images/waterdeath2.png", 40, 40, true, true);
	private Image waterdeath3 = new Image("file:src/main/resources/images/waterdeath3.png", 40, 40, true, true);
	private Image waterdeath4 = new Image("file:src/main/resources/images/waterdeath4.png", 40, 40, true, true);
	
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private static double movement = 13.3333333*2;
	private static double movementX = 10.666666*2;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int deathFrame = 0;
	private double currentDistance = 800;
	
	/**
	 * <p>The constructor of Player.</p>
	 * <p>Initial positioning in a {@link frogger.models.levels.Level} and initial image set here.</p>
	 * <p>Key listener called here to handle user input for Player controls.</p>
	 */
	public Player() {
		
		setX(300);
		setY(706);
		setImage(imgW1);
		setKeyListener();
		
	}
	
	private void setKeyListener() {
			
		setOnKeyPressed(new EventHandler<KeyEvent>() {
				
			public void handle(KeyEvent event){
					
				playerControls(event);
					
			}
				
		});
			
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event) {
					
				playerControls(event);
					
			}
				
		});
			
	}
	
	private void playerControls(KeyEvent event) {
		
		if (noMove) {
			
		}
		else {
			
			switch (event.getCode()) {
			
				case W: 
					
					move(0, -movement);
	                playerAnimation(second, 'W');
	                if (second) {
	                	
	                	changeScore = false;
	                	
	                }
	                else {
	                	
	                	if (getY() < currentDistance) {
	                		
							changeScore = true;
							currentDistance = getY();
							points+=10;
							
						}
	                	
	                }
	                break;
	                
				case A:
					
					move(-movementX, 0);
					playerAnimation(second, 'A');
	            	break;
	            	
				case S:
					
					move(0, movement);
					playerAnimation(second, 'S');
	            	break;
	            	
				case D:
					
					move(movementX, 0);
					playerAnimation(second, 'D');
	            	break;
					
			}
			
		}
		
	}

	private void playerAnimation(boolean second, char key){
		
		if (second) {
			
			switch(key) {
			
				case 'W':
					setImage(imgW1);
					break;
				case 'A':
					setImage(imgA1);
					break;
				case 'S':
					setImage(imgS1);
					break;
				case 'D':
					setImage(imgD1);
					break;
			}	
			
			this.second = false;
			
		}
		else {
			
			switch(key) {
			
				case 'W':
					setImage(imgW2);
					break;
				case 'A':
					setImage(imgA2);
					break;
				case 'S':
					setImage(imgS2);
					break;
				case 'D':
					setImage(imgD2);
					break;
			}	
			
			this.second = true;
				
		}
		
	}
	
	/**
	 * <p>Method called to check if Player is within game bounds, if Player has any interactions during gameplay, and process such interactions when detected.</p>
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Player to act every game frame.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {

		KeepWithinWindow();
		playerInteraction(now);
		deathProcess(now);
		
	}
	
	private void KeepWithinWindow() {
		
		if (getY()>734) {		
			move(0, -movement*2);
		}
		if (getX()<-20) {
			move(movementX*2, 0);
		}
		if (getX()>580) {
			move(-movementX*2, 0);
		}
		
	}
	
	private void playerInteraction(long now) {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			
			carDeath = true;
			
		}
		if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				
				waterDeath = true;
				
			} 
			else {
				
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(), 0);
				
			}
		}
		else if (getIntersectingObjects(Rideable.class).size() >= 1 && !noMove ) {
			
			move(getIntersectingObjects(Rideable.class).get(0).getSpeed(), 0);
			
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			else {
				
				getIntersectingObjects(End.class).get(0).activate();
				currentDistance = 800;
				
			}
			
			respawn(true);
		}
		else if (getY()<413){
			
			waterDeath = true;
			
		}
		
	}
	
	private void deathProcess(long now) {
		
		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				deathFrame++;
			}
			if (deathFrame==1) {
				setImage(cardeath1);
			}
			if (deathFrame==2) {
				setImage(cardeath2);
			}
			if (deathFrame==3) {
				setImage(cardeath3);
			}
			if (deathFrame == 4) {
				
				respawn(false);
				
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				deathFrame++;
			}
			if (deathFrame==1) {
				setImage(waterdeath1);
			}
			if (deathFrame==2) {
				setImage(waterdeath2);
			}
			if (deathFrame==3) {
				setImage(waterdeath3);
			}
			if (deathFrame == 4) {
				setImage(waterdeath4);
			}
			if (deathFrame == 5) {
				
				respawn(false);
				
			}
		}
		
	}
	
	private void respawn(boolean goalReached) {
		
		if (goalReached) {
				
			points+=50;
			changeScore = true;
			end++;
				
		}
		else {
				
			waterDeath = false;
			carDeath = false;
			deathFrame = 0;
			if (points>50) {
				points-=50;
				changeScore = true;
				
			}
				
		}
		
		noMove = false;
		setX(300);
		setY(706);
		setImage(imgW1);

	}
	
	/**
	 * <p>Get whether level end conditions are met.</p>
	 * @return boolean whether level end conditions are met.
	 */
	public boolean getStop() {
		
		return end==5;
		
	}
	
	/**
	 * <p>Get points acquired by the Player.</p>
	 * @return int of points acquired by the Player.
	 */
	public int getPoints() {
		
		return points;
		
	}
	
	/**
	 * <p>Get whether score change conditions are met.</p>
	 * @return boolean whether score change conditions are met.
	 */
	public boolean changeScore() {
		
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}

}
