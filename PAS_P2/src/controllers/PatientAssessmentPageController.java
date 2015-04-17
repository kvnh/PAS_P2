package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PatientAssessmentPageController implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@FXML
	private void btnConfirm(ActionEvent event) throws IOException {
	}
	
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
	}
	
	
	/**
	 * sets relevant labels to patient information from the database these
	 * labels are set before screen is changed --- see btnPatientInfo on the
	 * ReceptionistHomePageController for more info ---
	 * 
	 * @param patient
	 */
	public void setPatientInfo(Patient patient) {
//		nhsNumberLabel.setText(patient.getNhsNumber());
//		titleLabel.setText(patient.getTitle());
//		firstNameLabel.setText(patient.getFirstName());
//		lastNameLabel.setText(patient.getLastName());
//		streetNumberLabel.setText(patient.getStreetNumber());
//		streetNameLabel.setText(patient.getStreetName());
//		cityLabel.setText(patient.getCity());
//		postCodeLabel.setText(patient.getPostCode());
	}
	
}
