package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import objects.Patient;
import app.Queue;
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
 * class to represent triage nurse home page controller
 * 
 * @author Fergus
 *
 */
public class TriageNurseHomePageController implements Initializable {

	@FXML
	private TableView<Patient> tableView;

	@FXML
	private TableColumn<Patient, String> nhsNumberColumn;

	@FXML
	private TableColumn<Patient, String> firstNameColumn;

	@FXML
	private TableColumn<Patient, String> lastNameColumn;

	@FXML
	private TableColumn<Patient, String> dobColumn;

	@FXML
	private TableColumn<Patient, String> triageAssessmentColumn;

	private ObservableList<Patient> tableData;

	/**
	 * method to initialise triage nurse home page controller
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'FXMLTriageNurseHomePage.fxml'";

		nhsNumberColumn
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"nhsNumber"));
		firstNameColumn
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"firstName"));
		lastNameColumn
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"lastName"));
		triageAssessmentColumn
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"triage"));
		// timeEnteredColumn.setCellValueFactory(new
		// PropertyValueFactory<Patient, Date>("timeStamp"));

		// display the current queue to screen when opening page each time
		displayQueue(Queue.queue);
	}

	/**
	 * button for triage nurse to assess patient
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnAssess(ActionEvent event) throws IOException {

		System.out.println("Changing to assess patient for triage screen");

		// Patient patient = new Patient();
		Patient patient = tableView.getSelectionModel().getSelectedItem();

		System.out.println("Changing to patient assessment screen");
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"/views/FXMLPatientAssessmentPage.fxml"));
		loader.setLocation(getClass().getResource(
				"/views/FXMLPatientAssessmentPage.fxml"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));

		// instance of the patient assessment page controller is created
		// set it equal to the FXMLLoader controller that was just loaded
		PatientAssessmentPageController patientAssessmentPageController = loader
				.<PatientAssessmentPageController> getController();
		patientAssessmentPageController.setPatientInfo(patient);

		stage.show();

	}

	/**
	 * refreshes the queue table on action
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnRefreshQueueClick(ActionEvent event) throws IOException {
		displayQueue(Queue.queue);
	}

	/**
	 * method to display the queue to screen
	 * 
	 * @param queue
	 */
	public void displayQueue(LinkedList<Patient> queue) {

		Task updateTable = new Task() {
			@Override
			protected Object call() throws Exception {
				while (!isCancelled()) {
					// update your ObservableList
					tableData = FXCollections.observableArrayList(queue);
					tableView.setItems(tableData);
					// hide the columns that are not updating
					// reshow the columns
					Runnable r = () -> {
						tableView.getColumns().get(0).setVisible(false);
						tableView.getColumns().get(0).setVisible(true);
					};

					// wrap update tableView
					Platform.runLater(r);

					Thread.sleep(5000);
				}
				return null;
			}
		};
		Thread t = new Thread(updateTable);
		t.setDaemon(true);
		t.start();
	}

	/**
	 * button to send user back to login screen
	 * 
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

}
