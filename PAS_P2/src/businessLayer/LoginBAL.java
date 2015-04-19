package businessLayer;

import java.sql.SQLException;

import javafx.scene.control.TextField;
import dataAccessLayer.LoginDA;

/**
 * 
 * @author Andrew Walmsley
 *	Middle Tier logic aka BusinessLogic
 */
public class LoginBAL {
	
	/**
	 * Method passes the parameters to Data Access where all Database queries are made
	 * Result of those queries are then passed back to the front.
	 * @param usernameBox
	 * @param passwordBox
	 * @return
	 * @throws SQLException
	 */
	public boolean login(TextField usernameBox, TextField passwordBox) throws SQLException{
		return LoginDA.loginCredentials(usernameBox, passwordBox);
	}
	
	public int staffAccess(TextField usernameBox, TextField passwordBox) throws SQLException{
		return LoginDA.staffEntitlements(usernameBox, passwordBox);
		
	}

}
