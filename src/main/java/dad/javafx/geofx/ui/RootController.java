package dad.javafx.geofx.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import dad.javafx.geofx.ipclient.IPService;
import dad.javafx.geofx.ipclient.IPServiceException;
import dad.javafx.geofx.localizationclient.GeoServiceException;
import dad.javafx.geofx.localizationclient.LocalizationService;
import dad.javafx.geofx.messages.Language;
import dad.javafx.geofx.messages.RootMessage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class RootController implements Initializable{
	//view
	@FXML
	VBox root;
	@FXML
	TextField ipText;
	@FXML
	Button ipButton;
	@FXML
	TabPane tabPane;
	@FXML
	Tab locationTab;
	@FXML
	Tab connectionTab;
	@FXML
	Tab securityTab;
	@FXML
	ImageView imageView;
	
	//model
	StringProperty ipProperty = new SimpleStringProperty();
	
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
	
	
	LocationController locationController = new LocationController();
	ConnectionController connectionController = new ConnectionController();
	SecurityController securityController = new SecurityController();
	IPService ipservice;
	LocalizationService localizationService;
	RootMessage data;
	
	private Task<String> tarea;
	private Task<RootMessage> tarea2;
	
	public RootController() throws IOException, IPServiceException, GeoServiceException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GeoFX.fxml"));
		loader.setController(this);
		loader.load();
		
		ipProperty.bind(ipText.textProperty());
		
		ipservice = new IPService();
		localizationService = new LocalizationService();
		
		getIPTask();
		
		ipText.textProperty().addListener(e -> setLocalizationIP());
				
		imageView.setImage(new Image(getClass().getResource("/icons/Wifi-icon.png").toString()));
		
		locationTab.setContent(locationController.getRoot());
		connectionTab.setContent(connectionController.getRoot());
		securityTab.setContent(securityController.getRoot());
	}
	private void setLocalizationIP() {
		localizationService.setIp(ipText.getText());
	}
	public void getDataTask() {
		tarea2 = new Task<RootMessage>() {
			protected RootMessage call() throws Exception {
				return localizationService.getData();
				}
		};
		tarea2.setOnFailed(e -> {
			e.getSource().getException().printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("todomal");
			alert.setContentText(e.getSource().getException().getMessage());
			alert.showAndWait();
		});
		tarea2.setOnSucceeded(e->{
			data = tarea2.getValue();
			fillData();
		});
		new Thread(tarea2).start();
	}
	public void getIPTask() {
		tarea = new Task<String>() {
			protected String call() throws Exception {
				return ipservice.getIP();
				}
		};
		tarea.setOnFailed(e -> {
			e.getSource().getException().printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("todomal");
			alert.setContentText(e.getSource().getException().getMessage());
			alert.showAndWait();
		});
		tarea.setOnSucceeded(e->{
			ipText.setText(tarea.getValue());
			setLocalizationIP();
			getDataTask();
		});
		new Thread(tarea).start();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ipButton.setOnAction(e -> onButtonClick());
		//bindings
		latitudeProperty.bindBidirectional(locationController.latitudeProperty);
		longitudeProperty.bindBidirectional(locationController.longitudeProperty);
		iplocationProperty.bindBidirectional(locationController.iplocationProperty);
		cityProperty.bindBidirectional(locationController.cityProperty);
		zipProperty.bindBidirectional(locationController.zipProperty);
		languageProperty.bindBidirectional(locationController.languageProperty);
		timeProperty.bindBidirectional(locationController.timeProperty);
		callingProperty.bindBidirectional(locationController.callingProperty);
		currencyProperty.bindBidirectional(locationController.currencyProperty);
		countryCodeProperty.bindBidirectional(locationController.countryCodeProperty);
		
	}
	
	private void onButtonClick() {
		setLocalizationIP();
		getDataTask();
//		
//		try {
//			data = localizationService.getData();
//		} catch (GeoServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		fillData();
	}
	private void fillData() {
		latitudeProperty.set(Double.toString(data.getLatitude()));
		longitudeProperty.set(Double.toString(data.getLongitude()));
		iplocationProperty.set(data.getCountry_name());
		cityProperty.set(data.getCity());
		zipProperty.set(data.getZip());
		Language[] languages = data.getLocation().getLanguages();
		languageProperty.set(languages[0].getName());
//		timeProperty
		callingProperty.set(data.getLocation().getCalling_code());
//		currencyProperty.set(data.getLocation());
		countryCodeProperty.set(data.getCountry_code());
	}
	public VBox getRoot() {
		return root;
	}
	public final StringProperty ipPropertyProperty() {
		return this.ipProperty;
	}
	
	public final String getIpProperty() {
		return this.ipPropertyProperty().get();
	}
	
	public final void setIpProperty(final String ipProperty) {
		this.ipPropertyProperty().set(ipProperty);
	}
}
