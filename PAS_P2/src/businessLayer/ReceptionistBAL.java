package businessLayer;

import java.sql.SQLException;

import dataAccessLayer.ReceptionDA;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import objects.Patient;

/**
 * 
 * @author Andrew Walmsley
 * Class handels the interactions between the ReceptionistSearchTabController and the ReceptionDA
 */
public class ReceptionistBAL {
	
	/**
	 * Retrieves data from the back end when the search button is selected
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 * @throws SQLException 
	 */
	public ObservableList<Patient> searchButtonBAL(String firstNameValue, String lastNameValue, String postCodeValue) throws SQLException{
		return ReceptionDA.searchButton(firstNameValue, lastNameValue, postCodeValue);
	}
	
	/**
	 * Retrieves patient data that matches with the entered postcode.
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 * @throws SQLException 
	 */
	public ObservableList<Patient>  postCodeSearchBAL(String firstNameValue, String lastNameValue, String postCodeValue) throws SQLException{
		return ReceptionDA.postCodeSearch(firstNameValue, lastNameValue, postCodeValue);	
	}
	
	/**
	 * Clear all data from the visible table
	 */
	public void clearTableBAL(){
		ReceptionDA.clearTable();
	}
	
	/**
	 * Retrieve the patient info when the search starts
	 * @throws SQLException 
	 */
	public Patient patientInfoBAL(TableView<?> tableView) throws SQLException{
		return ReceptionDA.retrievePatientInfo(tableView);
	}
}
