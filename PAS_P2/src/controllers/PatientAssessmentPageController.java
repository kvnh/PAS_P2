package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import objects.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void btnConfirm(ActionEvent event) throws IOException {
	}

	/**
	 * ActionEvent to cancel out of the current screen and return to the triage nurse main
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
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
