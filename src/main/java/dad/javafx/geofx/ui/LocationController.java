package dad.javafx.geofx.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LocationController implements Initializable{
	//view
	@FXML
	GridPane root;
	@FXML
	Label latitudeLabel;
	@FXML
	Label longitudeLabel;
	@FXML
	Label ipLocationLabel;
	@FXML
	ImageView flagView;
	@FXML
	Label cityLabel;
	@FXML
	Label zipLabel;
	@FXML
	Label languageLabel;
	@FXML
	Label timeLabel;
	@FXML
	Label callingLabel;
	@FXML
	Label currencyLabel;
	
	//model
	StringProperty latitudeProperty = new SimpleStringProperty();
	StringProperty longitudeProperty = new SimpleStringProperty();
	StringProperty iplocationProperty = new SimpleStringProperty();
	StringProperty cityProperty = new SimpleStringProperty();
	StringProperty zipProperty = new SimpleStringProperty();
	StringProperty languageProperty = new SimpleStringProperty();
	StringProperty timeProperty = new SimpleStringProperty();
	StringProperty callingProperty = new SimpleStringProperty();
	StringProperty currencyProperty = new SimpleStringProperty();
	StringProperty countryCodeProperty = new SimpleStringProperty();
	
	public LocationController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LocationTab.fxml"));
		loader.setController(this);
		loader.load();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		countryCodeProperty.addListener(e -> setCountryFlag());
		latitudeLabel.textProperty().bindBidirectional(latitudeProperty);
		longitudeLabel.textProperty().bindBidirectional(longitudeProperty);
		ipLocationLabel.textProperty().bindBidirectional(iplocationProperty);
		cityLabel.textProperty().bindBidirectional(cityProperty);
		zipLabel.textProperty().bindBidirectional(zipProperty);
		languageLabel.textProperty().bindBidirectional(languageProperty);
		timeLabel.textProperty().bindBidirectional(timeProperty);
		callingLabel.textProperty().bindBidirectional(callingProperty);
		currencyLabel.textProperty().bindBidirectional(currencyProperty);
		
	}
	
	private void setCountryFlag() {
		flagView.setImage(new Image(getClass().getResource("/64x42/"+countryCodeProperty.get()+".png").toString()));
	}

	public GridPane getRoot() {
		return root;
	}

}
