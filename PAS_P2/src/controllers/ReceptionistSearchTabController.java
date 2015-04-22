package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import objects.Patient;
import businessLayer.ReceptionistBAL;

public class ReceptionistSearchTabController implements Initializable {

	@FXML
	private TableView<Patient> tableView;

	@FXML
	private TableColumn<Patient, String> nhsNumberColumn;
	@FXML
	private TableColumn<Patient, String> titleColumn;
	@FXML
	private TableColumn<Patient, String> firstNameColumn;
	@FXML
	private TableColumn<Patient, String> lastNameColumn;
	@FXML
	private TableColumn<Patient, String> postCodeColumn;
	@FXML
	private TableColumn<Patient, String> streetNumberColumn;
	@FXML
	private TableColumn<Patient, String> streetNameColumn;

	@FXML
	private TextField firstNameSearch;
	@FXML
	private TextField lastNameSearch;
	@FXML
	private TextField postCodeSearch;

	ReceptionistBAL bal = new ReceptionistBAL();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'FXMLReceptionistSearchTabPage.fxml'";

		System.out.println("initialising all columns in the receptionist's table view");
		// initialize all columns in the receptionist's table view
		// nhsNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient,
		// String>("nhsNumber"));
		// titleColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("title"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
		postCodeColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("postCode"));
		streetNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("streetNumber"));
		streetNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("streetName"));
		
		try {
			tableView.setItems(bal.selectAllBAL());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * searches database when user clicks search button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void searchButtonAction(ActionEvent event) throws IOException {

		String firstNameValue = firstNameSearch.getText();
		String lastNameValue = lastNameSearch.getText();
		String postCodeValue = postCodeSearch.getText();
		
		try {
			tableView.setItems(bal.searchButtonBAL(firstNameValue, lastNameValue, postCodeValue ));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Searches database when user presses enter at postcode text field
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handlePostcodeSearch(ActionEvent event) throws IOException {

		String firstNameValue = firstNameSearch.getText();
		String lastNameValue = lastNameSearch.getText();
		String postCodeValue = postCodeSearch.getText();

		try {
			tableView.setItems(bal.postCodeSearchBAL(firstNameValue, lastNameValue, postCodeValue));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * When clear button is selected, all text fields and observableList (search results) will clear
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void clearButtonAction(ActionEvent event) throws IOException {
		firstNameSearch.clear();
		lastNameSearch.clear();
		postCodeSearch.clear();
		//data.removeAll(data);
		bal.clearTableBAL();
		try {
			tableView.setItems(bal.selectAllBAL());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Button to open patient information screen using the highlighted row in receptionist search table
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnPatientInfo(ActionEvent event) throws IOException {

		System.out.println("Changing to patient info screen");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FXMLPatientInformationPage.fxml"));
		loader.setLocation(getClass().getResource("/views/FXMLPatientInformationPage.fxml"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));

		// instance of the patient info controller is created
		// set it equal to the FXMLLoader controller that was just loaded
		PatientInfoController patientInfoController = loader.<PatientInfoController> getController();
		try {
			patientInfoController.setPatientInfo(bal.patientInfoBAL(tableView));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Operation done successfully");		

		stage.show();
	}

}