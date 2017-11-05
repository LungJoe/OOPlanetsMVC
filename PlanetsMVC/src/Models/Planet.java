package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
	
	public Planet(String planetName, Double planetDiameterKm, Double planetDiameterM, Double meanSurfaceTempC, Double meanSurfaceTempF, int numMoons) {
		this.planetName = new SimpleStringProperty();
		this.planetDiameterKm = new SimpleDoubleProperty();
		this.planetDiameterM = new SimpleDoubleProperty();
		this.meanSurfaceTempC = new SimpleDoubleProperty();
		this.meanSurfaceTempF = new SimpleDoubleProperty();
		this.numMoons = new SimpleIntegerProperty();

		setPlanetName(planetName);
		setPlanetDiameterKm(planetDiameterKm);
		setPlanetDiameterM(planetDiameterM);
		setPlanetSurfaceTempC(meanSurfaceTempC);
		setPlanetSurfaceTempF(meanSurfaceTempF);
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

	public void setPlanetDiameterKm(Double diameter) {
		this.planetDiameterKm.setValue(diameter);
	}

	public void setPlanetDiameterM(Double diameter) {
		this.planetDiameterM.setValue(diameter);
	}

	public void setPlanetSurfaceTempC(Double celcius) {
		this.meanSurfaceTempC.setValue(celcius);
	}

	public void setPlanetSurfaceTempF(Double fahrenheit) {
		this.meanSurfaceTempF.setValue(fahrenheit);
	}

	public void setNumMoons(int moonCount) {
		this.numMoons.setValue(moonCount);
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
	    	System.out.println(name);
	    	if(name.matches("^[a-zA-Z0-9 .-]+") && name.length() > 0 && name.length() < 256)
	    	    return true;
		return false;
	}

	public StringProperty firstNameProperty() {
		return planetName;
	}

}
