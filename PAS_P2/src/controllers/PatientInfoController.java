package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import objects.Patient;
import businessLayer.PatientServices;
import app.Queue;
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

		// add this patient, p, to the queue
		Queue.addToQueue(p);

		// close the PatientInfo screen
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

	/**
	 * Button to send user back to receptionist homepage
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		stage.close();
	}

}