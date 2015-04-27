package objects;

/**
 * Class to represent Nurse that extends Staff
 * 
 * @author LConnolly
 *
 */
public class Nurse extends Staff {

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
	 */
	public Nurse(String nhsNumber, String title, String firstName,
			String lastName, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork) {
		super(nhsNumber, title, firstName, lastName, streetNumber, streetName,
				city, postCode, id, phone);
	}

}
