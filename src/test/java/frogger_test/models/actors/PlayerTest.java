package frogger_test.models.actors;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.api.FxRobot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import frogger.models.actors.End;
import frogger.models.actors.Player;
import frogger_test.testclassresource.DummyLevel;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class PlayerTest extends ApplicationTest{

	private Player player;
	private DummyLevel level = new DummyLevel();
	private double initialX;
	private double initialY;
	private FxRobot robot = new FxRobot();
	
	@Override
	public void start(Stage stage) {
		
		
		
		player = new Player();
		level.add(player);
		initialX = player.getX();
		initialY = player.getY();
		stage.setScene(new Scene(level, 600, 800));
		stage.show();
		
	}
	
	@Test
	public void whenButtonWPressedReleasedMoveUp() {
		
		robot.press(KeyCode.getKeyCode("W"));
		robot.release(KeyCode.getKeyCode("W"));
		assertTrue(player.getY() < initialY);
		
	}
	
	@Test
	public void whenButtonAPressedReleasedMoveLeft() {
		
		robot.press(KeyCode.getKeyCode("A"));
		robot.release(KeyCode.getKeyCode("A"));
		assertTrue(player.getX() < initialX);
		
	}
	
	@Test
	public void whenButtonSPressedReleasedMoveDown() {
		
		robot.press(KeyCode.getKeyCode("S"));
		robot.release(KeyCode.getKeyCode("S"));
		assertTrue(player.getY() > initialY);
		
	}
	
	@Test
	public void whenButtonDPressedReleasedMoveRight() {
		
		robot.press(KeyCode.getKeyCode("D"));
		robot.release(KeyCode.getKeyCode("D"));
		assertTrue(player.getY() > initialX);
		
	}
	
	
	@Test
	public void canKeepWithinLeftBound() {
		
		while(player.getX() >= -20) {

			robot.press(KeyCode.getKeyCode("A"));
			robot.release(KeyCode.getKeyCode("A"));
			
		}
		level.start();
		assertFalse(player.getX() >= -20);
	}
	
	@Test
	public void canKeepWithinBottomBound() {
		
		while(player.getY() <= 734) {

			robot.press(KeyCode.getKeyCode("S"));
			robot.release(KeyCode.getKeyCode("S"));
			
		}
		level.start();
		assertFalse(player.getY() <= 734);
	}
	
	@Test
	public void canKeepWithinRightBound() {
		
		while(player.getX() <= 580) {

			robot.press(KeyCode.getKeyCode("D"));
			robot.release(KeyCode.getKeyCode("D"));
			
		}
		level.start();
		assertFalse(player.getX() <= 580);
	}

	@Test
	public void pointIncreaseWhenMoveUp() {
		
		robot.press(KeyCode.getKeyCode("W"));
		robot.release(KeyCode.getKeyCode("W"));
		assertTrue(player.getPoints() > 0);
		
	}
	
	@Test
	public void scoreChangeDetectionWhenMoveUp() {
		
		robot.press(KeyCode.getKeyCode("W"));
		robot.release(KeyCode.getKeyCode("W"));
		assertTrue(player.changeScore());
		
	}
	
}
