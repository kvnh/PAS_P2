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

		Connection c = null;
		Statement stmt = null;
			c = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			c.setAutoCommit(false);

			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LoginUsers WHERE USERNAME= " + "'" + usernameBox.getText()
					+ "'" + " AND PASSWORD= " + "'" + passwordBox.getText() + "'");

			while (rs.next()) {
				if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
					String username = rs.getString("USERNAME");
					System.out.println("USERNAME = " + username);
					String password = rs.getString("PASSWORD");
					System.out.println("PASSWORD = " + password);
					letIn = true;
				}
			}
			rs.close();
			stmt.close();
			c.close();
	
		System.out.println("isValidCredentials completed successfully");
		return letIn;
		
		/** Andrew Testing upload onto git */
	}

}
