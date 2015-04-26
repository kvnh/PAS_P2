/**
 * 
 */
package dataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ConnectionFactory;
import models.DbUtil;
import objects.Patient;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import app.Status;

/**
 * Data Access Layer to create a Patient object
 * 
 * @author FTaylor
 */
public class QueueDA {

	/**
	 * Queries are made here and ALL exceptions are thrown up the
	 * tiers/layers/levels...
	 * 
	 * @param nhsNumber
	 * @param Timestamp
	 * @throws SQLException
	 */

	// create connection and statement objects
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ObservableList<Patient> data;

	/**
	 * Selects all patients who are already in the Queue
	 * @return
	 * @throws SQLException
	 */
	public static ObservableList<Patient> selectAllData() throws SQLException{
		ResultSet rs = null;
			
			data = FXCollections.observableArrayList();

			String query = "select nhsNumber, firstName, lastName, Timestamp from InQueue;";

			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();

			System.out.println("Inserting\n" + query);

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setNhsNumber(rs.getString("nhsNumber"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				//problem here
				
				
				//patient.setNewTimeRecieved(rs.getInt("Timestamp"));
				data.add(patient);
			}
		return data;
	}	
	

	/**
	 * method to add patient details to database queue table
	 * 
	 * @param p
	 * @throws SQLException 
	 */
	public static void addToInQueue(Patient p) throws SQLException {

			// open connection to database
			conn = ConnectionFactory.getConnection();

			// create statement
			stmt = conn.createStatement();
			/*
			 * Need to add more columns in this table. This needs to feed into the dynamic queue table
			 */
			String sql = "insert into InQueue values('" + p.getNhsNumber()+"' , '"+p.getFirstName()+"' , '"+p.getLastName()+"' , '"
					+p.getTriage().toString()+"',CURRENT_TIMESTAMP )";

			// execute update
			stmt.executeUpdate(sql);
			
			closeConnections();
	}


	private static void closeConnections() {
		DbUtil.close(stmt);
		DbUtil.close(conn);
	}
	
	
	/**
	 * method to add patient details to database queue table
	 * 
	 * @param p
	 * @throws SQLException 
	 */
	public static void addToQueueTable(Patient p) throws SQLException {

			// open connection to database
			conn = ConnectionFactory.getConnection();

			// create statement
			stmt = conn.createStatement();

			/*
			 * Need to add more columns in this table. This needs to feed into the dynamic queue table
			 */
			String sql = "insert into queueTime values('" + p.getNhsNumber()
					+ "', CURRENT_TIMESTAMP)";

			// execute update
			stmt.executeUpdate(sql);
			
			closeConnections();
	}

	/**
	 * method to remove patient details from database queue table
	 * 
	 * @param p
	 * @throws SQLException 
	 */
	public static void removeFromQueueTable(Patient p) throws SQLException  {


			// open connection to database
			conn = ConnectionFactory.getConnection();


			// create statement
			stmt = conn.createStatement();

			String sql = "delete from queueTime where NHSNumber = '"
					+ p.getNhsNumber() + "'";

			// execute update
			stmt.executeUpdate(sql);

	
			closeConnections();
	

	}

	/**
	 * method to retrieve information from queue table in database
	 * 
	 * @param p
	 * @throws SQLException 
	 */
	public static void displayQueueData(Patient p) throws SQLException {

			// open connection to database
			conn = ConnectionFactory.getConnection();

			// create statement
			stmt = conn.createStatement();

			// result set to pull information from database
			ResultSet rs = stmt
					.executeQuery("select * from queueTime where NHSNumber = '"
							+ p.getNhsNumber() + "'");

			while (rs.next()) {

				// convert timestamp to String
				String ts = rs.getString("Timestamp");

				// print result set
				System.out.print(ts + "\t");

				// format for date time
				DateTimeFormatter formatter = DateTimeFormat
						.forPattern("yyyy-MM-dd HH:mm:ss");

				// convert string to Date-Time
				DateTime admitted = DateTime.parse(ts, formatter);

				// current Date-Time
				DateTime current = new DateTime();

				// boolean for waiting time > 25
				boolean wait;

				// see if waiting time > 25
				if (admitted.isAfter(current.minusMinutes(85))) {

					wait = false;

				} else {
					wait = true;
				}

				// print out boolean
				System.out.println(wait);

			}
			closeConnections();
		

	}

}
