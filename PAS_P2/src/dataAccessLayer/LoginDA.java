package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.TextField;

/**
 * This class controls Data Access for Login page
 * 
 * @author Andrew Walmsley
 *
 */
public class LoginDA {

	/**
	 * static int to represent staff category
	 */
	public static int staffcat = 0;

	/**
	 * Connection variable to set up connection to database
	 */
	private static Connection conn = null;

	/**
	 * Statement variable to send statement to database
	 */
	private static Statement stmt = null;

	/**
	 * Method to send queries are made here and all exceptions are passed up the
	 * tiers/layers/levels
	 * 
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public static boolean loginCredentials(TextField usernameBox,
			TextField passwordBox) throws SQLException {
		// boolean to represent successfully login
		boolean letIn = false;

		// SQL query for user login
		System.out.println("SELECT * FROM LoginUsers WHERE USERNAME= " + "'"
				+ usernameBox.getText() + "'" + " AND PASSWORD= " + "'"
				+ passwordBox.getText() + "'");

		// set up connection to database
		conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
		// ensure manual commit
		conn.setAutoCommit(false);
		System.out.println("Opened connection successfully");

		// create statement
		stmt = conn.createStatement();

		// ResultSet object
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM LoginUsers WHERE USERNAME= " + "'"
						+ usernameBox.getText() + "'" + " AND PASSWORD= " + "'"
						+ passwordBox.getText() + "'");

		// while ResultSet has more items
		while (rs.next()) {
			// check if username and password input matches that in database
			if (rs.getString("USERNAME").equals(usernameBox.getText())
					&& rs.getString("PASSWORD").equals(passwordBox.getText())) {
				// assign username to String
				String username = rs.getString("USERNAME");
				System.out.println("USERNAME = " + username);
				// assign password to String
				String password = rs.getString("PASSWORD");
				System.out.println("PASSWORD = " + password);
				// assign staff category to String
				String staffcategory = rs.getString("STAFFCATEGORY");
				System.out.println("STAFF CATEGORY = " + staffcategory);

				// determine staff category and output as an int
				staffcat = Integer.parseInt(staffcategory);
				System.out.println("Staff category in int = " + staffcat);

				// successful login
				letIn = true;

				// else login has been unsuccessful
			} else {
				// alert user to unsuccessful login
				System.out.println("INVALID DETAILS");
				// unsuccessful login
				letIn = false;
			}
		}

		// close ResultSet
		rs.close();
		// close Statement
		stmt.close();
		// close Connection to database
		conn.close();

		// return successful login
		return letIn;
	}

	/**
	 * Method to load the correct scene will load depending on the user login
	 * details. For example Receptionist can access the
	 * ReceptionistPageController but not the TriageNurseHomePageController
	 * 
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public static int staffEntitlements(TextField usernameBox,
			TextField passwordBox) throws SQLException {

		// connect to database
		conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
		// ensure manual commit
		conn.setAutoCommit(false);

		System.out.println("Opened connection successfully");

		// create statement
		stmt = conn.createStatement();

		// select results from LoginUsers table
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM LoginUsers WHERE USERNAME= " + "'"
						+ usernameBox.getText() + "'" + " AND PASSWORD= " + "'"
						+ passwordBox.getText() + "'");

		// while ResultSet has more items
		while (rs.next()) {
			// check if username and password input matches that in database
			if (rs.getString("USERNAME").equals(usernameBox.getText())
					&& rs.getString("PASSWORD").equals(passwordBox.getText())) {
				// assign username to String
				String username = rs.getString("USERNAME");
				System.out.println("USERNAME = " + username);
				// assign password to String
				String password = rs.getString("PASSWORD");
				System.out.println("PASSWORD = " + password);
				// assign staff category to String
				String staffcategory = rs.getString("STAFFCATEGORY");
				System.out.println("STAFF CATEGORY = " + staffcategory);

				// convert staff category String to int
				staffcat = Integer.parseInt(staffcategory);
				System.out.println("Staff category in int = " + staffcat);

				// else invalid login details
			} else {
				System.out.println("INVALID DETAILS");
			}
		}

		// close ResultSet
		rs.close();
		// close Statement
		stmt.close();
		// close Connection
		conn.close();

		// return staff category
		return staffcat;
	}

}
