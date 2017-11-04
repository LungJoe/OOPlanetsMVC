package Models;

import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Planet {
	Image planetImage;
	String planetName;
	Double planetDiameterKm;
	Double planetDiameterM;
	Double meanSurfaceTempC;
	Double meanSurfaceTempF;
	int numMoons;

	public Planet(Image planetImage, String planetName, Double planetDiameterKm, Double planetDiameterM, Double meanSurfaceTempC, Double meanSurfaceTempF, int numMoons) {
		this.planetImage = planetImage;
		this.planetName = planetName;
		this.planetDiameterKm = planetDiameterKm;
		this.planetDiameterM = planetDiameterM;
		this.meanSurfaceTempC = meanSurfaceTempC;
		this.meanSurfaceTempF = meanSurfaceTempF;
		this.numMoons = numMoons;
	}

	public void savePlanet() {
		
	}

	public void loadPlanet() {
		
	}
	
	public Image getPlanetImage() {
		return planetImage;
	}

	public void setPlanetImage(Image planetImage) {
		this.planetImage = planetImage;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public Double getPlanetDiameterKm() {
		return planetDiameterKm;
	}

	public void setPlanetDiameterKm(Double planetDiameterKm) {
		this.planetDiameterKm = planetDiameterKm;
	}

	public Double getPlanetDiameterM() {
		return planetDiameterM;
	}

	public void setPlanetDiameterM(Double planetDiameterM) {
		this.planetDiameterM = planetDiameterM;
	}

	public Double getMeanSurfaceTempC() {
		return meanSurfaceTempC;
	}

	public void setMeanSurfaceTempC(Double meanSurfaceTempC) {
		this.meanSurfaceTempC = meanSurfaceTempC;
	}

	public Double getMeanSurfaceTempF() {
		return meanSurfaceTempF;
	}

	public void setMeanSurfaceTempF(Double meanSurfaceTempF) {
		this.meanSurfaceTempF = meanSurfaceTempF;
	}

	public int getNumMoons() {
		return numMoons;
	}

	public StringProperty firstNameProperty() {
		return planetName;
	}
	
	public void setNumMoons(int numMoons) {
		this.numMoons = numMoons;
	}

}
