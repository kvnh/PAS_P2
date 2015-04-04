package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TriageNurseHomePageController implements Initializable {
	@FXML
	private void btnAssess(ActionEvent event) throws IOException {
		System.out.println("Changing to patient assessment screen");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FXMLPatientAssessmentPage.fxml"));
		loader.setLocation(getClass().getResource("/views/FXMLPatientAssessmentPage.fxml"));
		loader.load();
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
