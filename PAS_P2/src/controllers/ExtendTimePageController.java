package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import app.Queue;
import app.Status;
import app.TreatmentRoom;
import app.TreatmentTimer;
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
 * @author KHackett Controller class for patient assessment on the triage nurse
 *         page
 */
public class ExtendTimePageController implements Initializable {

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	/**
	 * btnConfirm to confirm the patient extension by 5 mins
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnConfirm(ActionEvent event) throws IOException {
		// create a stage object for the PatientAssessmentPage
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// call the assignTriage method to assign triage category
		assignExtension(TreatmentRoom.treat);

		// close the PatientAssessmentPage
		stage.close();
	}

	public void assignExtension(TreatmentRoom[] treatmentRoom) {
		// set nhsNumber equal to the nhsNumberLabel on the page
		String nhsNumber = nhsNumberLabel.getText();
		System.out.println(nhsNumber);
		
		for(int i = 0; i < treatmentRoom.length; i++){
			if(nhsNumber == (treatmentRoom[i].getPatient().getNhsNumber())){
				System.out.println("\t\t\t\t\t\t" + treatmentRoom[i].getPatient().getFirstName());
				TreatmentTimer.extendTreatment(treatmentRoom[i]);
			}
		}
	}


	/**
	 * ActionEvent to cancel out of the current screen and return to the triage
	 * nurse main
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		// create a stage object for the PatientAssessmentPage
		Stage stage = (Stage) ((Node) (event.getSource())).getScene()
				.getWindow();
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