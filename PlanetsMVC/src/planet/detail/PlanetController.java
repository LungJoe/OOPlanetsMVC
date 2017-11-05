package planet.detail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Models.InvalidPlanetException;
import Models.Planet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PlanetController implements Initializable {

	@FXML private ImageView planetImage;

	@FXML private Button selectImageButton;

	@FXML private TextField planetName;

	@FXML private TextField planetDiameterKM;

	@FXML private TextField planetDiameterM;

	@FXML private TextField planetMeanSurfaceTempC;

	@FXML private TextField planetMeanSurfaceTempF;

	@FXML private TextField planetNumberOfMoons;

	@FXML private Label fancyPlanetName;
	
	private Stage stage;
	private Planet planet;
	
	public PlanetController(Stage stage, Planet planet) {
		this.stage = stage;
		this.planet = planet;
	}
	
	@FXML
	void selectImage(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.showOpenDialog(stage);
	}

	@FXML
	void loadPlanet(ActionEvent event) {
		
	}

	@FXML
	void savePlanet(ActionEvent event) {
		
	}
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		//bind model fields to view fields

    	//this is nice and simple BUT it does not call the setter, so validation does not occur
		//firstName.textProperty().bind(person.firstNameProperty());
    	//but binding is ok with immutable UI field data types like Label
	planetDiameterKM.setText("0");
	planetMeanSurfaceTempC.setText("0");
    	fancyPlanetName.textProperty().bind(planet.firstNameProperty());
    	planetDiameterM.textProperty().bind(planet.diameterMProperty().asString());
    	planetMeanSurfaceTempF.textProperty().bind(planet.tempFProperty().asString());
    	
    	//init first name UI field to the model data
    	planetName.setText(planet.getPlanetName());
    	//attach a listener for when the user changes the UI field data. 
    	//we want UI changes to go through validation and if ok then change the model data.
    	//we can do this by simply calling our model's setter since it is already wired for validation
    	
    	planetName.textProperty().addListener(new PlanetNameChangeListener());
    	planetDiameterKM.textProperty().addListener(new PlanetDiameterChangeListener());
    	planetMeanSurfaceTempC.textProperty().addListener(new PlanetSurfaceTempListener());
	}

	
    private class PlanetNameChangeListener implements ChangeListener<String> {
	
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setPlanetName(newValue);
			} catch(InvalidPlanetException e) {
			    	Alert alert = new Alert(AlertType.INFORMATION);
			    	alert.setTitle(e.getMessage());
			    	alert.setHeaderText("The name you entered is not valid. See below for requirements.");
			    	alert.setContentText("Planet names may only contain: Alphanumeeric characters, periods, hyphens, and spaces.\n"
			    		+ "Planet names may be no longer than 255 and no less than 1 character in length.");
			    	alert.showAndWait();
				planetName.setText(oldValue);
			}
		}
    	
    }
    private class PlanetDiameterChangeListener implements ChangeListener<String> {
	
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setPlanetDiameterKm(newValue);
			} catch(InvalidPlanetException e) {
			    	Alert alert = new Alert(AlertType.INFORMATION);
			    	alert.setTitle(e.getMessage());
			    	alert.setHeaderText("The name you entered is not valid. See below for requirements.");
			    	alert.setContentText("Planet names may only contain: Alphanumeeric characters, periods, hyphens, and spaces.\n"
			    		+ "Planet names may be no longer than 255 and no less than 1 character in length.");
			    	alert.showAndWait();
			    	planetDiameterKM.setText(oldValue);
			}
		}
    	
    }
    
    private class PlanetSurfaceTempListener implements ChangeListener<String> {
	
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setPlanetSurfaceTempC(newValue);
			} catch(InvalidPlanetException e) {
			    	Alert alert = new Alert(AlertType.INFORMATION);
			    	alert.setTitle(e.getMessage());
			    	alert.setHeaderText("The name you entered is not valid. See below for requirements.");
			    	alert.setContentText("Planet names may only contain: Alphanumeeric characters, periods, hyphens, and spaces.\n"
			    		+ "Planet names may be no longer than 255 and no less than 1 character in length.");
			    	alert.showAndWait();
			    	planetMeanSurfaceTempC.setText(oldValue);
			}
		}
    	
    }
}