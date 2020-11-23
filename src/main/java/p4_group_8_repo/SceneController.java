package p4_group_8_repo;

import java.util.HashMap;

import javafx.scene.Scene;

public class SceneController extends World {

	private HashMap<Integer, World> screenMap;
    private Scene scene;

    public SceneController(Scene scene, int numLevels) {
    	screenMap = new HashMap<>(numLevels);
        this.scene = scene;
    }

    protected void addScene(Integer levelnum, World world){
         screenMap.put(levelnum, world);
    }

    protected void removeScene(Integer levelnum){
        screenMap.remove(levelnum);
    }

    protected void activate(Integer levelnum){
        scene.setRoot(screenMap.get(levelnum));
        startScene();
    }
	
    public void startScene() {
    	
    	((World)scene.getRoot()).start();
    	
    }
    
    public void stopScene() {
    	
    	((World)scene.getRoot()).stop();
    	
    }
    
    public void changeScene(Integer levelnum) {
    	
    	activate(levelnum);
    	
    	
    }
    
	@Override
	public void act(long now) {

		
	}	
	
}
