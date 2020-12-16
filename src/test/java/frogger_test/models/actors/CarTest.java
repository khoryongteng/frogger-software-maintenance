package frogger_test.models.actors;


import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import javafx.scene.Scene;
import frogger_test.testclassresource.DummyLevel;
import frogger.models.actors.Car;



public class CarTest extends ApplicationTest{

	private int x = 0;
	private int y = 0;
	private double speed = 1;
	private DummyLevel dummyLevel = new DummyLevel();
	private Car car;
	
	@Override
	public void start(Stage stage) {
		
		car = new Car(x, y, speed);
		dummyLevel.add(car);
		stage.setScene(new Scene(dummyLevel, 600, 800));
		stage.show();
		
	}
	
	@Test
	public void hasCorrectX() {
		
		assertTrue(x ==  car.getX());
		
	}
	
	@Test
	public void hasCorrectY() {
		
		assertTrue(y ==  car.getY());
		
	}
	
}
