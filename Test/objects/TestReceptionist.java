package objects;

import static org.junit.Assert.*;
import objects.Receptionist;
import org.junit.Before;
import org.junit.Test;

public class TestReceptionist {

	String firstnameValid, firstnameInvalid, lastnameValid, lastnameInvalid,
			postCodeValid, postCodeInvalid, titleValid, titleInvalid,
			streetNameValid, streetNameInvalid, streetNumberValid,
			streetNumberInvalid, cityValid, cityInvalid, nhsNumberValid,
			nhsNumberInvalid;

	boolean atWork;

	int idValid, idInvalid, phoneValid, phoneInvalid;

	@Before
	public void setUp() throws Exception {
		firstnameValid = "validfirstName";
		firstnameInvalid = "invalidFirstname";
		lastnameValid = "validLastname";
		lastnameInvalid = "InvalidLastname";
		postCodeValid = "validPostcode";
		postCodeInvalid = "invalidPostcode";
		streetNameValid = "validStreetname";
		streetNameInvalid = "invalidStreetname";
		cityValid = "validCity";
		cityInvalid = "invalidCity";
		nhsNumberValid = "validNhsNum";
		nhsNumberInvalid = "invalidNhsNum";
		streetNumberValid = "validStreetNum";
		streetNumberInvalid = "invalidStreetNumber";
		titleValid = "validTitle";
		titleInvalid = "invalidTitle";

		idValid = 1;
		idInvalid = 0;
		phoneValid = 2;
		phoneInvalid = 3;

		atWork = true;

	}

	/**
	 * default constructor
	 */
	@Test
	public void testReceptionistConstuctorDefault() {
		Receptionist receptionist = new Receptionist();
		assertNotNull(receptionist);
	}

	/**
	 * constructor with args
	 */
	@Test
	public void testReceptionistNondefaultConstructor() {
		Receptionist receptionist = new Receptionist(firstnameValid,
				lastnameValid, postCodeValid, titleValid, streetNameValid,
				cityValid, nhsNumberValid, streetNumberValid, idValid,
				phoneValid, true);

		assertNotNull(receptionist);
		
	}

	/**
	 * test set get valid id
	 */
	@Test
	public void testGetSetIdValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setId(idValid);
		assertEquals(idValid, receptionist.getId());
	}

	/**
	 * test set get invalid id
	 */
	@Test
	public void testGetSetIdInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setId(idInvalid);
		assertEquals(idInvalid, receptionist.getId());
	}

	/**
	 * test set get valid phone number
	 */
	@Test
	public void testSetGetPhoneValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setPhone(phoneValid);
		assertEquals(phoneValid, receptionist.getPhone());
	}

	/**
	 * test set get invalid phone num
	 */
	@Test
	public void testSetGetPhoneInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setPhone(phoneInvalid);
		assertEquals(phoneInvalid, receptionist.getPhone());
	}

	/**
	 * test set get valid title
	 */
	@Test
	public void testSetGetTitleValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setTitle(titleValid);
		assertEquals(titleValid, receptionist.getTitle());
	}

	/**
	 * test set get invalid title
	 */
	@Test
	public void testSetGetTitleInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setTitle(titleInvalid);
		assertEquals(titleInvalid, receptionist.getTitle());
	}

	/**
	 * test set get valid first name
	 */
	@Test
	public void testSetGetFirstNameValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setFirstName(firstnameValid);
		assertEquals(firstnameValid, receptionist.getFirstName());
	}

	/**
	 * test set get invalid first name
	 */
	@Test
	public void testSetGetFirstNameInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setFirstName(firstnameInvalid);
		assertEquals(firstnameInvalid, receptionist.getFirstName());
	}

	/**
	 * test set get valid last name
	 */
	@Test
	public void testSetGetLastNameValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setLastName(lastnameValid);
		assertEquals(lastnameValid, receptionist.getLastName());
	}

	/**
	 * test set get invalid last name
	 */
	@Test
	public void testSetGetLastNameInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setLastName(lastnameInvalid);
		assertEquals(lastnameInvalid, receptionist.getLastName());
	}

	/**
	 * test set get valid NHS number
	 */
	@Test
	public void testSetGetNhsNumberValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setNhsNumber(nhsNumberValid);
		assertEquals(nhsNumberValid, receptionist.getNhsNumber());
	}

	/**
	 * test set get invalid NHS number
	 */
	@Test
	public void testSetGetNhsNumberInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setNhsNumber(nhsNumberInvalid);
		assertEquals(nhsNumberInvalid, receptionist.getNhsNumber());
	}

	/**
	 * test set get street number valid
	 */
	@Test
	public void testSetGetStreetNumberValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setStreetNumber(streetNumberValid);
		assertEquals(streetNumberValid, receptionist.getStreetNumber());
	}

	/**
	 * test set get street number invalid
	 */
	@Test
	public void testSetGetStreetNumberInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setStreetNumber(streetNumberInvalid);
		assertEquals(streetNumberInvalid, receptionist.getStreetNumber());
	}

	/**
	 * test set get valid street name
	 */
	@Test
	public void testSetGetStreetNameValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setStreetName(streetNameValid);
		assertEquals(streetNameValid, receptionist.getStreetName());
	}

	/**
	 * test set get invalid street name
	 */
	@Test
	public void testSetGetStreetNameInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setStreetName(streetNameInvalid);
		assertEquals(streetNameInvalid, receptionist.getStreetName());
	}

	/**
	 * test set get valid city
	 */
	@Test
	public void testSetGetCityValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setCity(cityValid);
		assertEquals(cityValid, receptionist.getCity());
	}

	/**
	 * test set get invalid city
	 */
	@Test
	public void testSetGetCityInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setCity(cityInvalid);
		assertEquals(cityInvalid, receptionist.getCity());
	}

	/**
	 * test set get valid post code
	 */
	@Test
	public void testSetGetPostCodeValid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setPostCode(postCodeValid);
		assertEquals(postCodeValid, receptionist.getPostCode());
	}

	/**
	 * test set get invalid post code
	 */
	@Test
	public void testSetGetPostCodeInvalid() {
		Receptionist receptionist = new Receptionist();
		receptionist.setPostCode(postCodeInvalid);
		assertEquals(postCodeInvalid, receptionist.getPostCode());
	}

}
