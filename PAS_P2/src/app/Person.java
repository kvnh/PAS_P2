package app;

import java.sql.Date;

public abstract class Person {

	private String nhsNumbers;

	private String title;

	private String firstName;

	private String lastName;

	private Date dob;

	/**
	 * String to represent the street number of a patient
	 */
	private String streetNumber;

	/**
	 * String to represent the street name of a patient
	 */
	private String streetName;

	/**
	 * String to represent the city of a patient
	 */
	private String city;

	/**
	 * String to represent the post code of a patient
	 */
	private String postCode;

	/**
	 * default constructor
	 */
	public Person() {

	}

	/**
	 * constructor with arguments
	 */
	public Person(String nhsNumber, String title, String firstName,
			String lastName, Date dob, String streetNumber, String streetName,
			String city, String postCode) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postCode = postCode;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the nhsNumbers
	 */
	public String getNhsNumbers() {
		return nhsNumbers;
	}

	/**
	 * @param nhsNumbers
	 *            the nhsNumbers to set
	 */
	public void setNhsNumbers(String nhsNumbers) {
		this.nhsNumbers = nhsNumbers;
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber
	 *            the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 *            the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}
