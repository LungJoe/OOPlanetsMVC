package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PlanetHelper{
	private static final String COMMA_DELIMITER = ",";
	
	public ArrayList<String> convertPlanetDataToArrayList(Planet planet){
		ArrayList<String> planetData = new ArrayList<String>();
		planetData.add(planet.getPlanetName());
		planetData.add(Double.toString(planet.getPlanetDiameterKm()));
		planetData.add(Double.toString(planet.getPlanetDiameterM()));
		planetData.add(Double.toString(planet.getPlanetSurfaceTempC()));
		planetData.add(Double.toString(planet.getPlanetSurfaceTempF()));
		planetData.add(Integer.toString(planet.getNumMoons()));
		planetData.add(planet.getImageFilePath());
		return planetData;
	}
	
	private void updatePlanetObject(Planet planet, String[] data){	
		planet.setPlanetName(data[0]);
		planet.setPlanetDiameterKm(data[1]);
		planet.setPlanetDiameterM();
		planet.setPlanetSurfaceTempC(data[3]);
		planet.setPlanetSurfaceTempF();
		planet.setNumMoons(data[5]);
		planet.setImageFilePath(data[6]);
	}
	
	public void savePlanet(Planet planet){
		ArrayList<String> planetData = convertPlanetDataToArrayList(planet);
		FileWriter writer;
		File file = new File("PlanetFile.csv");
		
		try {
			writer = new FileWriter(file);

			for(int i = 0; i < planetData.size(); i++){
				writer.append(planetData.get(i));
				if(i != planetData.size() -1)
					writer.append(COMMA_DELIMITER);
			}
			writer.flush();
			writer.close();
		}catch(Exception e){}
	}
	
	public void loadPlanet(Planet planet){
		String[] planetData; 
		BufferedReader reader;
		String line;
		
		try{
			reader = new BufferedReader(new FileReader("PlanetFile.csv"));
			line = reader.readLine();
			planetData = line.split(COMMA_DELIMITER);
			reader.close();			
			updatePlanetObject(planet, planetData);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
