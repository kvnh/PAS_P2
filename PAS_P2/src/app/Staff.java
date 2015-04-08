/**
 * 
 */
package app;

import java.sql.Date;

/**
 * 
 *
 */
public class Staff extends Person {

	private int id;
	
	private int phone;
	
	private boolean atWork;
	
	/**
	 * default constructor
	 */
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor with args
	 * @param nhsNumber
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param streetNumber
	 * @param streetName
	 * @param city
	 * @param postCode
	 */
	public Staff(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode, int id, int phone, boolean atWork) {
		super(nhsNumber, title, firstName, lastName, dob, streetNumber,
				streetName, city, postCode);
		this.id = id;
		this.phone = phone;
		this.atWork = atWork;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the atWork
	 */
	public boolean isAtWork() {
		return atWork;
	}

	/**
	 * @param atWork the atWork to set
	 */
	public void setAtWork(boolean atWork) {
		this.atWork = atWork;
	}

}
