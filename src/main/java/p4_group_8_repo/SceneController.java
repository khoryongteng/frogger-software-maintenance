package p4_group_8_repo;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneController {

	private HashMap<Integer, Pane> screenMap;
    private Scene scene;

    public SceneController(Scene scene, int numScene) {
    	screenMap = new HashMap<>(numScene);
        this.scene = scene;
        
    }
    
    protected void addScene(Integer sceneNum, Pane pane){
         screenMap.put(sceneNum, pane);
    }

    protected void removeScene(Integer sceneNum){
        screenMap.remove(sceneNum);
    }

    protected void activate(Integer sceneNum){
    	
        scene.setRoot(screenMap.get(sceneNum));
        
        if (scene.getRoot() instanceof Level) {
        	
            startLevel();
            
        }
        
    }
	
    public void startLevel() {
    	
    	((Level)scene.getRoot()).start();
    	
    }
    
    public void stopLevel() {
    	
    	((Level)scene.getRoot()).stop();
    	
    }
    
    public void changeScene(Integer sceneNum) {
    	
    	if (scene.getRoot() instanceof Level) {
        	
    		stopLevel();
            
        }
    	
    	activate(sceneNum);

    }
    
    public void resetScenes() {
    	
    	for (int i = 0; i < screenMap.size(); i++) {
    		
    		if (screenMap.get(i) instanceof Level1) {
    			
    			screenMap.replace(i, new Level1());
    			
    		}
    		if (screenMap.get(i) instanceof Level2) {
    			
    			screenMap.replace(i, new Level2());
    			
    		}
    		
    	}
    	
    }
	
}
