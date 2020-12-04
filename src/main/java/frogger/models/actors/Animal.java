package frogger.models.actors;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int deathFrame = 0;
	private double w = 800;
	
	public Animal() {
		
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/main/resources/images/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/images/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/images/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/images/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/images/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/images/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/images/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/images/froggerRightJump.png", imgSize, imgSize, true, true);
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
	
	//Player Controls
	private void playerControls(KeyEvent event) {
		
		if (noMove) {
			
		}
		else {
			
			switch (event.getCode()) {
			
				case W: 
					move(0, -movement);
	                animalAnimation(second, 'W');
	                if (second) {
	                	
	                	changeScore = false;
	                	
	                }
	                else {
	                	
	                	if (getY() < w) {
	                		
							changeScore = true;
							w = getY();
							points+=10;
							
						}
	                	
	                }
	                break;
	                
				case A:
					move(-movementX, 0);
					animalAnimation(second, 'A');
	            	break;
	            	
				case S:
					move(0, movement);
					animalAnimation(second, 'S');
	            	break;
	            	
				case D:
					move(movementX, 0);
					animalAnimation(second, 'D');
	            	break;
					
			}
			
		}
		
	}
	
	//Animation
	private void animalAnimation(boolean second, char key){
		
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
	
	//Method called every tick when AnimationTimer is running
	@Override
	public void act(long now) {

		KeepWithinWindow();
		objectInteraction();
		deathProcess(now);
		
	}
	
	private void KeepWithinWindow() {
		
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
		
	}
	
	private void objectInteraction() {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				
				//waterDeath = true;
				
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
			
			getIntersectingObjects(End.class).get(0).setEnd();
			respawn(true);
		}
		else if (getY()<413){
			
			//waterDeath = true;
			
		}
		
	}
	
	private void deathProcess(long now) {
		
		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				deathFrame++;
			}
			if (deathFrame==1) {
				setImage(new Image("file:src/main/resources/images/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (deathFrame==2) {
				setImage(new Image("file:src/main/resources/images/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (deathFrame==3) {
				setImage(new Image("file:src/main/resources/images/cardeath3.png", imgSize, imgSize, true, true));
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
				setImage(new Image("file:src/main/resources/images/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (deathFrame==2) {
				setImage(new Image("file:src/main/resources/images/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (deathFrame==3) {
				setImage(new Image("file:src/main/resources/images/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (deathFrame == 4) {
				setImage(new Image("file:src/main/resources/images/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (deathFrame == 5) {
				
				respawn(false);
				
			}
		}
		
	}
	
	private void respawn(boolean goalReached) {
		
		setX(300);
		setY(679.8+movement);
		
		if (goalReached) {
			
			points+=50;
			changeScore = true;
			w=800;
			end++;
			
		}
		else {
			
			waterDeath = false;
			carDeath = false;
			deathFrame = 0;
			setImage(new Image("file:src/main/resources/images/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
			
		}
	}
	
	//Determine if game end conditions are met
	public boolean getStop() {
		return end==5;
	}
	
	//Return points acquired by player
	public int getPoints() {
		return points;
	}
	
	//Return true if score displayed should be changed
	public boolean changeScore() {
		
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
