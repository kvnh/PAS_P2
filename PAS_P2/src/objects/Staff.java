/**
 * 
 */
package objects;

/**
 * Staff class that extends Person
 *
 */
public class Staff extends Person {

	/**
	 * int to represent staff id
	 */
	private int id;
	
	/**
	 * int to represent staff phone number
	 */
	private int phone;
	
	
	/**
	 * int to represent staff contact number
	 */
	
	/**
	 * default constructor
	 */
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Staff constructor with args
	 * 
	 * @param nhsNumber
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param streetNumber
	 * @param streetName
	 * @param city
	 * @param postCode
	 * @param phone
	 */
	public Staff(String nhsNumber, String title, String firstName,
			String lastName, String streetNumber, String streetName,
			String city, String postCode, int id, int phone) {
		super(nhsNumber, title, firstName, lastName, streetNumber, streetName,
				city, postCode);
		this.id = id;
		this.phone = phone;
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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

	
}
