package dad.javafx.geofx.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class SecurityController implements Initializable{
	@FXML
	GridPane root;
	@FXML
	ImageView imageView;
	
	public SecurityController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecurityTab.fxml"));
		loader.setController(this);
		loader.load();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setImage(new Image(getClass().getResource("/icons/Network-Shield-icon.png").toString()));
	}
	
	public GridPane getRoot() {
		return root;
	}
}
