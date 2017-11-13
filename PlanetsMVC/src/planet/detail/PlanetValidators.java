package planet.detail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;

public class PlanetValidators {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 255;
	
	private static final double MIN_DIAMETER = 0.0;
	private static final double MAX_DIAMETER = 200000.0;
	
	private static final double MIN_DEGREES = -273.15;
	private static final double MAX_DEGREES = 500.0;
	
	private static final int MIN_MOONS  = 0;
	private static final int MAX_MOONS = 1000;
	
	public static boolean validatePlanetname(String planetName){
		Pattern validNameCharacters = Pattern.compile("[^A-Za-z0-9 .-]");
		Matcher invalidName = validNameCharacters.matcher(planetName);
		
		if(	invalidName.find() ||
			planetName.length() < MIN_NAME_LENGTH || 
			planetName.length() > MAX_NAME_LENGTH){
			return false;
		}
		return true;
	}
	
	public static boolean validatePlanetDiameter(String planetDiameter){
		try{
			double intDiameter = Double.parseDouble(planetDiameter);
			if(intDiameter >= MIN_DIAMETER && intDiameter <= MAX_DIAMETER)
				return true;
			return false;
		}catch(Exception e){ return false; }
	}
	
	public static boolean validPlanetTemperature(String planetTemperature){
		try{
	    	Double intTemp = Double.parseDouble(planetTemperature);
	    	if(intTemp >= MIN_DEGREES && intTemp <= MAX_DEGREES)
	    		return true;
	    	return false;
	    }catch(Exception e){return false;}
	}
	
	public static boolean validatePlanetMoons(String planetMoonAmount){
		try{
	    	int intMoonCount = Integer.parseInt(planetMoonAmount);
	    	if(intMoonCount >= MIN_MOONS && intMoonCount <= MAX_MOONS)
	    		return true;
	    	return false;
		}catch(Exception e){ return false;}
	}
}
