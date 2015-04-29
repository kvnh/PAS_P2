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
import businessLayer.LoginBAL;

/**
 * 
 * @author Andrew Walmsley
 *
 */
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
	 * Object needed to be created to communicate 
	 * with the Business Layer from
	 * this GUI layer
	 */
	public LoginBAL bal = new LoginBAL();
	private int count = 4;

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		System.out.println("Login button selected");
	
		/*
		 * All Exceptions caught at the GUI not at the other two layers.
		 */
		try {
			/*
			 * Reference 'bal' to Object BusinessAccessLogin sends parameters to Business Layer
			 * calling method login() which passes the TextBox parameters usernameBox and
			 * passwordBox down the layers.
			 */
			if (bal.login(usernameBox, passwordBox) && (count > 0)) {
				
				/*
				 * Switch statement so that: user cat 1 -> Reception screen;
				 * user cat 2 'Nurses' -> triage screen ; & user cat 3 'Doctors -> treatment room 
				 */
			
				switch(bal.staffAccess(usernameBox, passwordBox)){
				case 1:
					System.out.println("Staff Category ONE");
					homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLReceptionistPage.fxml"));
					homePageScene = new Scene(homePageParent);
					appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					break;
				case 2:
					System.out.println("Staff Category TWO");
					homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLTriageNurseHomePage.fxml"));
					homePageScene = new Scene(homePageParent);
					appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					break;
				case 3:
					System.out.println("Staff Category THREE");
					homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLDoctorAssessmentPage.fxml"));
					homePageScene = new Scene(homePageParent);
					appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					break;
				case 4:
					System.out.println("Staff Category FOUR");
					homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLHospitalManagerPage.fxml"));
					homePageScene = new Scene(homePageParent);
					appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					break;
				}
				
				appStage.setScene(homePageScene);
				appStage.show();
				appStage.centerOnScreen();
				appStage.setMaximized(true);
				
			} else {
				usernameBox.clear();
				passwordBox.clear();
				--count;
				invalidLabel.setText("Sorry, invalid details");

				if (count < 1) {
					invalidLabel.setText("You have been locked out of system");
					appStage.close();

				}
				attemptLabel.setText("ATTEMPTS LEFT : " + count);
				System.out.println("ATTEMPTS LEFT : " + count);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println(e.getMessage());
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

	public static void displayTriage(){
	}

}