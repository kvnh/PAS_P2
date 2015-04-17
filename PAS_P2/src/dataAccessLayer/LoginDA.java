package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.TextField;

/**
 * 
 * @author Andrew Walmsley
 *
 */
public class LoginDA {
	
	public static int staffcat = 0;
	
	private static Connection conn = null;
	private static Statement stmt = null;

	/**
	 * Queries are made here and ALL exceptions are thrown up the tiers/layers/levels...
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public static boolean loginCredentials(TextField usernameBox, TextField passwordBox) throws SQLException {
		boolean letIn = false;
		System.out.println("SELECT * FROM LoginUsers WHERE USERNAME= " + "'" + usernameBox.getText() + "'"
				+ " AND PASSWORD= " + "'" + passwordBox.getText() + "'");

			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			conn.setAutoCommit(false);
			System.out.println("Opened connection successfully");
			
			stmt = conn.createStatement();
			

			ResultSet rs = stmt.executeQuery("SELECT * FROM LoginUsers WHERE USERNAME= " + "'" + usernameBox.getText()
					+ "'" + " AND PASSWORD= " + "'" + passwordBox.getText() + "'");
		
			while (rs.next()) {
				if (rs.getString("USERNAME").equals(usernameBox.getText()) && 
						rs.getString("PASSWORD").equals(passwordBox.getText())) {
					String username = rs.getString("USERNAME");
					System.out.println("USERNAME = " + username);
					String password = rs.getString("PASSWORD");
					System.out.println("PASSWORD = " + password);
					String staffcategory = rs.getString("STAFFCATEGORY");
					System.out.println("STAFF CATEGORY = "+ staffcategory);
					
					staffcat = Integer.parseInt(staffcategory);
					System.out.println("Staff category in int = "+ staffcat);
					
					letIn = true;
				}else{
					System.out.println("INVALID DETAILS");
					letIn = false;
				}
			}
			rs.close();
			stmt.close();
			conn.close();
	
		return letIn;
	}
	
	/**
	 * Correct homepage will load depending on the user login details.
	 * For example Receptionist can access the ReceptionistPageController 
	 * but not the TriageNurseHomePageController
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public static int staffEntitlements(TextField usernameBox, TextField passwordBox) throws SQLException {


			conn = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			conn.setAutoCommit(false);
			System.out.println("Opened connection successfully");
			
			stmt = conn.createStatement();
			

			ResultSet rs = stmt.executeQuery("SELECT * FROM LoginUsers WHERE USERNAME= " + "'" + usernameBox.getText()
					+ "'" + " AND PASSWORD= " + "'" + passwordBox.getText() + "'");
		
			while (rs.next()) {
				if (rs.getString("USERNAME").equals(usernameBox.getText()) && 
						rs.getString("PASSWORD").equals(passwordBox.getText())) {
					String username = rs.getString("USERNAME");
					System.out.println("USERNAME = " + username);
					String password = rs.getString("PASSWORD");
					System.out.println("PASSWORD = " + password);
					String staffcategory = rs.getString("STAFFCATEGORY");
					System.out.println("STAFF CATEGORY = "+ staffcategory);
					
					staffcat = Integer.parseInt(staffcategory);
					System.out.println("Staff category in int = "+ staffcat);
					
				}else{
					System.out.println("INVALID DETAILS");
				}
			}
			rs.close();
			stmt.close();
			conn.close();
	
		return staffcat;
	}
	

}
