package businessLayer;

import java.sql.SQLException;

import javafx.scene.control.TextField;
import dataAccessLayer.LoginDA;

public class BusinessAccessLogin {
	
	public boolean login(TextField usernameBox, TextField passwordBox) throws SQLException{
		return LoginDA.loginCredentials(usernameBox, passwordBox);
	}
	
	
	

}
