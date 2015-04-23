package sortQueue;

/**
 * This comparator compares two patients by have they already been in the queue
 * @author cgollogly
 */
import java.util.Comparator;

import objects.Patient;

public class PatientInQueueComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient p1, Patient p2) {
		if (p1.isPreviouslyInQueue() && !p2.isPreviouslyInQueue()) {
			return -1;
		} else if (!p1.isPreviouslyInQueue() && p2.isPreviouslyInQueue()) {
			return 1;
		}
		return 0;
	}
}
