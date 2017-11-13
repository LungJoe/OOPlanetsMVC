package planet.detail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import Exceptions.ExceptionHandler;
import Models.Planet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
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
	private Planet planet = new Planet();
	private ExceptionHandler handler;
	
	public PlanetController(Stage stage, Planet planet) {
		this.stage = stage;
		this.planet = planet;
		handler = new ExceptionHandler();
	}
	
	@FXML
	void selectImage(ActionEvent event) {
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			File file = fileChooser.showOpenDialog(stage);

            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            planetImage.setImage(image);
        } catch (Exception ex) {}
	}

	@FXML
	void loadPlanet(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("CAUTION");
    	alert.setHeaderText("Loading a planet file will erase current data.");
    	alert.setContentText("Contunue?");
    	alert.showAndWait();

    	if(alert.getResult() != null){
    		planet.loadPlanet();
    		updateTextBoxes();
    		updateImage();
    	}
	}

	@FXML
	void savePlanet(ActionEvent event) {
		try{
			planet.setPlanetDiameterKm(planetDiameterKM.getText());
			planet.setPlanetSurfaceTempC(planetMeanSurfaceTempC.getText());
			planet.setNumMoons(planetNumberOfMoons.getText());
			planet.setPlanetImage(planetImage.getImage());
		}catch(Exception e){
			handler.handlePlanetException(e);
		}
		planet.savePlanet();
	}
	private void updateTextBoxes(){
		planetName.setText(planet.getPlanetName());
		planetDiameterKM.setText(Double.toString(planet.getPlanetDiameterKm()));
		planetMeanSurfaceTempC.setText(Double.toString(planet.getPlanetSurfaceTempC()));
		planetNumberOfMoons.setText(Integer.toString(planet.getNumMoons()));
	}
	
	private void updateImage(){
		try {
			File file;
			if(planet.getImageFilePath() == null){
				file = new File("images\\no_image.png");
			}
			else if(planet.getImageFilePath().equals("default")){
				file = new File("images\\neptune.png");
			}
			else{
				file = new File(planet.getImageFilePath());
			}
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            planetImage.setImage(image);
            planet.setImageFilePath(file.getAbsolutePath());
        } catch (Exception ex) {}
	}

	public void initialize(URL location, ResourceBundle resources) {
		updateImage();
		updateTextBoxes();
		
    	fancyPlanetName.textProperty().bind(planet.firstNameProperty());
    	planetDiameterM.textProperty().bind(planet.diameterMProperty().asString());
    	planetMeanSurfaceTempF.textProperty().bind(planet.tempFProperty().asString());	
    	
    	
 
    	planetName.textProperty().addListener(new PlanetNameChangeListener());
    	planetDiameterKM.textProperty().addListener(new PlanetDiameterChangeListener());
    	planetMeanSurfaceTempC.textProperty().addListener(new PlanetSurfaceTempListener());
    	planetNumberOfMoons.textProperty().addListener(new PlanetMoonCountListener());
	}
	
    private class PlanetNameChangeListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			
			try {
				planet.setPlanetName(newValue);
			} catch(Exception e) {
			    handler.handlePlanetException(e);
				planetName.setText(oldValue);
			}
		}
    }
    private class PlanetDiameterChangeListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setPlanetDiameterKm(newValue);
			} catch(Exception e) {
			    	handler.handlePlanetException(e);
			    	planetDiameterKM.setText(oldValue);
			}
		}
    }
    
    private class PlanetSurfaceTempListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setPlanetSurfaceTempC(newValue);
			} catch(Exception e) {
			    	handler.handlePlanetException(e);
			    	planetMeanSurfaceTempC.setText(oldValue);
			}
		}
    }
    
    private class PlanetMoonCountListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				planet.setNumMoons(newValue);
			} catch(Exception e) {
			    	handler.handlePlanetException(e);
			    	planetNumberOfMoons.setText(oldValue);
			}
		}
    }
}