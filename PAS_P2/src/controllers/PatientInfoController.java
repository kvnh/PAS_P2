package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import objects.Patient;
import businessLayer.PatientServices;
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

/**
 * Controller to manage the display of patient information
 * on the PatientInfo page
 * @author KHackett
 *
 */
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

	// create an instance of the PatientServices service layer
	public PatientServices ps = new PatientServices();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert personTable != null : "fx:id=\"tableView\" was not injected: check your FXML file 'PatientInfoPage.fxml'";
	}

	/**
	 * Button to confirm patient and add them to the triage/waiting queue
	 * @param event
	 * @throws SQLException 
	 */
	@FXML
	private void btnConfirmClick(ActionEvent event) throws IOException, SQLException {
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// pass the nhsNumber from the nhsNumberLabel on PatientInfo screen
		// to the getPatientByNHSNumber method in the service layer
		Patient p = ps.getPatientByNHSNumber(nhsNumberLabel.getText());

		// check if patient exists in the array list already
		// send the patient object to the checkIfInQueue() method
		if (checkIfInQueue(p) == false) {
			System.out.println(p.getFirstName() + " is not is the queue");
			// add this patient, p, to the queue
			
			
			Queue.addToQueue(p);
		} else {
			System.out.println("already in the queue");
		}

		// close the PatientInfo screen
		appStage.hide();

	}

	/**
	 * check if a patient already exists in the queue
	 * 
	 * @param p the patient to be checked
	 * @return true if patient is in queue, false if not is queue
	 */
	public boolean checkIfInQueue(Patient p) {
		// set nhsNumber equal to the nhsNumberLabel on the page
		String nhsNumber = nhsNumberLabel.getText();
		System.out.println("Checking if " + nhsNumber + " is already in the queue");

		// create boolean to state whether a person is in the queue or not
		boolean isInQueue = false;

		for (int i = 0; i < Queue.queue.size(); i++) {
			String nhsnumber = Queue.queue.get(i).getNhsNumber();
			if (nhsnumber.equalsIgnoreCase(p.getNhsNumber()) == true) {
				System.out.println(p.getFirstName() + " is already in the queue (checkIfInQueue() method)");
				isInQueue = true;
				break;
			} else {
				System.out.println(p.getFirstName() + " is not in the queue (checkIfInQueue() method)");
				isInQueue = false;
			}
		}

		return isInQueue;
	}

	/**
	 * Button to send user back to receptionist homepage
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		// create a stage object for the PatientInfo page
		Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		// close the PatientInfo page
		stage.close();
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