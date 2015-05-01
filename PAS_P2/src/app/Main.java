package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * main class to start application
 * @author KHackett
 *
 */
public class Main extends Application {

	/**
	 * main method to kick off the application
	 * @param args
	 */
	public static void main(String[] args) {
		// initialize all treatment rooms
		TreatmentRoom.createTreatmentRooms();

		// start thread running in the ControlQueue class
		ControlQueue cq = new ControlQueue();
		Thread thread = new Thread(cq);
		thread.start();

		launch(args);
	}

	/**
	 * start method to kick off the JavaFX application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
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

}