/**
 * 
 */
package app;

/**
 * Nurse class that extends Staff
 * 
 * @author My Acer
 *
 */
public class Nurse extends Staff {

	/**
	 * boolean to determine whether or not the nurse is a triage nurse
	 */
	private boolean isTriage;

	/**
	 * default constructor
	 */
	public Nurse() {

	}

	/**
	 * Nurse constructor with args
	 * 
	 * @param nhsNumber
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param streetNumber
	 * @param streetName
	 * @param city
	 * @param postCode
	 * @param id
	 * @param phone
	 * @param atWork
	 */
	public Nurse(String nhsNumber, String title, String firstName,
			String lastName, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork,
			boolean isTriage) {
		super(nhsNumber, title, firstName, lastName, streetNumber, streetName,
				city, postCode, id, phone, atWork);
		this.isTriage = isTriage;
	}

	/**
	 * @return the isTriage
	 */
	public boolean isTriage() {
		return isTriage;
	}

	/**
	 * @param isTriage
	 *            the isTriage to return
	 */
	public void setTriage(boolean isTriage) {
		this.isTriage = isTriage;
	}

}
