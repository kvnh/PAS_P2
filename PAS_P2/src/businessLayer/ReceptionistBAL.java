package businessLayer;

import dataAccessLayer.ReceptionDA;
import javafx.collections.ObservableList;
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
	public static ObservableList<Patient> searchButtonBAL(String firstNameValue, String lastNameValue, String postCodeValue){
		return ReceptionDA.searchButton(firstNameValue, lastNameValue, postCodeValue);
	}

}
