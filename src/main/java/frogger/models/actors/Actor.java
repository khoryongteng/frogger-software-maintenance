package frogger.models.actors;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

import frogger.models.levels.World;

/**
 * <p>The abstract class Actor defines common methods of all Actors which are its subclasses.</p>
 * <p>Actor subclasses are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of an Actor in the level.</p>
 * <p>Actor class cannot be initialized but an Actor can be initialized through concrete classes that inherits Actor.</p>
 */
public abstract class Actor extends ImageView{

	/**
	 * <p>Moves the Actor by dx amount on its x-axis and dy amount on its y-axis.</p>
	 * @param dx amount to move on Actor's x-axis.
	 * @param dy amount to move on Actor's y-axis.
	 */
    protected void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * <p>Get other Actors intersecting current Actor specified by Actor class or Actor subclasses.</p>
     * @param cls The Actor class or Actor subclass to detect if it intersects current Actor.
     * @return An Actor list of all detected Actor or Actor subclass specified by cls.
     */
    protected <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    private World getWorld() {
        return (World) getParent();
    }
    
    /**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Actors to act every game frame.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
    public void act(long now) {
    	
    }

}
