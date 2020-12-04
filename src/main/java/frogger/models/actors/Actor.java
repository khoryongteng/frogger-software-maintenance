package frogger.models.actors;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

import frogger.models.levels.World;


public abstract class Actor extends ImageView{

    protected void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

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
    
    public abstract void act(long now);

}
