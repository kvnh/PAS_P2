package app;

/**
 * class to represent a patient in the PAS
 * @author KHackett
 *
 */
public class Patient {

	/**
	 * String to represent the NHS number of patient
	 */
	private String nhsNumber;

	/**
	 * String to represent the title of a patient
	 */
	private String title;

	/**
	 * String to represent the first name of patient
	 */
	private String firstName;

	/**
	 * String to represent the last name of a patient
	 */
	private String lastName;

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
	public Patient() {
	}

	/**
	 * constructor with args
	 * @param firstName
	 * @param lastName
	 */
	public Patient(String firstName, String lastName, String nhsNumber, String title, String streetNumber,
			String streetName, String city, String postCode) {
		this.nhsNumber = nhsNumber;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postCode = postCode;
	}

	/**
	 * @return the nhsNumber
	 */
	public String getNhsNumber() {
		return nhsNumber;
	}

	/**
	 * @param nhsNumber the nhsNumber to set
	 */
	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber = nhsNumber;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
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
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber the streetNumber to set
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
	 * @param streetName the streetName to set
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
	 * @param city the city to set
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
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}