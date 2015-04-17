package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import models.ConnectionFactory;
import models.DbUtil;
import app.Patient;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

	// private Logger logger;

	private Connection connection;
	private Statement statement;

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
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			// con.setAutoCommit(false);
			System.out.println("Database opened successfully");

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
			// logger.info(ce.toString());
		} catch (Exception ex) {
			System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
			System.exit(0);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
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
		// hides current page
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	private ObservableList<Patient> data;

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

		data = FXCollections.observableArrayList();

		ResultSet rs = null;

		String query = buildQuery(firstNameValue, lastNameValue, postCodeValue);

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();

			// String query = "SELECT * FROM patient WHERE firstName = '" + firstNameValue +
			// "' OR lastName = '"
			// + lastNameValue + "'";

			System.out.println("Inserting\n" + query);

			rs = statement.executeQuery(query);

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setNhsNumber(rs.getString("nhsNumber"));
				patient.setTitle(rs.getString("title"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setPostCode(rs.getString("postCode"));
				patient.setStreetNumber(rs.getString("streetNumber"));
				patient.setStreetName(rs.getString("streetName"));
				data.add(patient);
			}
			tableView.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
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

		data = FXCollections.observableArrayList();

		ResultSet rs = null;

		String query = buildQuery(firstNameValue, lastNameValue, postCodeValue);

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();

			System.out.println("Inserting\n" + query);

			rs = statement.executeQuery(query);

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setNhsNumber(rs.getString("nhsNumber"));
				patient.setTitle(rs.getString("title"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setPostCode(rs.getString("postCode"));
				patient.setStreetNumber(rs.getString("streetNumber"));
				patient.setStreetName(rs.getString("streetName"));
				data.add(patient);
			}
			tableView.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
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
		data.removeAll(data);
	}

	private String buildQuery(String firstNameValue, String lastNameValue, String postCodeValue) {
		String query = "";

		if (firstNameValue != null && !firstNameValue.isEmpty()) {
			query = "SELECT * FROM patient WHERE firstName LIKE'" + firstNameValue + "%'";
		}

		if (lastNameValue != null && !lastNameValue.isEmpty()) {
			query = "SELECT * FROM patient WHERE lastName LIKE'" + lastNameValue + "%'";
		}

		if (postCodeValue != null && !postCodeValue.isEmpty()) {
			query = "SELECT * FROM patient WHERE postCode LIKE'" + postCodeValue + "%'";
		}

		if (firstNameValue != null && !firstNameValue.isEmpty() && lastNameValue != null && !lastNameValue.isEmpty()) {
			query = "SELECT * FROM patient WHERE firstName LIKE'" + firstNameValue + "%' AND lastName LIKE '"
					+ lastNameValue + "%'";
		}

		return query;
	}

	/**
	 * Button to open patient information screen using the highlighted row in receptionist search table
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnPatientInfo(ActionEvent event) throws IOException {

		System.out.println("Changing to patient info screen");

		ResultSet rs = null;

		Patient patient = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();

			String query = "SELECT * FROM patient WHERE nhsNumber = " + "'"
					+ tableView.getSelectionModel().getSelectedItem().getNhsNumber() + "'" + ";";

			rs = statement.executeQuery(query);

			while (rs.next()) {

				patient = new Patient();

				patient.setNhsNumber(rs.getString("nhsNumber"));
				patient.setTitle(rs.getString("title"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setStreetNumber(rs.getString("streetNumber"));
				patient.setStreetName(rs.getString("streetName"));
				patient.setCity(rs.getString("city"));
				patient.setPostCode(rs.getString("postCode"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		System.out.println("Operation done successfully");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FXMLPatientInformationPage.fxml"));
		loader.setLocation(getClass().getResource("/views/FXMLPatientInformationPage.fxml"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));

		// instance of the patient info controller is created
		// set it equal to the FXMLLoader controller that was just loaded
		PatientInfoController patientInfoController = loader.<PatientInfoController> getController();
		patientInfoController.setPatientInfo(patient);

		stage.show();
	}

}