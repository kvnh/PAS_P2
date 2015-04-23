package sortQueue;

/**
 * This comparator compares two patients by triage status
 * @author cgollogly
 */

import java.util.Comparator;

import objects.Patient;

public class PatientTriageComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient p1, Patient p2) {
		return p1.getTriage().compareTo(p2.getTriage());
	}

}

