package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import app.TreatmentRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		triageCategoryLabel.setText((TreatmentRoom.treat[0].getPatient().getTriage().toString()));
		nhsNumberLabel.setText(TreatmentRoom.treat[0].getPatient().getNhsNumber());
		titleLabel.setText(TreatmentRoom.treat[0].getPatient().getTitle());
		firstNameLabel.setText(TreatmentRoom.treat[0].getPatient().getFirstName());
		lastNameLabel.setText(TreatmentRoom.treat[0].getPatient().getLastName());
		bloodTypeLabel.setText(TreatmentRoom.treat[0].getPatient().getBloodType());
		allergiesLabel.setText(TreatmentRoom.treat[0].getPatient().getAllergies());
	}

	@FXML
	private void btnLogout(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/FXMLLoginPage.FXML"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.show();
		stage.centerOnScreen();
		// hides current page
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	private void btnExtend5minsClick(ActionEvent event) throws Exception {
	}

}