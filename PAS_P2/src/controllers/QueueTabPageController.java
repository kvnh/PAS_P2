package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.Patient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class QueueTabPageController implements Initializable {

	@FXML
	private TableView<Patient> tableView;

	@FXML
	private TableColumn<Patient, String> firstNameColumn;

	@FXML
	private TableColumn<Patient, String> lastNameColumn;

	@FXML
	private TableColumn<Patient, String> postCodeColumn;

	// @FXML
	// private TableColumn<Patient, String> triageCategoryColumn;
	
	@FXML
	private QueueTabPageController FXMLQueueTabPage;

	private ObservableList<Patient> tableData;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'FXMLQueueTabPage.fxml'";
		
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
		postCodeColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("postCode"));
		// triageCategoryColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("triage"));
		
	}

	public void displayQueue(List<Patient> queue) {

		tableData = FXCollections.observableArrayList(queue);
		tableView.setItems(tableData);
	}
	
//	void refreshTable() {
//	    final List<Patient> items = tableView.getItems();
//	    if( items == null || items.size() == 0) return;
//
//	    final Patient item = tableView.getItems().get(0);
//	    items.remove(0);
//	    Platform.runLater(new Runnable(){
//	        @Override
//	        public void run() {
//	            items.add(0, item);
//	        }
//	    });
//	 }
}