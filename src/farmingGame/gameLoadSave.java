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
			
			System.out.println(cropData);
			return cropData;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cropData;
		
	}

	public static int save(ArrayList<String> data, int crop, int current_save) {
		
		try {
			
			FileWriter cropData = new FileWriter(".\\dataStore\\" + current_save + "\\crop" + crop + ".dat");

			for (String toFile: data) {
				
				cropData.write(toFile + System.lineSeparator());
				
			}
			
			cropData.close();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		// return 0 if save was succesful
		return 0;
	
	} 
	
	
}
