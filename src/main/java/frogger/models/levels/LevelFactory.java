package frogger.models.levels;

import java.util.ArrayList;

/**
 * <p>LevelFactory is the factory of {@link frogger.models.levels.Level} concrete subclasses adhering to a modified Factory design pattern.</p>
 * <p>Returns an Arraylist of {@link frogger.models.levels.Level} when {@link #getLevels()} is called.</p>
 */
public class LevelFactory {
	
	/**
	 * Get {@link frogger.models.levels.Level}s of Frogger game.
	 * @return ArrayList of {@link frogger.models.levels.Level}s.
	 */
	public ArrayList<Level> getLevels() {
		
		ArrayList<Level> levelList = new ArrayList<Level>();
		
		levelList.add(new Level1());
		levelList.add(new Level2());
		levelList.add(new Level3());
		levelList.add(new Level4());
		levelList.add(new Level5());
		
		return levelList;
		
	}
	
}
