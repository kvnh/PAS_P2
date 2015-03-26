package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;


public class PatientInfoController implements Initializable {


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Button to send user back to receptionist homepage
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnCancel(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			stage.close();
		}

	/**
	 * Button to confirm patient and send them to triage/waiting queue
	 * @param event
	 */
	@FXML
	private void btnConfirm(ActionEvent event) {

	}
	
}
