package controllers;

import java.net.URL;
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
import javafx.stage.Stage;

/**
 * class to represent the doctor assessment page controller
 * 
 * @author Fergus
 *
 */
public class DoctorAssessmentPageController implements Initializable {

	@FXML
	private Label triageCategoryLabel;
	@FXML
	private Label nhsNumberLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label bloodTypeLabel;
	@FXML
	private Label allergiesLabel;
	@FXML
	private Button btnExtend5mins;

	/**
	 * method to populate fields in page
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * method to represent log out button
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void btnLogout(ActionEvent event) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		// set location
		loader.setLocation(getClass().getResource("/views/FXMLLoginPage.FXML"));
		loader.load();
		Parent p = loader.getRoot();
		// create new stage
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.show();
		// centre screen
		stage.centerOnScreen();
		// hides current page
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}