package frogger_test.controllers;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import frogger.controllers.GameController;

public class GameControllerTest extends ApplicationTest{
	
	@Test 
	public void gameControllerSingletonFunctioning() throws IOException {
		
		GameController gameController1 = GameController.GameController();
		GameController gameController2 = GameController.GameController();
		assertEquals(gameController1, gameController2);
		
	}
	
}
