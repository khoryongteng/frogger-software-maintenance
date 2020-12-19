package frogger.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import frogger.models.levels.Level;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *	<p>The class SceneController manages the scene in the Frogger game.</p>
 * 	<p>Methods in SceneController used to add and remove {@link frogger.models.levels.Level} panes and user interface panes as well as switch between them as scenes.</p>	
 */
public class SceneController {

	private HashMap<Integer, Pane> sceneMap = new HashMap<>();
    private Scene scene;

    /**
     * <p>The Constructor of SceneController.</p>
     * @param scene the instance of Scene used for display.
     */
    public SceneController(Scene scene) {

        this.scene = scene;
        
    }
    
    /**
     * <p>Adds panes into sceneMap HashMap with key.</p>
     * @param sceneNum the key for pane added into sceneMap HashMap.
     * @param pane the pane to be added into sceneMap HashMap.
     */
    public void addScene(Integer sceneNum, Pane pane){
         sceneMap.put(sceneNum, pane);
    }

    
    /**
     * <p>Remove panes from sceneMap HashMap using key.</p>
     * @param sceneNum the key for pane to be removed from sceneMap HashMap.
     */
    public void removeScene(Integer sceneNum){
        sceneMap.remove(sceneNum);
    }

    /**
     * <p>Set the pane chosen from sceneMap HashMap to be set as scene displayed.</p>
     * @param sceneNum the key for pane in sceneMap HashMap to be set as scene displayed.
     */
    public void activate(Integer sceneNum){
    	
        scene.setRoot(sceneMap.get(sceneNum));
        
        if (isLevel(scene.getRoot())) {
        	
            startLevel();
            
        }
        
    }
	
    /**
     * <p>Start the {@link frogger.models.levels.Level} currently displayed.</p>
     */
    protected void startLevel() {
    	
    	((Level)scene.getRoot()).start();
    	
    }
    
    /**
     * <p>Stop the {@link frogger.models.levels.Level} currently displayed.</p>
     */
    protected void stopLevel() {
    	
    	((Level)scene.getRoot()).stop();
    	
    }
    
    /**
     * <p>Changes the scene to the pane chosen from sceneMap HashMap.</p>
     * <p>Stops {@link frogger.models.levels.Level} if current scene is instance of {@link frogger.models.levels.Level}. </p>
     * @param sceneNum the key for pane in sceneMap HashMap changed to.
     */
    protected void changeScene(Integer sceneNum) {
    	
    	if (isLevel(scene.getRoot())) {
        	
    		stopLevel();
            
        }
    	
    	activate(sceneNum);

    }
    
    /**
     * <p>Resets {@link frogger.models.levels.Level} present in sceneMap HashMap.</p>
     */
    protected void resetScenes() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	for (int i = 0; i < sceneMap.size(); i++) {
    		
    		if (isLevel(sceneMap.get(i))) {
    			
    			Class<? extends Pane> cls = sceneMap.get(i).getClass();
    			sceneMap.replace(i, cls.getDeclaredConstructor().newInstance());
    			
    		}
    		
    	}
    	
    }
    
    /**
     * <p>Get key of first {@link frogger.models.levels.Level} in sceneMap HashMap.</p>
     * @return int of key of first {@link frogger.models.levels.Level} in sceneMap HashMap.
     */
    protected int getFirstLevel() {
    	
    	int i;
    	
    	for (i = 0;i < sceneMap.size(); i++) {
    		
    		if (isLevel(sceneMap.get(i))) {
    			
    			return i;
    			
    		}
    		
    	}
    	
    	return -1;
    	
    }

    private boolean isLevel(Parent parent) {
    	
    	return (parent instanceof Level);
    	
    }
	
}
