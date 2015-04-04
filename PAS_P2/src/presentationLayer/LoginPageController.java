package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import businessLayer.BusinessAccessLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginPageController implements Initializable {

	public LoginPageController() {
	}

	@FXML
	private Label label;
	@FXML
	private AnchorPane homePage;
	@FXML
	private TextField usernameBox;
	@FXML
	private TextField passwordBox;
	@FXML
	private Label invalidLabel;
	@FXML
	private Button button;
	
	/**
	 * Object needed to be created to communicate with the Business Layer from this GUI layer
	 */
	public BusinessAccessLogin bal = new BusinessAccessLogin();

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		System.out.println("Login button selected");
		Parent homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLReceptionistHomePage.fxml"));
		Scene homePageScene = new Scene(homePageParent);
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		/*
		 * All Exceptions caught at the GUI not at the other two layers.
		 */
		try {
			/*
			 *  Reference 'bal' to Object BusinessAccessLogin sends parameters to Business Layer
			 *  calling method login() which passes the TextBox parameters usernameBox and passwordBox 
			 *  down the layers.
			 */
			if (bal.login(usernameBox, passwordBox)) {
				appStage.hide(); // optional
				appStage.setScene(homePageScene);
				appStage.show();
			} else {
				usernameBox.clear();
				passwordBox.clear();
				invalidLabel.setText("Sorry, invalid credentials");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Enter key event for password text field
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handlePasswordBox(ActionEvent event) throws IOException {
		System.out.println("Login button selected");
		Parent homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLReceptionistHomePage.fxml"));
		Scene homePageScene = new Scene(homePageParent);
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		/*
		 * All Exceptions caught at the GUI not at the other two layers.
		 */
		try {
			
			/*
			 *  Reference 'bal' to Object BusinessAccessLogin sends parameters to Business Layer
			 *  calling method login() which passes the TextBox parameters usernameBox and passwordBox 
			 *  down the layers.
			 */
			if (bal.login(usernameBox, passwordBox)) {
				appStage.hide(); // optional
				appStage.setScene(homePageScene);
				appStage.show();
			} else {
				usernameBox.clear();
				passwordBox.clear();
				invalidLabel.setText("Sorry, invalid credentials");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Enter key event for username text field
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handleUsernameBox(ActionEvent event) throws IOException {
		System.out.println("Login button selected");
		Parent homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLReceptionistHomePage.fxml"));
		Scene homePageScene = new Scene(homePageParent);
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		BusinessAccessLogin bal = new BusinessAccessLogin();
		/*
		 * All Exceptions caught at the GUI not at the other two layers.
		 */
		try {
			/*
			 *  Reference 'bal' to Object BusinessAccessLogin sends parameters to Business Layer
			 *  calling method login() which passes the TextBox parameters usernameBox and passwordBox 
			 *  down the layers.
			 */
			if (bal.login(usernameBox, passwordBox)) {
				appStage.hide(); // optional
				appStage.setScene(homePageScene);
				appStage.show();
			} else {
				usernameBox.clear();
				passwordBox.clear();
				invalidLabel.setText("Sorry, invalid credentials");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
