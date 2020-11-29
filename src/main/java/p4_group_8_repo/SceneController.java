package p4_group_8_repo;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneController {

	private HashMap<Integer, Pane> screenMap;
    private Scene scene;

    public SceneController(Scene scene) {
    	screenMap = new HashMap<>();
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
        
        if (scene.getRoot() instanceof World) {
        	
            startLevel();
            
        }
        
    }
	
    public void startLevel() {
    	
    	((World)scene.getRoot()).start();
    	
    }
    
    public void stopLevel() {
    	
    	((World)scene.getRoot()).stop();
    	
    }
    
    public void changeScene(Integer sceneNum) {
    	
    	if (scene.getRoot() instanceof World) {
        	
    		stopLevel();
            
        }
    	
    	activate(sceneNum);

    }
	
}
