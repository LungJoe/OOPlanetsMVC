package planet.detail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlanetValidators {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 255;
	
	private static final double MIN_DIAMETER = 0;
	private static final double MAX_DIAMETER = 200_000;
	
	private static final double MIN_DEGREES = -273.15;
	private static final double MAX_DEGREES = 500.0;
	
	private static final int MIN_MOONS  = 0;
	private static final int MAX_MOONS = 1_000;
	
	public static boolean validatePlanetname(SimpleStringProperty planetName){
		Pattern validNameCharacters = Pattern.compile("[^A-Za-z0-9 .-]");
		Matcher invalidName = validNameCharacters.matcher(planetName.get());
		
		if(invalidName.find()){
			return false;
		}
		if(planetName.get().length() < MIN_NAME_LENGTH || planetName.get().length() > MAX_NAME_LENGTH){
			return false;
		}
		return true;
	}
	
	public static boolean validatePlanetDiameter(SimpleDoubleProperty planetDiameter){
		if(planetDiameter.get() <= MIN_DIAMETER || planetDiameter.get() > MAX_DIAMETER){
			return false;
		}
		return true;
	}
	
	public static boolean validPlanetTemperature(SimpleDoubleProperty planetTemperature){
		if(planetTemperature.get() < MIN_DEGREES || planetTemperature.get() > MAX_DEGREES){
			return false;
		}
		return true;
	}
	
	public static boolean validatePlanetMoons(SimpleIntegerProperty planetMoonAmount){
		if(planetMoonAmount.get() < MIN_MOONS || planetMoonAmount.get() > MAX_MOONS){
			return false;
		}
		return true;
	}
	
	
}
