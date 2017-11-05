package Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;

public class Planet {
	Image planetImage;
	SimpleStringProperty planetName;
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
	
	public Planet(String planetName, Double planetDiameterKm, Double planetDiameterM, Double meanSurfaceTempC, Double meanSurfaceTempF, String numMoons) {
		this.planetName = new SimpleStringProperty();
		this.planetDiameterKm = new SimpleDoubleProperty();
		this.planetDiameterM = new SimpleDoubleProperty();
		this.meanSurfaceTempC = new SimpleDoubleProperty();
		this.meanSurfaceTempF = new SimpleDoubleProperty();
		this.numMoons = new SimpleIntegerProperty();

		setPlanetName(planetName);
		setPlanetDiameterKm(planetDiameterKm.toString());
		setPlanetDiameterM();
		setPlanetSurfaceTempC(meanSurfaceTempC.toString());
		setPlanetSurfaceTempF();
		setNumMoons(numMoons);

	}

	public void savePlanet() {
		//TODO
	}

	public void loadPlanet() {
		//TODO
	}

	public Image getPlanetImage() {
		return planetImage;
	}

	public void setPlanetImage(Image planetImage) {
		this.planetImage = planetImage;
	}

	public void setPlanetName(String planetName) {
		if (!isValidName(planetName))
			throw new InvalidPlanetException("Invalid Planet Name");
		this.planetName.setValue(planetName);
	}

	public void setPlanetDiameterKm(String diameter) {
	    if(!isValidDiameterKM(diameter)) 
		throw new InvalidPlanetException("Invalid Planet Diameter in KM");
		this.planetDiameterKm.setValue(Integer.parseInt(diameter));
		setPlanetDiameterM();
	}


	public void setPlanetDiameterM() {
		this.planetDiameterM.setValue(this.planetDiameterKm.getValue()*0.621371);
	}

	public void setPlanetSurfaceTempC(String celcius) {
	    	if(!isValidTempC(celcius)) 
			throw new InvalidPlanetException("Invalid Planet Temperature in C");
	    	this.meanSurfaceTempC.setValue(Double.parseDouble(celcius));
	    	setPlanetSurfaceTempF();
	}

	public void setPlanetSurfaceTempF() {
		this.meanSurfaceTempF.setValue((this.meanSurfaceTempC.getValue() * (9.0/5.0)) + 32);
	}

	public void setNumMoons(String moonCount) {
	    if(!isValidNumMoons(moonCount))
		throw new InvalidPlanetException("Invalid Number of Moons");
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
	
	private boolean isValidDiameterKM(String diameter) {
	    if(diameter.matches("^[0-9]+")) {
		int intDiameter = Integer.parseInt(diameter);
		if(intDiameter >= 0 && intDiameter <= 200000)
		    return true;
	    }
	    return false;
	}
	
	private boolean isValidTempC(String temperature) {
	    if(temperature.matches("^[0-9]+")) {
		Double intTemp = Double.parseDouble(temperature);
		if(intTemp >= -273.15 && intTemp <= 500.0)
		    return true;
	    }
	    return false;
	}
	
	private boolean isValidNumMoons(String numMoons) {
	    if(numMoons.matches("^[0-9]+")) {
		int intMoonCount = Integer.parseInt(numMoons);
		if(intMoonCount >= 0 && intMoonCount <= 1000)
		    return true;
	    }
	    return false;
	}

	public StringProperty firstNameProperty() {
		return planetName;
	}

	public DoubleProperty diameterMProperty() {
	    return planetDiameterM;
	}

	public DoubleProperty tempFProperty() {
	    return meanSurfaceTempF;
	}

}
