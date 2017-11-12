package Models;

import Exceptions.InvalidDiameterException;
import Exceptions.InvalidMoonException;
import Exceptions.InvalidNameException;
import Exceptions.InvalidTemperatureException;
import planet.detail.PlanetValidators;
import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Planet{
	PlanetHelper helper = new PlanetHelper();
	static PlanetValidators validate = new PlanetValidators();
	
	Image planetImage;
	SimpleStringProperty planetName;
	SimpleStringProperty filePath;
	SimpleDoubleProperty planetDiameterKm;
	SimpleDoubleProperty planetDiameterM;
	SimpleDoubleProperty meanSurfaceTempC;
	SimpleDoubleProperty meanSurfaceTempF;
	SimpleIntegerProperty numMoons;
	
	public Planet() {
		this.planetName = new SimpleStringProperty();
		this.planetDiameterKm = new SimpleDoubleProperty();
		this.planetDiameterM = new SimpleDoubleProperty();
		this.meanSurfaceTempC = new SimpleDoubleProperty();
		this.meanSurfaceTempF = new SimpleDoubleProperty();
		this.numMoons = new SimpleIntegerProperty();
		
	}
	
	public Planet(PlanetBuilder planetBuilder) {
		this.planetName = planetBuilder.planetName;
		this.planetDiameterKm = planetBuilder.planetDiameterKm;
		this.planetDiameterM = planetBuilder.planetDiameterM;
		this.meanSurfaceTempC = planetBuilder.meanSurfaceTempC;
		this.meanSurfaceTempF = planetBuilder.meanSurfaceTempF;
		this.numMoons = planetBuilder.numMoons;
	}

	public void savePlanet() {
		helper.savePlanet(this);
	}

	public void loadPlanet() {
		helper.loadPlanet(this);
	}

	public Image getPlanetImage() {
		return planetImage;
	}

	public void setPlanetImage(Image planetImage) {
		this.planetImage = planetImage;
	}

	public void setPlanetName(String planetName) {
		if (!PlanetValidators.validatePlanetname(planetName))
			throw new InvalidNameException();
		this.planetName.setValue(planetName);
	}

	public void setPlanetDiameterKm(String diameter) {
	    if(!PlanetValidators.validatePlanetDiameter(diameter)) 
	    	throw new InvalidDiameterException();
		this.planetDiameterKm.setValue(Double.parseDouble(diameter));
		setPlanetDiameterM();
	}

	public void setPlanetDiameterM() {
		this.planetDiameterM.setValue(this.planetDiameterKm.getValue()*0.621371);
	}

	public void setPlanetSurfaceTempC(String celcius) {
	    	if(!PlanetValidators.validPlanetTemperature(celcius)) 
	    		throw new InvalidTemperatureException();
	    	this.meanSurfaceTempC.setValue(Double.parseDouble(celcius));
	    	setPlanetSurfaceTempF();
	}

	public void setPlanetSurfaceTempF() {
		this.meanSurfaceTempF.setValue((this.meanSurfaceTempC.getValue() * (9.0/5.0)) + 32);
	}

	public void setNumMoons(String moonCount) {
	    if(!PlanetValidators.validatePlanetMoons(moonCount))
		throw new InvalidMoonException();
		this.numMoons.setValue(Integer.parseInt(moonCount));
	}

	public String getPlanetName() {
		return planetName.getValue();
	}

	public Double getPlanetDiameterKm() {
		return planetDiameterKm.getValue();
	}

	public Double getPlanetDiameterM() {
		return planetDiameterM.getValue();
	}

	public Double getPlanetSurfaceTempC() {
		return meanSurfaceTempC.getValue();
	}

	public Double getPlanetSurfaceTempF() {
		return meanSurfaceTempF.getValue();
	}

	public int getNumMoons() {
		return numMoons.getValue();
	}

	public boolean isValidName(String name) {
	    	if(name.matches("^[a-zA-Z0-9 .-]+") && name.length() > 0 && name.length() < 256)
	    	    return true;
		return false;
	}

	public StringProperty firstNameProperty() {	return planetName; }

	public DoubleProperty diameterKMProperty() { return planetDiameterKm; }
	
	public DoubleProperty diameterMProperty() { return planetDiameterM;	}

	public DoubleProperty tempCProperty() { return meanSurfaceTempC; }
	
	public DoubleProperty tempFProperty() { return meanSurfaceTempF; } 
	
	public IntegerProperty numMoonsProperty(){ return numMoons;	}
	
	public void printData(){
		System.out.println(planetName + " " + planetDiameterM + " " + planetDiameterKm);
	}

	public static class PlanetBuilder{
		
		private	Image planetImage;
		private SimpleStringProperty planetName = new SimpleStringProperty();
		private SimpleStringProperty filePath = new SimpleStringProperty();
		private SimpleDoubleProperty planetDiameterKm = new SimpleDoubleProperty();
		private SimpleDoubleProperty planetDiameterM = new SimpleDoubleProperty();
		private SimpleDoubleProperty meanSurfaceTempC = new SimpleDoubleProperty();
		private SimpleDoubleProperty meanSurfaceTempF = new SimpleDoubleProperty();
		private SimpleIntegerProperty numMoons = new SimpleIntegerProperty();
		
		public PlanetBuilder(String planetName){
			if (!PlanetValidators.validatePlanetname(planetName))
				throw new InvalidNameException();
			this.planetName.setValue(planetName);
		}
		
		public PlanetBuilder setPlanetDiameter(String planetDiameter){
		    if(!PlanetValidators.validatePlanetDiameter(planetDiameter)) 
		    	throw new InvalidDiameterException();
			this.planetDiameterKm.setValue(Double.parseDouble(planetDiameter));
			this.planetDiameterM.setValue(this.planetDiameterKm.getValue()*0.621371);
			return this;
		}
		
		public PlanetBuilder setPlanetTemperature(String planetTemperature){
	    	if(!PlanetValidators.validPlanetTemperature(planetTemperature)) 
	    		throw new InvalidTemperatureException();
	    	this.meanSurfaceTempC.setValue(Double.parseDouble(planetTemperature));
			this.meanSurfaceTempF.setValue((this.meanSurfaceTempC.getValue() * (9.0/5.0)) + 32);
			return this;
		}
		
		public PlanetBuilder setNumberOfMoons(String planetMoonCount){
		    if(!PlanetValidators.validatePlanetMoons(planetMoonCount))
				throw new InvalidMoonException();
			this.numMoons.setValue(Integer.parseInt(planetMoonCount));
			return this;
		}
		
		public Planet build(){
			return new Planet(this);
		}
	}
}
