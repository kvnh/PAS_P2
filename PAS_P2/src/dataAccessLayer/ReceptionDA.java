package dataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.ConnectionFactory;
import objects.Patient;
import objects.Person;

/**
 * Data Access for the Receptionist Page
 * 
 * @author Andrew Walmsley
 *
 */
public class ReceptionDA {

	// create connection and statement objects
	private static Connection conn;
	private static Statement stat;

	/**
	 * An observable list of Patient objects
	 */
	private static ObservableList<Patient> data;

	/**
	 * Method that retrieves data via the use of the search button
	 * 
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 * @throws SQLException
	 */
	public static ObservableList<Patient> searchButton(String firstNameValue,
			String lastNameValue, String postCodeValue) throws SQLException {

		// ResultSet variable
		ResultSet rs = null;

		// populate JavaFx table with our observable list
		data = FXCollections.observableArrayList();

		// query string
		String query = buildQuery(firstNameValue, lastNameValue, postCodeValue);

		// create connection and statement objects
		conn = ConnectionFactory.getConnection();
		stat = conn.createStatement();

		System.out.println("Inserting\n" + query);

		// assign results of query to ResultSet
		rs = stat.executeQuery(query);

		// while Result contains more items
		while (rs.next()) {
			// create new Patient object and assign them thier details
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
		// return Patient
		return data;
	}

	/**
	 * Method that returns Patient object for display in TableView
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ObservableList<Patient> selectAllData() throws SQLException {

		// create ResultSet variable
		ResultSet rs = null;

		// populate JavaFx with our observable list
		data = FXCollections.observableArrayList();

		// string query
		String query = "select nhsNumber ,title, firstName, lastName, postCode, streetNumber, streetName from patient;";

		// create connection and statement objects
		conn = ConnectionFactory.getConnection();
		stat = conn.createStatement();

		System.out.println("Inserting\n" + query);

		// assign results of query to ResultSet
		rs = stat.executeQuery(query);

		// while ResultSet has more items
		while (rs.next()) {
			// create new Patient object
			Patient patient = new Patient();
			// assign details to Patient
			patient.setNhsNumber(rs.getString("nhsNumber"));
			patient.setTitle(rs.getString("title"));
			patient.setFirstName(rs.getString("firstName"));
			patient.setLastName(rs.getString("lastName"));
			patient.setPostCode(rs.getString("postCode"));
			patient.setStreetNumber(rs.getString("streetNumber"));
			patient.setStreetName(rs.getString("streetName"));

			// add Patient to observable list
			data.add(patient);
		}

		// return Patient
		return data;
	}

	/**
	 * Method to clear rows from the TableView
	 * 
	 * @return
	 */
	public static boolean clearTable() {
		return data.removeAll(data);

	}

	/**
	 * Method to search using the postcode, retrieve data from the database
	 * 
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 * @throws SQLException
	 */
	public static ObservableList<Patient> postCodeSearch(String firstNameValue,
			String lastNameValue, String postCodeValue) throws SQLException {

		// populate JavaFX with our observable list
		data = FXCollections.observableArrayList();

		// create ResultSet variable
		ResultSet rs = null;

		// query string
		String query = buildQuery(firstNameValue, lastNameValue, postCodeValue);

		// create connection and statement objects
		conn = ConnectionFactory.getConnection();
		stat = conn.createStatement();

		System.out.println("Inserting\n" + query);

		// assign results of query to ResultSet
		rs = stat.executeQuery(query);

		// while ResultSet has more items
		while (rs.next()) {
			// create new Patient
			Patient patient = new Patient();
			// assign details to Patient
			patient.setNhsNumber(rs.getString("nhsNumber"));
			patient.setTitle(rs.getString("title"));
			patient.setFirstName(rs.getString("firstName"));
			patient.setLastName(rs.getString("lastName"));
			patient.setPostCode(rs.getString("postCode"));
			patient.setStreetNumber(rs.getString("streetNumber"));
			patient.setStreetName(rs.getString("streetName"));

			// add Patient to list
			data.add(patient);
		}

		// return Patient
		return data;
	}

	/**
	 * Method to retrieve the patient info from the database
	 * 
	 * @param tableView
	 * @return
	 * @throws SQLException
	 */
	public static Patient retrievePatientInfo(TableView<?> tableView)
			throws SQLException {

		// create ResultSet variable
		ResultSet rs = null;

		// create Patient variable
		Patient patient = null;

		// create connection and statement objects
		conn = ConnectionFactory.getConnection();
		stat = conn.createStatement();

		// query string
		String query = "SELECT * FROM patient WHERE nhsNumber = "
				+ "'"
				+ ((Person) tableView.getSelectionModel().getSelectedItem())
						.getNhsNumber() + "'" + ";";

		// assign results of query to ResultSet
		rs = stat.executeQuery(query);

		// while ResultSet has more items
		while (rs.next()) {
			// create new Patient
			patient = new Patient();
			// assign values to Patient
			patient.setNhsNumber(rs.getString("nhsNumber"));
			patient.setTitle(rs.getString("title"));
			patient.setFirstName(rs.getString("firstName"));
			patient.setLastName(rs.getString("lastName"));
			patient.setStreetNumber(rs.getString("streetNumber"));
			patient.setStreetName(rs.getString("streetName"));
			patient.setCity(rs.getString("city"));
			patient.setPostCode(rs.getString("postCode"));

		}

		// return Patient
		return patient;

	}

	/**
	 * Method to perform specific searches depending on the data input
	 * 
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 */
	private static String buildQuery(String firstNameValue,
			String lastNameValue, String postCodeValue) {

		// create query variable
		String query = "";

		// if first name is the only field entered
		if (firstNameValue != null && !firstNameValue.isEmpty()) {
			// search on first name
			query = "SELECT * FROM patient WHERE firstName LIKE'"
					+ firstNameValue + "%'";
		}

		// if last name is the only field entered
		if (lastNameValue != null && !lastNameValue.isEmpty()) {
			// search on last name
			query = "SELECT * FROM patient WHERE lastName LIKE'"
					+ lastNameValue + "%'";
		}

		// if postcode is the only field entered
		if (postCodeValue != null && !postCodeValue.isEmpty()) {
			// search on postcode
			query = "SELECT * FROM patient WHERE postCode LIKE'"
					+ postCodeValue + "%'";
		}

		// if first name and last name fields are entered
		if (firstNameValue != null && !firstNameValue.isEmpty()
				&& lastNameValue != null && !lastNameValue.isEmpty()) {
			// search on first and last name
			query = "SELECT * FROM patient WHERE firstName LIKE'"
					+ firstNameValue + "%' AND lastName LIKE '" + lastNameValue
					+ "%'";
		}

		return query;
	}

}
