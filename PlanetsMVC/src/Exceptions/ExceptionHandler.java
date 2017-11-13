package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExceptionHandler {
	
	public void handlePlanetException(Exception e){		
		if(e instanceof InvalidNameException){ nameException(e);	}
		else if(e instanceof InvalidDiameterException){ diameterException(e);}
		else if(e instanceof InvalidTemperatureException){ tempException(e); }
		else if(e instanceof InvalidMoonException){ moonException(e); }

	}
	
	private void nameException(Exception e){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(e.getMessage());
    	alert.setHeaderText("The name you entered is invalid. See below for requirements.");
    	alert.setContentText("Planet names may only contain: Alphanumeeric characters, periods, hyphens, and spaces.\n"
    		+ "Planet names may be no longer than 255 and no less than 1 character in length.");
    	alert.showAndWait();
	}
	
	private void diameterException(Exception e){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(e.getMessage());
    	alert.setHeaderText("The diameter you input is invalid. See below for requirements.");
    	alert.setContentText("Planet Diameter may only contain numbers.\n"
    		+ "Planet diameter must be between 0 and 200000 KM.");
    	alert.showAndWait();
	}
	
	private void tempException(Exception e){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(e.getMessage());
    	alert.setHeaderText("The temperature you specified is invalid. See below for requirements.");
    	alert.setContentText("Planet Temperature may only contain numbers.\n"
    		+ "Planet temperature must be between -273.15 and 500.0 C.");
    	alert.showAndWait();
	}

	private void moonException(Exception e){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(e.getMessage());
    	alert.setHeaderText("The Number of Moons you specified is invalid. See below for requirements.");
    	alert.setContentText("Planet number of moons may only contain numbers.\n"
    		+ "Planet number of moons must be between 0 and 1000.");
    	//System.out.println(alert.getResult());
    	alert.showAndWait();
    	System.out.println(alert.getResult());
	}
	
	private void fileException(Exception e){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(e.getMessage());
    	alert.setHeaderText("A planet file already exists.");
    	alert.setContentText("Continuing will overwrite the preexisting file.");
    	
    	alert.showAndWait();
	}
}
