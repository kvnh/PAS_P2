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
 * @author Andrew Walmsley
 *
 */
public class ReceptionDA {
	
	private static Connection conn;
	private static Statement stat;
	private static ObservableList<Patient> data;
	private static ObservableList<Patient> startUpData;

	/**
	 * Retrieve data via the use of the search button
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 * @throws SQLException 
	 */
	public static ObservableList<Patient> searchButton(String firstNameValue, String lastNameValue, String postCodeValue) throws SQLException{
		ResultSet rs = null;
//		try {
			
			data = FXCollections.observableArrayList();

			String query = buildQuery(firstNameValue, lastNameValue, postCodeValue);

			conn = ConnectionFactory.getConnection();
			stat = conn.createStatement();

			System.out.println("Inserting\n" + query);

			rs = stat.executeQuery(query);

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
		return data;
	}
	
	public static ObservableList<Patient> selectAllData() throws SQLException{
		ResultSet rs = null;
			
			data = FXCollections.observableArrayList();

			String query = "select nhsNumber ,title, firstName, lastName, postCode, streetNumber, streetName from patient;";

			conn = ConnectionFactory.getConnection();
			stat = conn.createStatement();

			System.out.println("Inserting\n" + query);

			rs = stat.executeQuery(query);

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
		return data;
	}	
	
	/**
	 * Remove rows ffrom the TableView
	 * @return
	 */
	public static boolean  clearTable(){
		return data.removeAll(data);
		
	}
	
	/**
	 * Carryout search using the postcode, retrieve data from the database
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 * @throws SQLException 
	 */
	public static ObservableList<Patient> postCodeSearch(String firstNameValue, String lastNameValue, String postCodeValue) throws SQLException{
		data = FXCollections.observableArrayList();

		ResultSet rs = null;

		String query = buildQuery(firstNameValue, lastNameValue, postCodeValue);

	//	try {
			conn = ConnectionFactory.getConnection();
			stat = conn.createStatement();

			System.out.println("Inserting\n" + query);

			rs = stat.executeQuery(query);

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
		return data;
	}
	
	
	/**
	 * Retrieve the patient info from the database
	 * @param tableView
	 * @return
	 * @throws SQLException 
	 */
	public static Patient retrievePatientInfo(TableView<?> tableView) throws SQLException{
		
		ResultSet rs = null;

		Patient patient = null;

		//try {
			conn = ConnectionFactory.getConnection();
			stat = conn.createStatement();

			String query = "SELECT * FROM patient WHERE nhsNumber = " + "'"
					+ ((Person) tableView.getSelectionModel().getSelectedItem()).getNhsNumber() + "'" + ";";

			rs = stat.executeQuery(query);

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
		return patient;
		
	}
	
	private static String buildQuery(String firstNameValue, String lastNameValue, String postCodeValue) {
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

}
