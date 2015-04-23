package sortQueue;

/**
 * This comparator compares two patients by checking if they have been in the queue for more than 25 mins
 * @author cgollogly
 */

import java.util.Comparator;

import objects.Patient;

public class PatientWaitTimeComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient p1, Patient p2) {
		if (p1.isWaitingTime() && !p2.isWaitingTime()) {
			return -1;
		} else if (!p1.isWaitingTime() && p2.isWaitingTime()) {
			return 1;
		}
		return 0;
	}
}
