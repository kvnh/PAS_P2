package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import app.Status;
import objects.Patient;
import models.DbUtil;

/**
 * Data Access Layer to create a Patient object
 * 
 * @author KHackett
 */
public class PatientDA {

	// create connection and statement objects
	private static Connection conn = null;
	private static Statement stmt = null;

	/**
	 * Method to create Patient object
	 * 
	 * Queries are made here and ALL exceptions are thrown up the
	 * tiers/layers/levels...
	 * 
	 * @param nhsNumber
	 * @return patient object
	 * @throws SQLException
	 */
	public static Patient createPatient(String nhsNumber) throws SQLException {

		// print query to console
		System.out.println("SELECT * FROM patient WHERE nhsNumber= " + "'"
				+ nhsNumber + "'");

		// create ResultSet
		ResultSet rs = null;

		// create new Patient object
		Patient patient = new Patient();

		try {
			// open connection to database
			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			// ensure manual commit
			conn.setAutoCommit(false);
			System.out.println("Opened connection successfully");

			stmt = conn.createStatement();

			// assign results of query to ResultSet
			rs = stmt.executeQuery("SELECT * FROM patient WHERE nhsNumber= "
					+ "'" + nhsNumber + "'");

			// while ResultSet has more items
			while (rs.next()) {
				// if nhsNumber matches
				if (rs.getString("nhsNumber").equals(nhsNumber)) {
					// set Patient details
					patient.setNhsNumber(rs.getString("nhsNumber"));
					patient.setTitle(rs.getString("title"));
					patient.setFirstName(rs.getString("firstName"));
					patient.setLastName(rs.getString("lastName"));
					patient.setPostCode(rs.getString("postCode"));
					patient.setStreetNumber(rs.getString("streetNumber"));
					patient.setStreetName(rs.getString("streetName"));
					patient.setAllergies(rs.getString("allergy"));
					patient.setBloodType(rs.getString("bloodGroup"));
					patient.setTriage(Status.NOT_ASSESSED);
					patient.setTimeEntered(DateTime.now());
					patient.setPreviouslyInQueue(false);

					// format for date time as a String
					DateTimeFormatter formatter = DateTimeFormat
							.forPattern("yyyy-MM-dd HH:mm:ss");

					// DateTime variable to store time now
					DateTime d = DateTime.now();
					// set patient timeEntered to now
					patient.setTimeEnteredString(formatter.print(d));

					// else nhsNumber doesn't match
				} else {
					System.out.println("INVALID nhsNumber");
				}
			}
			// catch SQL exception
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			// close all open resources in the database
			DbUtil.close(rs);
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}

		// return Patient
		return patient;

	}

}