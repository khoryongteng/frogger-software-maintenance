package p4_group_8_repo;

import java.util.HashMap;

import javafx.scene.Scene;

public class SceneController {

	private HashMap<Integer, World> screenMap;
    private Scene scene;
    private GameView gameView;

    public SceneController(Scene scene, int numLevels, GameView gameView) {
    	screenMap = new HashMap<>(numLevels);
        this.scene = scene;
        this.gameView = gameView;
    }

    protected void addScene(Integer levelnum, World world){
         screenMap.put(levelnum, world);
    }

    protected void removeScene(Integer levelnum){
        screenMap.remove(levelnum);
    }

    protected void activate(Integer levelnum){
    	
        scene.setRoot(screenMap.get(levelnum));
        gameView.setKeyListener(scene);
        startScene();
        
    }
	
    public void startScene() {
    	
    	((World)scene.getRoot()).start();
    	
    }
    
    public void stopScene() {
    	
    	((World)scene.getRoot()).stop();
    	
    }
    
    public void changeScene(Integer levelnum) {
    	
    	stopScene();
    	activate(levelnum);

    }
	
}
