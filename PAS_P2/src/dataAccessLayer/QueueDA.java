/**
 * 
 */
package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import models.DbUtil;
import objects.Patient;

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

	/**
	 * method to add patient details to database queue table
	 * 
	 * @param p
	 */
	public static void addToQueueTable(Patient p) {

		try {

			// open connection to database
			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			conn.setAutoCommit(false);

			// create statement
			stmt = conn.createStatement();

			String sql = "insert into queue values('" + p.getNhsNumber()
					+ "', CURRENT_TIMESTAMP)";

			// execute update
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			// close all open resources in the database
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}

	}

	/**
	 * method to remove patient details from database queue table
	 * 
	 * @param p
	 */
	public static void removeFromQueueTable(Patient p) {

		try {

			// open connection to database
			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			conn.setAutoCommit(false);

			// create statement
			stmt = conn.createStatement();

			String sql = "delete from queue where NHSNumber = '"
					+ p.getNhsNumber() + "'";

			// execute update
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			// close all open resources in the database
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}

	}

	/**
	 * method to retrieve information from queue table in database
	 * 
	 * @param p
	 */
	public static void displayQueueData(Patient p) {

		try {

			// open connection to database
			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			conn.setAutoCommit(false);

			// create statement
			stmt = conn.createStatement();

			// result set to pull information from database
			ResultSet rs = stmt
					.executeQuery("select * from queue where NHSNumber = '"
							+ p.getNhsNumber() + "'");

			while (rs.next()) {

				// convert timestamp to String
				String ts = rs.getString("admitted");

				// print result set
				System.out.print(rs.getString(1) + "\t");
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

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		} finally {
			// close all open resources in the database
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}

	}

}
