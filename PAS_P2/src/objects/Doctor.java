
package objects;

import java.sql.Date;

/**
 * Class to represent Doctor that extends Staff
 * 
 * @author LConnolly
 *
 */
public class Doctor extends Staff {

	/**
	 * String to represent the doctors speciality
	 */
	private String speciality;

	/**
	 * default constructor
	 */
	public Doctor() {
	}

	/**
	 * Doctor constructor with args
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
	public Doctor(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, int id, int phone,
			String speciality) {
		super(nhsNumber, title, firstName, lastName, streetNumber,
				streetName, city, postCode, id, phone);
		this.speciality = speciality;
	}

	/**
	 * @return the speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality
	 *            the speciality to set
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}