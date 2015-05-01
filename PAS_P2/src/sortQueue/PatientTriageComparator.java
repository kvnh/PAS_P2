package sortQueue;

import java.util.Comparator;

import objects.Patient;

/**
 * This comparator compares two patients by triage status
 * 
 * @author cgollogly
 */

public class PatientTriageComparator implements Comparator<Patient> {

	/**
	 * method to compare patients based on triage status (enum)
	 */
	@Override
	public int compare(Patient p1, Patient p2) {
		return p1.getTriage().compareTo(p2.getTriage());
	}

}
