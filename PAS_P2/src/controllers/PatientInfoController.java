package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.Patient;
import app.Queue;
import app.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PatientInfoController implements Initializable {

	@FXML
	private TableView<Patient> personTable;
	@FXML
	private TableColumn<Patient, String> firstNameColumn;
	@FXML
	private TableColumn<Patient, String> lastNameColumn;
	@FXML
	private Label nhsNumberLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetNumberLabel;
	@FXML
	private Label streetNameLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label postCodeLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert personTable != null : "fx:id=\"tableView\" was not injected: check your FXML file 'PatientInfoPage.fxml'";
	}

	/**
	 * Button to send user back to receptionist homepage
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		stage.close();
	}
	

	public static List<Patient> queue;
	
	public static QueueTabPageController queueTabPageController;
	
	/**
	 * Button to confirm patient and send them to triage/waiting queue
	 * 
	 * @param event
	 */
	@FXML
	private void btnConfirmClick(ActionEvent event) throws IOException{
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// patientservicesclass psc = new patientservicesclass

		// test.enqueue("test");
		// psc.getPatientById(nhsNumberLabel.getText())
		Patient p = new Patient(firstNameLabel.getText(), lastNameLabel.getText(), nhsNumberLabel.getText(),
				titleLabel.getText(), streetNumberLabel.getText(), streetNameLabel.getText(), cityLabel.getText(),
				postCodeLabel.getText(), Status.EMERGENCY);

		queue = Queue.addToQueue(p);
		
		appStage.hide();

	}

	/**
	 * sets relevant labels to patient information from the database these
	 * labels are set before screen is changed --- see btnPatientInfo on the
	 * ReceptionistHomePageController for more info ---
	 * 
	 * @param patient
	 */
	public void setPatientInfo(Patient patient) {
		nhsNumberLabel.setText(patient.getNhsNumber());
		titleLabel.setText(patient.getTitle());
		firstNameLabel.setText(patient.getFirstName());
		lastNameLabel.setText(patient.getLastName());
		streetNumberLabel.setText(patient.getStreetNumber());
		streetNameLabel.setText(patient.getStreetName());
		cityLabel.setText(patient.getCity());
		postCodeLabel.setText(patient.getPostCode());

	}


}