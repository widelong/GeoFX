package dad.javafx.geofx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeoFXApp extends Application {
	RootController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new RootController();
		Scene scene = new Scene(controller.getRoot(), 320, 320);
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
