package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.Queue;
import app.Status;
import objects.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * 
 * @author KHackett
 * Controller class for patient assessment on the triage nurse page 
 */
public class PatientAssessmentPageController implements Initializable {

	@FXML
	private Label nhsNumberLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label bloodTypeLabel;
	@FXML
	private Label allergiesLabel;

	@FXML
	private RadioButton emergencyRButton;
	@FXML
	private RadioButton urgentRButton;
	@FXML
	private RadioButton semiUrgentRButton;
	@FXML
	private RadioButton nonUrgentRButton;
	@FXML
	private RadioButton notAssessedRButton;

	// keep the 5 radio buttons grouped as one family of choices
	ToggleGroup toggleGroup;

	public static ArrayList<Patient> arrayQueue;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// create a new toggleGroup object and assign each radio button to it
		// javaFX will now treat them all as one choice
		toggleGroup = new ToggleGroup();
		emergencyRButton.setToggleGroup(toggleGroup);
		urgentRButton.setToggleGroup(toggleGroup);
		semiUrgentRButton.setToggleGroup(toggleGroup);
		nonUrgentRButton.setToggleGroup(toggleGroup);
		notAssessedRButton.setToggleGroup(toggleGroup);

		// default selection to notAssessed button
		notAssessedRButton.setSelected(true);
	}

	@FXML
	private void btnConfirm(ActionEvent event) throws IOException {
		// create a stage object for the PatientAssessmentPage
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		String nhsNumber = nhsNumberLabel.getText();

		arrayQueue = new ArrayList<Patient>(Queue.queue);

		System.out.println(nhsNumber);
		

		for (int i = 0; i < arrayQueue.size(); i++) {
			// System.out.println(arrayQueue.get(i).getFirstName() +
			// arrayQueue.get(i).getNhsNumber());
			if (nhsNumber == (arrayQueue.get(i).getNhsNumber())) {
				System.out.println("adding triage status for " + arrayQueue.get(i).getFirstName());
				if (emergencyRButton.isSelected()) {
					arrayQueue.get(i).setTriage(Status.EMERGENCY);
					System.out.println("Emergency selected");
				} else if (urgentRButton.isSelected()) {
					arrayQueue.get(i).setTriage(Status.URGENT);
					System.out.println("Urgent selected");
				} else if (semiUrgentRButton.isSelected()) {
					arrayQueue.get(i).setTriage(Status.SEMI_URGENT);
					System.out.println("Semi-urgent selected");
				} else if (nonUrgentRButton.isSelected()) {
					arrayQueue.get(i).setTriage(Status.NON_URGENT);
					System.out.println("Non-urgent selected");
				} else if (notAssessedRButton.isSelected()) {
					arrayQueue.get(i).setTriage(Status.NOT_ASSESSED);
					System.out.println("Not assessed selected");
				}
			} else {
				System.out.println("not the assessed patient");
			}
		}

		// close the PatientAssessmentPage
		stage.close();
	}

	/**
	 * ActionEvent to cancel out of the current screen and return to the triage nurse main
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		// create a stage object for the PatientAssessmentPage
		Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		// close the PatientAssessmentPage
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
		bloodTypeLabel.setText(patient.getBloodType());
		allergiesLabel.setText(patient.getAllergies());
	}

}