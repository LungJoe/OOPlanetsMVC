package planet.detail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PlanetController {

	@FXML private ImageView planetImage;

	@FXML private Button selectImageButton;

	@FXML private TextField planetName;

	@FXML private TextField planetDiameterKM;

	@FXML private TextField planetDiameterM;

	@FXML private TextField planetMeanSurfaceTempC;

	@FXML private TextField planetMeanSurfaceTempF;

	@FXML private TextField planetNumberOfMoons;

	@FXML private Label fancyPlanetName;
	Stage stage;
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
}