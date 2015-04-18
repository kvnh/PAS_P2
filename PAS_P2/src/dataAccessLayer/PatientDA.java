package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.Patient;
import models.DbUtil;

/**
 * Data Access Layer to create a Patient object
 * @author KHackett
 */
public class PatientDA {

	// create connection and statement objects
	private static Connection conn = null;
	private static Statement stmt = null;
	
	/**
	 * Queries are made here and ALL exceptions are thrown up the tiers/layers/levels...
	 * @param nhsNumber
	 * @return patient object
	 * @throws SQLException
	 */
	public static Patient createPatient(String nhsNumber) throws SQLException {

		// print query to console
		System.out.println("SELECT * FROM patient WHERE nhsNumber= " + "'" + nhsNumber + "'");

		ResultSet rs = null;

		Patient patient = new Patient();

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			conn.setAutoCommit(false);
			System.out.println("Opened connection successfully");

			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM patient WHERE nhsNumber= " + "'" + nhsNumber + "'");

			while (rs.next()) {
				if (rs.getString("nhsNumber").equals(nhsNumber)) {
					patient.setNhsNumber(rs.getString("nhsNumber"));
					patient.setTitle(rs.getString("title"));
					patient.setFirstName(rs.getString("firstName"));
					patient.setLastName(rs.getString("lastName"));
					patient.setPostCode(rs.getString("postCode"));
					patient.setStreetNumber(rs.getString("streetNumber"));
					patient.setStreetName(rs.getString("streetName"));
				} else {
					System.out.println("INVALID nhsNumber");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			// close all open resources in the database
			DbUtil.close(rs);
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}
		return patient;

	}

}