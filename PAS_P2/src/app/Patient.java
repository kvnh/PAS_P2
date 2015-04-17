package app;

/**
 * class to represent a patient in the PAS
 * 
 * @author KHackett
 *
 */
public class Patient extends Person {

	/**
	 * Enum to represent triage status
	 */
	private Status triage;

	/**
	 * default constructor
	 */
	public Patient() {
	}

	/**
	 * constructor with args
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Patient(String nhsNumber, String title, String firstName,
			String lastName, String streetNumber, String streetName,
			String city, String postCode, Status triage) {
		super(nhsNumber, title, firstName, lastName, streetNumber, streetName,
				city, postCode);
		this.triage = triage;
	}

	/**
	 * 
	 * @return the triage
	 */
	public Status getTriage() {
		return triage;
	}

	/**
	 * 
	 * @param triage
	 *            the triage to set
	 */
	public void setTriage(Status triage) {
		this.triage = triage;
	}

	/**
	 * method to allow comparison of patients by triage status
	 * 
	 * @param p
	 * @return
	 */
	public int compareTriage(Patient p) {

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
