package sortQueue;

import java.util.Comparator;

import objects.Patient;

/**
 * This comparator compares two patients by checking if they have been in the
 * queue for more than 25 mins
 * 
 * @author cgollogly
 */
public class PatientWaitTimeComparator implements Comparator<Patient> {

	/**
	 * method to compare patients based on whether they have been in the queue
	 * for greater than 25 minutes
	 */
	@Override
	public int compare(Patient p1, Patient p2) {
		if (p1.getWaitingTime() && !p2.getWaitingTime()) {
			return -1;
		} else if (!p1.getWaitingTime() && p2.getWaitingTime()) {
			return 1;
		}
		return 0;
	}
}
