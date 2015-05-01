package businessLayer;

import java.sql.SQLException;

import javafx.scene.control.TextField;
import dataAccessLayer.Encrypt;
import dataAccessLayer.LoginDA;

/**
 * 
 * @author Andrew Walmsley Middle Tier logic - BusinessLogic
 */
public class LoginBAL {

	/**
	 * Method passes the parameters to Data Access where all Database queries
	 * are made. Result of those queries are then passed back to the front end.
	 * 
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public boolean login(TextField usernameBox, TextField passwordBox)
			throws SQLException {

		// string to represent password
		String password = passwordBox.getText();

		// string to text field
		passwordBox.setText(Encrypt.encode(password));
		System.out.println(Encrypt.encode(password));
		return LoginDA.loginCredentials(usernameBox, passwordBox);
	}

	/**
	 * Method to determine staff access levels
	 * 
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public int staffAccess(TextField usernameBox, TextField passwordBox)
			throws SQLException {
		return LoginDA.staffEntitlements(usernameBox, passwordBox);

	}

}
