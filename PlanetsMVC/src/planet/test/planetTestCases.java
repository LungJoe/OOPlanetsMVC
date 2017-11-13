package planet.test;

import planet.detail.PlanetValidators;
import static org.junit.Assert.*;
import org.junit.Test;
import Models.Planet;

public class planetTestCases {
	
	@Test
	public void testValidName(){
		assertEquals(true, PlanetValidators.validatePlanetname("Neptune"));
	}
	
	@Test
	public void testInvalidName(){
		assertEquals(false, PlanetValidators.validatePlanetname("?"));
	}
	
	@Test
	public void testValidDiameter(){
		assertEquals(true, PlanetValidators.validatePlanetDiameter("1"));
	}
	
	@Test
	public void testInvalidDiameter(){
		assertEquals(false, PlanetValidators.validatePlanetDiameter("-1"));
	}

	@Test
	public void testValidTemperature(){
		assertEquals(true, PlanetValidators.validPlanetTemperature("20"));
	}

	@Test
	public void testInvalidTemperature(){
		assertEquals(false, PlanetValidators.validPlanetTemperature("-2000"));
	}

	@Test
	public void testValidMoonCount(){
		assertEquals(true, PlanetValidators.validatePlanetMoons("1"));
	}
	
	@Test
	public void testInvalidMoonCount(){
		assertEquals(false,PlanetValidators.validatePlanetMoons("-5"));
	}
	
	@Test
	public void testLoadPlanet(){
		Planet planet = new Planet();
		planet.loadPlanet();
		Planet testingPlanet = new Planet.PlanetBuilder(planet.getPlanetName())
					.setPlanetDiameter(Double.toString(planet.getPlanetDiameterKm()))
					.setPlanetTemperature(Double.toString(planet.getPlanetSurfaceTempC()))
					.setNumberOfMoons(Integer.toString(planet.getNumMoons()))
							.build();
		assertEquals(planet.getPlanetName(), testingPlanet.getPlanetName());
		assertEquals(planet.getPlanetDiameterKm(), testingPlanet.getPlanetDiameterKm());
		assertEquals(planet.getPlanetSurfaceTempC(), testingPlanet.getPlanetSurfaceTempC());
		assertEquals(planet.getNumMoons(), testingPlanet.getNumMoons());
	}

	@Test
	public void testCreatePlanet(){
		Planet newPlanet = new Planet.PlanetBuilder("Neptune")
				.setPlanetDiameter("200")
				.setPlanetTemperature("20")
				.setNumberOfMoons("5")
				.setFilePath("hello")
				.build();
		Planet testingPlanet = new Planet.PlanetBuilder(newPlanet.getPlanetName())
				.setPlanetDiameter(Double.toString(newPlanet.getPlanetDiameterKm()))
				.setPlanetTemperature(Double.toString(newPlanet.getPlanetSurfaceTempC()))
				.setNumberOfMoons(Integer.toString(newPlanet.getNumMoons()))
						.build();
		assertEquals(newPlanet.getPlanetName(), testingPlanet.getPlanetName());
		assertEquals(newPlanet.getPlanetDiameterKm(), testingPlanet.getPlanetDiameterKm());
		assertEquals(newPlanet.getPlanetSurfaceTempC(), testingPlanet.getPlanetSurfaceTempC());
		assertEquals(newPlanet.getNumMoons(), testingPlanet.getNumMoons());
	}
}