package controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import app.Queue;
import objects.Patient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * class to represent treatment room page controller
 * @author Fergus
 *
 */
public class TreatmentRoomPageController implements Initializable {

	@FXML
	private TableView<Patient> treatmentRoomTableView;

	@FXML
	private TableColumn<Patient, Integer> treatmentRoomColumn;

	@FXML
	private TableColumn<Patient, String> triageAssessmentColumn;

	@FXML
	private TableColumn<Patient, String> doctorColumn;

	@FXML
	private TableColumn<Patient, String> firstNameColumn;

	@FXML
	private TableColumn<Patient, String> lastNameColumn;

	@FXML
	private TableColumn<Patient, String> timeEnteredColumn;

	@FXML
	private TreatmentRoomPageController treatmentRoomPageController;

	private ObservableList<Patient> tableData;

	/**
	 * method to initialise treatment room psge controller
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert treatmentRoomTableView != null : "fx:id=\"treatmentRoomTableView\" was not injected: check your FXML file 'FXMLTreatmentRoomPage.fxml'";

		treatmentRoomColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("treatRoomNum"));
		// StatusColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("triage"));
		triageAssessmentColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("triage"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
		timeEnteredColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("timeEnteredString"));

		// display the current queue to screen when opening page each time
		displayTreatmentQueue(Queue.inTreatment);

	}

	/**
	 * button to send user back to login screen
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void btnLogout(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/FXMLLoginPage.FXML"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.show();
		stage.centerOnScreen();
		// hides current page
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	/**
	 * method to populate the latest queue information in a table view for display
	 * @param queue
	 */
	public void displayTreatmentQueue(LinkedList<Patient> treatQueue) {

		Task updateTable = new Task() {
			@Override
			protected Object call() throws Exception {
				while (!isCancelled()) {
					// update your ObservableList
					tableData = FXCollections.observableArrayList(treatQueue);
					treatmentRoomTableView.setItems(tableData);

					// hide the columns that are not updating
					// reshow the columns
					Runnable r = () -> {
						treatmentRoomTableView.getColumns().get(0).setVisible(false);
						treatmentRoomTableView.getColumns().get(0).setVisible(true);
					};

					// wrap update tableView
					Platform.runLater(r);

					//put thread to sleep
					Thread.sleep(5000);
				}
				return null;
			}
		};
		Thread t = new Thread(updateTable);
		t.setDaemon(true);
		t.start();
	}

}
