package frogger.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *	<p>The class HighScores manages the addition of new High Scores, reading and writing of the High Score file.</p>
 */
public class HighScores{

	private String root = System.getProperty("user.dir");
	private String scoreFile = root+"\\src\\main\\resources\\score\\scoreFile.txt";
	private int maxScores = 10;
	private ArrayList<HighScore> scoreList;
	
	/**
	 * <p>The constructor of HighScores.</p>
	 * <p>Scores saved in High Score file read and stored into ArrayList.</p>
	 * <p>New High Score file created if there is no existing High Score file.</p>
	 */
	public HighScores() {
		
		String line;
		String[] parts;
		int score;
		
		scoreList = new ArrayList<HighScore>(maxScores);
		
		try {
			
			BufferedReader file = new BufferedReader(new FileReader(scoreFile));

			while ((line = file.readLine()) != null) {
				
				parts = line.split("\t", 2);
				
				score = Integer.parseInt(parts[1]);

				scoreList.add(new HighScore(parts[0], score));
				
			}

			file.close();
			
		} catch (IOException e) {
			
			System.err.println("No high score file found, will create new high score file");
			
		}
		
	}
	
	/**
	 * <p>Gets list of High Scores in a string array.</p>
	 * @return String Array of High Scores included with name and score.
	 */
	public String[] getScoreList() {
		
		String[] list = new String[scoreList.size()];
		
		for (int i = 0; i < scoreList.size() ; i++){
			
			list[i] = scoreList.get(i).toString();
			
		}
		
		return list;
		
	}
	
	/**
	 * <p>Inserts new score</p>
	 * <p>Score inserted into arraylist then sorted based on score. If name inserted is empty, score is not inserted.</p>
	 * @param name the name of player.
	 * @param score the score achieved by the player.
	 */
	public void newScore(String name, int score) throws IOException {
		
		if (this.isNewHighScore(score)) {
			
			name = name.trim();
			
			if (!name.isEmpty()) {
				
				add(name, score);
				writeScoreFile();
				
			}

		}
		
	}
	
	private boolean isNewHighScore(int score) {
		
		if(scoreList.size() < 10) {
			
			return true;
			
		}
		
		HighScore lowestHighScores = scoreList.get(scoreList.size() - 1);
		
		if (score < lowestHighScores.score) {
			
			return false;
			
		}
		else { 
		
			return true;
			
		}
	}
	
	private void writeScoreFile() throws IOException {
			
		FileWriter write = new FileWriter(scoreFile);
		PrintWriter out = new PrintWriter(write);

		for (int i = 0; i < scoreList.size() && i < 10; i++){
			
			out.println(scoreList.get(i));
			
		}
			
		out.close();
		
	}
	
	private void add(String name, int score) {
		scoreList.add(new HighScore(name, score));
		int min_element; 
		int temp_score;        
		String temp_name;     
		
		for(min_element = scoreList.size() - 1; min_element >= 0; min_element --) {
			
			for(int i = 0; i <= min_element - 1; i++){
				
				if(scoreList.get(i).score < scoreList.get(i + 1).score) {
					
					temp_score = scoreList.get(i).score;
					scoreList.get(i).score = scoreList.get(i + 1).score;
					scoreList.get(i + 1).score = temp_score;
					
					temp_name = scoreList.get(i).name;
					scoreList.get(i).name = scoreList.get(i + 1).name;
					scoreList.get(i+1).name = temp_name;
					
				}
				
			}
			
		}
		
		if (scoreList.size() > 10) {
			
			for(int i = 10; scoreList.size() > i ; i++)
			
			scoreList.remove(i);
			
		}
		
	}
	
	private static class HighScore {
		
		public String name;
		public int score;

		public HighScore(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String toString() {
			return name + "\t" + score;
		}
		
	}
	
}
