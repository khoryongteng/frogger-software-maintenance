package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class Digit is a changeable {@link frogger.models.actors.Actor} that shows a number between 0-9.</p>
 * <p>Digit is added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Digit in the level.</p>
 */
public class Digit extends Actor {

	private Image[] number = new Image[10];
	
	/**
	 * <p>The constructor of Digit.</p>
	 * @param n the number to be displayed, between 0-9.
	 * @param dimensions the size of Digit to be displayed.
	 * @param x the position of Digit on the x-axis.
	 * @param y the position of DIgit on the y-axis.
	 */
	public Digit(int n, int dimensions, int x, int y) {
		
		number[0] = new Image("file:src/main/resources/images/0.png", dimensions, dimensions, true, true);
		number[1] = new Image("file:src/main/resources/images/1.png", dimensions, dimensions, true, true);
		number[2] = new Image("file:src/main/resources/images/2.png", dimensions, dimensions, true, true);
		number[3] = new Image("file:src/main/resources/images/3.png", dimensions, dimensions, true, true);
		number[4] = new Image("file:src/main/resources/images/4.png", dimensions, dimensions, true, true);
		number[5] = new Image("file:src/main/resources/images/5.png", dimensions, dimensions, true, true);
		number[6] = new Image("file:src/main/resources/images/6.png", dimensions, dimensions, true, true);
		number[7] = new Image("file:src/main/resources/images/7.png", dimensions, dimensions, true, true);
		number[8] = new Image("file:src/main/resources/images/8.png", dimensions, dimensions, true, true);
		number[9] = new Image("file:src/main/resources/images/9.png", dimensions, dimensions, true, true);
		
		setImage(number[n]);
		setX(x);
		setY(y);
		
	}
	
	/**
	 * <p>Set the Digit to display between the numbers 0-9</p>
	 * @param n The number to be displayed.
	 */
	public void setDigit(int n) {
		
		setImage(number[n]);
		
	}

}
