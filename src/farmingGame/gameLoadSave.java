// [PACKAGE]
package farmingGame;


// [LIBS]
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// [CLASS]
public class gameLoadSave {
	
	// load
	public static ArrayList<String> load(int crop, int current_save) {
		
		ArrayList<String> cropData = new ArrayList<String>();
		
		// attempts to load file
		try {
			
			try (BufferedReader br = new BufferedReader(new FileReader(".\\dataStore\\" + current_save + "\\crop" + crop + ".dat"))) {
				
			    for(String line; (line = br.readLine()) != null;) {

			    	cropData.add(line);
			    	
			    }

			}
			
			return cropData;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cropData;
		
	}

	public static int save(String tag, int crop, int current_save) {
		
		try {
			
			ArrayList<String> data = new ArrayList<String>();
			
			FileReader cropFile = new FileReader(".\\dataStore\\" + current_save + "\\crop" + crop + ".dat");
			
			
			try (BufferedReader br = new BufferedReader(cropFile)) {
				
			    for(String line; (line = br.readLine()) != null;) {
			    	
			    	if (line.startsWith("seed_planted=") && tag.startsWith("seed_planted=")) {
			    		
			    		line = line.replace(line, tag);	
			    		
			    	}
			    	else if (line.startsWith("watered=") && tag.startsWith("watered=")) {
			    		
			    		line = line.replace(line, tag);	
			    		
			    	}
			    	else if (line.startsWith("stage=") && tag.startsWith("stage=")) {
			    		
			    		line = line.replace(line, tag);	
			    		
			    	}
			    	else if (line.startsWith("sick=") && tag.startsWith("sick=")) {
			    		
			    		line = line.replace(line, tag);	
			    		
			    	}

			    	
			    	data.add(line);
						
				}
			    
			    
			    FileWriter cropFileW = new FileWriter(".\\dataStore\\" + current_save + "\\crop" + crop + ".dat");
			    
			    for (String toFile: data) {
					
					cropFileW.write(toFile + System.lineSeparator());
			    
			    }
			    
			    cropFile.close();
			    cropFileW.close();	

			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		// return 0 if save was succesful
		return 0;
	
	} 
	
	
}
