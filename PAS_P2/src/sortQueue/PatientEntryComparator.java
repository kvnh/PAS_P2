package sortQueue;

import java.util.Comparator;

import objects.Patient;

/**
 * This method compares two patients by their time in Queue
 */
public class PatientEntryComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient p1, Patient p2) {

		
		// if patient 1 timeEntered is before patient 2 time entered
		if (p1.getTimeEntered().isBefore(p2.getTimeEntered())) {
			// return 1 before 2
			return -1;
			
		// else patient 2 timeEntered is before patient 1 timeEntered	
		} else if (p2.getTimeEntered().isBefore(p1.getTimeEntered())) {
			// return 2 before 1
			return 1;
		} else {

			return 0;
		}
	}
}
