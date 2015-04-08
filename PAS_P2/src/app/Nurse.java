/**
 * 
 */
package app;

import java.sql.Date;

/**
 * @author My Acer
 *
 */
public class Nurse extends Staff {

	private boolean isTriage;
	
	/**
	 * 
	 */
	public Nurse() {
		// TODO Auto-generated constructor stub
	}

	/**
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
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork, boolean isTriage) {
		super(nhsNumber, title, firstName, lastName, dob, streetNumber,
				streetName, city, postCode, id, phone, atWork);
		this.isTriage = isTriage;
	}

	public boolean isTriage() {
		return isTriage;
	}

	public void setTriage(boolean isTriage) {
		this.isTriage = isTriage;
	}

}
