package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	// compiler looks for start, this is the starting point for JavaFX applications
	@Override
	public void start(Stage primaryStage) throws Exception {
		try { //comment
			Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLLoginPage.fxml"));
			Scene scene = new Scene(root);
			// load css file
			scene.getStylesheets().add(getClass().getResource("/styles/loginPage1.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}