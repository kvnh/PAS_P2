/**
 * 
 */
package app;

import java.sql.Date;

/**
 * @author My Acer
 *
 */
public class Receptionist extends Staff {

	/**
	 * 
	 */
	public Receptionist() {
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
	public Receptionist(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork) {
		super(nhsNumber, title, firstName, lastName, dob, streetNumber,
				streetName, city, postCode, id, phone, atWork);
		// TODO Auto-generated constructor stub
	}

}
