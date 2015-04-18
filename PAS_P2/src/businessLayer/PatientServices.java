package businessLayer;

import java.sql.SQLException;

import objects.Patient;
import dataAccessLayer.PatientDA;

/**
 * 
 * @author KHackett
 * Services layer class to create a patient
 */
public class PatientServices {

	/**
	 * Method to return a patient object from the DAL dependent on the NHS Number
	 * @param nhsNumber
	 * @return
	 * @throws SQLException
	 */
	public Patient getPatientByNHSNumber(String nhsNumber) throws SQLException {
		// send the nhsNumber from PatientInfoController class to the data access layer
		// and return as a value
		return PatientDA.createPatient(nhsNumber);
	}

}