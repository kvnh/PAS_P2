package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import org.joda.time.DateTime;
import objects.Patient;
import app.Queue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dataAccessLayer.QueueDA;

public class QueueTabPageController implements Initializable {

	@FXML
	private TableView<Patient> tableView;

	@FXML
	private TableColumn<Patient, String> firstNameColumn;

	@FXML
	private TableColumn<Patient, String> lastNameColumn;

	@FXML
	private TableColumn<Patient, String> timeEnteredColumn;

	@FXML
	private TableColumn<Patient, String> triageAssessmentColumn;

	@FXML
	private QueueTabPageController queueTabPageController;

	private ObservableList<Patient> tableData;

	// public static LinkedList<Patient> displayQueue;

	/**
	 * Currently no database connections on this page.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'FXMLQueueTabPage.fxml'";

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
		timeEnteredColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("time"));
		triageAssessmentColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("triage"));

		
		// The Queue needs to be constantly updating 
		// display the current queue to screen when opening page each time
		displayQueue(Queue.queue);

	}

	/**
	 * Problem right here as it is not communicating with the database when it should be.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnRefreshQueueClick(ActionEvent event) throws IOException {
		displayQueue(Queue.queue);
	}

	/**
	 * displays the queue
	 */
	public void displayQueue(LinkedList<Patient> queue) {
		tableData = FXCollections.observableArrayList(queue);
		tableView.setItems(tableData);
	}

}