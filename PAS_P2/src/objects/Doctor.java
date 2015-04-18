/**
 * 
 */
package objects;

import java.sql.Date;

/**
 * Doctor class that extends Staff
 * 
 * @author My Acer
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
		// TODO Auto-generated constructor stub
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
	 * @param atWork
	 */
	public Doctor(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork,
			String speciality) {
		super(nhsNumber, title, firstName, lastName, streetNumber,
				streetName, city, postCode, id, phone, atWork);
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