package planet.tets;


import planet.detail.PlanetValidators;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
}
