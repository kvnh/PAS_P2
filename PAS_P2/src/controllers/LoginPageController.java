package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import businessLayer.BusinessAccessLogin;

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
	private Label attemptLabel;
	
	@FXML
	private Button button;

	private Parent homePageParent;
	private Scene homePageScene;
	private Stage appStage;

	/**
	 * Object needed to be created to communicate with the Business Layer from
	 * this GUI layer
	 */
	public BusinessAccessLogin bal = new BusinessAccessLogin();
	private int count = 0;

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		System.out.println("Login button selected");
		homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLReceptionistHomePage.fxml"));
		homePageScene = new Scene(homePageParent);
		appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				/*
		 * All Exceptions caught at the GUI not at the other two layers.
		 */
		try {
			/*
			 *  Reference 'bal' to Object BusinessAccessLogin sends parameters to Business Layer
			 *  calling method login() which passes the TextBox parameters usernameBox and passwordBox 
			 *  down the layers.
			 */
		
			if (bal.login(usernameBox, passwordBox) && (count <= 3)) {
				appStage.hide(); // optional
				appStage.setScene(homePageScene);
				appStage.show();
			} else {
				usernameBox.clear();
				passwordBox.clear();
				count++;
				invalidLabel.setText("Sorry, invalid details");
				
				if(count > 3){
					invalidLabel.setText("You have been locked out of system");
					appStage.close();
				
				}
				attemptLabel.setText("ATTEMPTS LEFT : "+count);
				System.out.println("ATTEMPTS LEFT : "+count);
				}
				
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Enter key event for password text field
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handlePasswordBox(ActionEvent event) throws IOException {

	}

	/**
	 * Enter key event for username text field
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handleUsernameBox(ActionEvent event) throws IOException {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
