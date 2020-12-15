package frogger.models.levels;

import java.util.ArrayList;

public class LevelFactory {
	
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
