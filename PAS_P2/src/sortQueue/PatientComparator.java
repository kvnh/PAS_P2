package sortQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import objects.Patient;

/**
 * This is a chained comparator that is used to sort a list by multiple
 * attributes by chaining a sequence of comparators of individual fields
 * together.
 * 
 * @author cgollogly
 *
 */

public class PatientComparator implements Comparator<Patient> {

	// list of comparators
	private List<Comparator<Patient>> listComparators;

	@SafeVarargs
	public PatientComparator(Comparator<Patient>... comparators) {
		this.listComparators = Arrays.asList(comparators);
	}

	/**
	 * method to compare patinets based on several attributes
	 */
	@Override
	public int compare(Patient p1, Patient p2) {
		for (Comparator<Patient> comparator : listComparators) {
			int result = comparator.compare(p1, p2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}

}
