/**
 * 
 */
package app;

import java.sql.Date;

/**
 * @author My Acer
 *
 */
public class Doctor extends Staff {

	private String speciality;
	
	private boolean isAvailable;
	
	/**
	 * 
	 */
	public Doctor() {
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
	public Doctor(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork, String speciality, boolean isAvailable) {
		super(nhsNumber, title, firstName, lastName, dob, streetNumber,
				streetName, city, postCode, id, phone, atWork);
		this.speciality = speciality;
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
