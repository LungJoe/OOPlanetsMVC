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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvc.PersonController.FirstNameChangeListener;

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
	
	public PlanetController(Stage stage) {
		this.stage = stage;
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
    	fancyPlanetName.textProperty().bind(planet.firstNameProperty());
    	
    	//init first name UI field to the model data
    	firstName.setText(person.getFirstName());
    	//attach a listener for when the user changes the UI field data. 
    	//we want UI changes to go through validation and if ok then change the model data.
    	//we can do this by simply calling our model's setter since it is already wired for validation
    	firstName.textProperty().addListener(new PlanetNameChangeListener());
	}

	
    private class PlanetNameChangeListener implements ChangeListener<String> {
		//need below boolean to keep error message around until we change the field
		private boolean skipLabelMessage = false;

		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setPlanetName(newValue);
				if(!skipLabelMessage)
					fancyPlanetName.setText("");
				skipLabelMessage = false;
			} catch(InvalidPlanetException e) {
				//System.err.println(e.getMessage());
				fancyPlanetName.setText(e.getMessage());
				skipLabelMessage = true;
				//reset firstName to last good value
				//Note this calls this changed event with the oldValue
				//which is why we need bypass switch to avoid immediately clearing the error message
				planetName.setText(oldValue);
			}
		}
    	
    }
}