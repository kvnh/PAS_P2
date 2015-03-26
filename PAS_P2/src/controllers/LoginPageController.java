package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
	private Button button;

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		System.out.println("Login button selected");
		Parent homePageParent = FXMLLoader.load(getClass().getResource("/views/FXMLReceptionistHomePage.fxml"));
		Scene homePageScene = new Scene(homePageParent);
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		if (isValidCredentials()) {
			appStage.hide(); // optional
			appStage.setScene(homePageScene);
			appStage.show();
		} else {
			usernameBox.clear();
			passwordBox.clear();
			invalidLabel.setText("Sorry, invalid credentials");
		}
	}

	private boolean isValidCredentials() {
		boolean letIn = false;
		System.out.println("SELECT * FROM LoginUsers WHERE USERNAME= " + "'" + usernameBox.getText() + "'"
				+ " AND PASSWORD= " + "'" + passwordBox.getText() + "'");

		Connection c = null;
		Statement stmt = null;
		try {
			c = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
			c.setAutoCommit(false);

			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LoginUsers WHERE USERNAME= " + "'" + usernameBox.getText()
					+ "'" + " AND PASSWORD= " + "'" + passwordBox.getText() + "'");

			while (rs.next()) {
				if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
					String username = rs.getString("USERNAME");
					System.out.println("USERNAME = " + username);
					String password = rs.getString("PASSWORD");
					System.out.println("PASSWORD = " + password);
					letIn = true;
				}
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("isValidCredentials completed successfully");
		return letIn;
		
		/** Andrew Testing upload onto git */
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
