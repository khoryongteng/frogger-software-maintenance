package frogger.models;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class HighScores{

	private String root = System.getProperty("user.dir");
	private String scoreFile = root+"\\src\\main\\resources\\score\\scoreFile.txt";
	private int maxScores = 10;
	private ArrayList<HighScore> scoreList;
	
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
	
	public String[] getScoreList() {
		
		String[] list = new String[scoreList.size()];
		
		for (int i = 0; i < scoreList.size() ; i++){
			
			list[i] = scoreList.get(i).toString();
			
		}
		
		return list;
		
	}
	
	public void newScore(String name, int score) throws IOException {
		
		if (this.isNewHighScore(score)) {
			
			name = name.trim();
			
			if (!name.isEmpty()) {
				
				this.add(name, score);
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
