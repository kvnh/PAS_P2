package businessLayer;

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
	 */
	public  ObservableList<Patient> searchButtonBAL(String firstNameValue, String lastNameValue, String postCodeValue){
		return ReceptionDA.searchButton(firstNameValue, lastNameValue, postCodeValue);
	}
	
	/**
	 * Retrieves patient data that matches with the entered postcode.
	 * @param firstNameValue
	 * @param lastNameValue
	 * @param postCodeValue
	 * @return
	 */
	public ObservableList<Patient>  postCodeSearchBAL(String firstNameValue, String lastNameValue, String postCodeValue){
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
	 */
	public Patient patientInfoBAL(TableView<?> tableView){
		return ReceptionDA.retrievePatientInfo(tableView);
	}
}
