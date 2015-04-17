package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import app.Patient;
import app.Queue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	// public static LinkedList<Patient> displayQueue;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'FXMLTriageNurseHomePage.fxml'";

		nhsNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("nhsNumber"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
		triageAssessmentColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("triage"));
		// timeEnteredColumn.setCellValueFactory(new PropertyValueFactory<Patient, Date>("timeStamp"));
	}
	
	/**
	 * button for triage nurse to assess patient
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnAssess(ActionEvent event) throws IOException {
		
		System.out.println("Changing to assess patient for triage screen");
		
		Patient patient = new Patient();
		
		System.out.println("Changing to patient assessment screen");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FXMLPatientAssessmentPage.fxml"));
		loader.setLocation(getClass().getResource("/views/FXMLPatientAssessmentPage.fxml"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		
		// instance of the patient assessment page controller is created
		// set it equal to the FXMLLoader controller that was just loaded
		PatientAssessmentPageController patientAssessmentPageController = loader.<PatientAssessmentPageController>getController();
		patientAssessmentPageController.setPatientInfo(patient);

		stage.show();
		
	}
	
	@FXML
	private void btnRefreshQueueClick(ActionEvent event) throws IOException{
		displayQueue(Queue.queue);
	}

	public void displayQueue(LinkedList<Patient> queue) {
		tableData = FXCollections.observableArrayList(queue);
		tableView.setItems(tableData);
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
		// hides current page
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}
