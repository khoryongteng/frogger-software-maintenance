package frogger_test.testclassresource;

import java.util.List;

import frogger.models.actors.Actor;
import frogger.models.levels.World;
import javafx.animation.AnimationTimer;

public class DummyLevel extends World{

	
	/*
	private AnimationTimer timer;
	
	@Override
	public void createTimer() {
        timer = new AnimationTimer() {
        	
        	private long startTime;
        	
        	@Override
            public void start() {
                startTime = System.currentTimeMillis();
                super.start();
            }

            @Override
            public void handle(long timestamp) {
                long now = System.currentTimeMillis();
                time.set((now - startTime) / 1000.0);
            }
        	
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
            }
        };
    }

	@Override
    public void start() {
    	createTimer();
        timer.start();
    }

	@Override
    public void stop() {
        timer.stop();
    }
	*/
}
