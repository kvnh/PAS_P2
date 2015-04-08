package app;

import java.sql.Date;

/**
 * class to represent a patient in the PAS
 * 
 * @author KHackett
 *
 */
public class Patient1 extends Person {

	/**
	 * Enum to represent triage status
	 */
	private Status triage;

	/**
	 * default constructor
	 */
	public Patient1() {
	}

	/**
	 * constructor with args
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Patient1(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, Status triage) {
		super(nhsNumber, title, firstName, lastName, dob, streetNumber,
				streetName, city, postCode);
		this.triage = triage;
	}

	public Status getTriage() {
		return triage;
	}

	public void setTriage(Status triage) {
		this.triage = triage;
	}

	/**
	 * method to allow comparison of patients by triage status
	 * 
	 * @param p
	 * @return
	 */
	public int compareTriage(Patient1 p) {

		Status compare = p.triage;

		if (this.triage.equals(compare)) {
			// if triage status is same, add to next slot in queue
			return 0;
		} else if (this.triage.compareTo(compare) > 0) {
			// if triage status is greater add above
			return 1;

		} else {
			// if triage status is less, add below.
			return -1;
		}
	}

}
