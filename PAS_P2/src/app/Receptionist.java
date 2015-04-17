/**
 * 
 */
package app;

/**
 * @author My Acer
 *
 */
public class Receptionist extends Staff {

	/**
	 * default constructor
	 */
	public Receptionist() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Receptionist constructor with args
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
	public Receptionist(String title, String nhsNumber, String firstName,
			String lastName, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork) {
		super(title, nhsNumber, firstName, lastName, streetNumber, streetName,
				city, postCode, id, phone, atWork);
	}

}
