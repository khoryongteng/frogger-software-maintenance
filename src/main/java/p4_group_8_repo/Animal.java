package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean changeScore = false;
	int deathFrame = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/froggerRightJump.png", imgSize, imgSize, true, true);
		keyListener();
		
	}
	
	//Key press detection
	private void keyListener() {
		
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
		ObjectInteraction();
		DeathProcess(now);
		
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
	
	private void ObjectInteraction() {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(LongLog.class).size() >= 1 && !noMove) {
			
			move(getIntersectingObjects(LongLog.class).get(0).getSpeed(), 0);
			
		}
		else if (getIntersectingObjects(ShortLog.class).size() >= 1 && !noMove) {
			
			move(getIntersectingObjects(ShortLog.class).get(0).getSpeed(), 0);
		}
		else if (getIntersectingObjects(MediumLog.class).size() >= 1 && !noMove) {
			
			move(getIntersectingObjects(MediumLog.class).get(0).getSpeed(), 0);
			
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {

			move(getIntersectingObjects(Turtle.class).get(0).getSpeed(), 0);
			
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(), 0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			getIntersectingObjects(End.class).get(0).setEnd();
			respawn(true);
		}
		else if (getY()<413){
			waterDeath = true;
		}
		
	}
	
	private void DeathProcess(long now) {
		
		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				deathFrame++;
			}
			if (deathFrame==1) {
				setImage(new Image("file:src/main/resources/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (deathFrame==2) {
				setImage(new Image("file:src/main/resources/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (deathFrame==3) {
				setImage(new Image("file:src/main/resources/cardeath3.png", imgSize, imgSize, true, true));
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
				setImage(new Image("file:src/main/resources/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (deathFrame==2) {
				setImage(new Image("file:src/main/resources/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (deathFrame==3) {
				setImage(new Image("file:src/main/resources/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (deathFrame == 4) {
				setImage(new Image("file:src/main/resources/waterdeath4.png", imgSize,imgSize , true, true));
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
			setImage(new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true));
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
