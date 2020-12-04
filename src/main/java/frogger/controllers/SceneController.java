package frogger.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import frogger.models.levels.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneController {

	private HashMap<Integer, Pane> sceneMap;
    private Scene scene;

    public SceneController(Scene scene, int numScene) {
    	sceneMap = new HashMap<>(numScene);
        this.scene = scene;
        
    }
    
    public void addScene(Integer sceneNum, Pane pane){
         sceneMap.put(sceneNum, pane);
    }

    public void removeScene(Integer sceneNum){
        sceneMap.remove(sceneNum);
    }

    public void activate(Integer sceneNum){
    	
        scene.setRoot(sceneMap.get(sceneNum));
        
        if (scene.getRoot() instanceof Level) {
        	
            startLevel();
            
        }
        
    }
	
    protected void startLevel() {
    	
    	((Level)scene.getRoot()).start();
    	
    }
    
    protected void stopLevel() {
    	
    	((Level)scene.getRoot()).stop();
    	
    }
    
    protected void changeScene(Integer sceneNum) {
    	
    	if (scene.getRoot() instanceof Level) {
        	
    		stopLevel();
            
        }
    	
    	activate(sceneNum);

    }
    
    protected void resetScenes() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	for (int i = 0; i < sceneMap.size(); i++) {
    		
    		if (sceneMap.get(i) instanceof Level) {
    			
    			Class<? extends Pane> cls = sceneMap.get(i).getClass();
    			sceneMap.replace(i, cls.getDeclaredConstructor().newInstance());
    			
    		}
    		
    	}
    	
    }
	
}
