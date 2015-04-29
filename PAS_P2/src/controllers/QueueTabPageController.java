package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import objects.Patient;
import app.Queue;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'FXMLQueueTabPage.fxml'";

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
		timeEnteredColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("timeEnteredString"));
		triageAssessmentColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("triage"));

		// display the current queue to screen when opening page each time
		displayQueue(Queue.queue);

	}

	/**
	 * button to send user back to login screen
	 * @param event
	 * @throws Exception
	 */
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

	/**
	 * Refresh button will update to screen the latest patient queue
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnRefreshQueueClick(ActionEvent event) throws IOException {
		displayQueue(Queue.queue);
		Queue.sortQueue();
	}

	/**
	 * method to populate the latest queue information in a table view for display
	 * @param queue
	 */
	public void displayQueue(LinkedList<Patient> queue) {

		Task updateTable = new Task() {
			@Override
			protected Object call() throws Exception {
				while (!isCancelled()) {
					// update your ObservableList
					tableData = FXCollections.observableArrayList(queue);
					tableView.setItems(tableData);

					// hide the columns that are not updating
					// reshow the columns
					Runnable r = () -> {
						tableView.getColumns().get(0).setVisible(false);
						tableView.getColumns().get(0).setVisible(true);
					};

					// wrap update tableView
					Platform.runLater(r);

					Thread.sleep(5000);
				}
				return null;
			}
		};
		Thread t = new Thread(updateTable);
		t.setDaemon(true);
		t.start();
	}

}