package frogger.models.levels;

import java.util.ArrayList;
import java.util.List;

import frogger.models.actors.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * <p>The abstract class World defines common essential methods of all Frogger Levels.</p>
 * <p>World abstract class contains AnimationTimer which triggers frame by frame actions of {@link frogger.models.actors.Actor}s. World abstract class also defines how {@link frogger.models.actors.Actor}s are added or removed from the Levels.</p>
 * <p>World class cannot be initialized but a World can be initialized through concrete classes that inherits World.</p>
 */
public abstract class World extends Pane {
	
    private AnimationTimer timer;
    
    /**
     * <p>The constructor of World abstract class.</p>
     * <p>Adds a key listener that detects key presses and key releases.</p>
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * <p>Creates an AnimationTimer that calls {@link frogger.models.actors.Actor#act(long)} for all {@link frogger.models.actors.Actor}s added and #{@link World#act(long)}.</p>
     */
    public void createTimer() {
    	
        timer = new AnimationTimer() {
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

    /**
     * <p>Creates an AnimationTimer using {@link #createTimer()} and starts it.</p>
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * <p>Stops the AnimationTimer created.</p>
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * <p>Adds {@link frogger.models.actors.Actor} into the pane.</p>
     * @param actor the {@link frogger.models.actors.Actor} to be added into the pane.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * <p>Removes {@link frogger.models.actors.Actor} from the pane.</p>
     * @param actor the {@link frogger.models.actors.Actor} to be removed from the pane.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * <p>Gets list of {@link frogger.models.actors.Actor}s present in the pane.</p>
     * @param cls the class of {@link frogger.models.actors.Actor} to be filtered and collected.
     * @return list of {@link frogger.models.actors.Actor}s in the pane.
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
    	
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * <p>Method called by AnimationTimer in {@link #createTimer()} to cause World concrete classes to act every game frame.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
    public void act(long now) {
    
    }
    
}
