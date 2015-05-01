package app;

/**
 * enum to represent possible values for triage status
 * @author Fergus
 *
 */
public enum Status {

	// decalre ENUM values for traige categories
	EMERGENCY("Emergency"), URGENT("Urgent"), SEMI_URGENT("Semi-urgent"), NON_URGENT("Non-urgent"), NOT_ASSESSED(
			"Not-assessed");

	/**
	 * variable to represent the status as a string
	 */
	final String name;

	/**
	 * set status to string
	 * @param s
	 */
	Status(String s) {
		name = s;
	}
	
	/**
	 * return status as a string
	 */
	public String toString() {
		return name;
	}

}