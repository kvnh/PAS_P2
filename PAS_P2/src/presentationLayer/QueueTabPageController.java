package presentationLayer;

import java.net.URL;
import java.util.ResourceBundle;

import app.Patient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class QueueTabPageController implements Initializable {
	
	@FXML
	private TableView<Patient> tableView;
	
	@FXML
	private TableColumn firstNameColumn;
	
	@FXML
	private TableColumn lastNameColumn;
	
	@FXML
	private TableColumn postCodeColumn;
	
	@FXML
	private TableColumn triageCategoryColumn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	
	
	

}
