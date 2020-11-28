package p4_group_8_repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HighScore {

	File scoreList = new File("file:src/main/resources/score/scoreList.txt");
	
	public void writeScore(String username, int score) throws IOException {
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader(scoreList));
		while ((row = csvReader.readLine()) != null) {
		    String[] data = row.split(",");
		    
		}
		csvReader.close();
		
	}
	
}
