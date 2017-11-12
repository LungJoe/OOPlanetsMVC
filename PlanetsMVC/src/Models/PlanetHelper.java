package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Exceptions.ExceptionHandler;





public class PlanetHelper{
	private static final String COMMA_DELIMITER = ",";
	private ExceptionHandler handler = new ExceptionHandler();
	
	
	public ArrayList<String> convertPlanetDataToArrayList(Planet planet){
		ArrayList<String> planetData = new ArrayList<String>();
		planetData.add(planet.getPlanetName());
		planetData.add(Double.toString(planet.getPlanetDiameterKm()));
		planetData.add(Double.toString(planet.getPlanetDiameterM()));
		planetData.add(Double.toString(planet.getPlanetSurfaceTempC()));
		planetData.add(Double.toString(planet.getPlanetSurfaceTempF()));
		planetData.add(Integer.toString(planet.getNumMoons()));
		//filepath to image goes here.
		//planetData.add();
		
		return planetData;
	}
	private void updatePlanetObject(Planet planet, String[] data){
		
		planet.setPlanetName(data[0]);
		planet.setPlanetDiameterKm(data[1]);
		System.out.println("Set km to: " + planet.getPlanetDiameterKm());
		planet.setPlanetDiameterM();
		planet.setPlanetSurfaceTempC(data[3]);
		planet.setPlanetSurfaceTempF();
		planet.setNumMoons(data[5]);
		
	}
	
	private void printPlanetData(String[] str){
		for(int i = 0; i < str.length; i++){
			System.out.println(str[i]);
		}
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
			System.out.println("File updated");
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
			printPlanetData(planetData);
			reader.close();
			
			updatePlanetObject(planet, planetData);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
