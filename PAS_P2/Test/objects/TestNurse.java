package objects;

import static org.junit.Assert.*;

import java.util.Date;

import objects.Nurse;

import org.junit.Before;
import org.junit.Test;

public class TestNurse {
	String firstnameValid, firstnameInvalid, lastnameValid, lastnameInvalid,
			postCodeValid, postCodeInvalid, titleValid, titleInvalid,
			streetNameValid, streetNameInvalid, streetNumberValid,
			streetNumberInvalid, cityValid, cityInvalid, nhsNumberValid,
			nhsNumberInvalid;

	int idValid, idInvalid, phoneValid, phoneInvalid;

	boolean atWork, notAtWork;

	Date dob;

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
		notAtWork = false;
	}

	/**
	 * default constructor
	 */
	@Test
	public void testNurseConstuctorDefault() {
		Nurse nurse = new Nurse();
		assertNotNull(nurse);
	}

	/**
	 * non default constructor
	 */
	@Test
	public void testNurseNondefaultConstructor() {
		Nurse nurse = new Nurse(titleValid, firstnameValid, lastnameValid,
				null, streetNumberValid, streetNameValid, cityValid,
				postCodeValid, idValid, phoneValid, true);

		assertNotNull(nurse);
		

	}

	/**
	 * test set get valid id
	 */
	@Test
	public void testSetGetIdValid() {
		Nurse nurse = new Nurse();
		nurse.setId(idValid);
		assertEquals(idValid, nurse.getId());
	}

	/**
	 * test set get invalid id
	 */
	@Test
	public void testSetGetIdInvalid() {
		Nurse nurse = new Nurse();
		nurse.setId(idInvalid);
		assertEquals(idInvalid, nurse.getId());
	}

	/**
	 * test set get valid phone number
	 */
	@Test
	public void testSetGetPhoneValid() {
		Nurse nurse = new Nurse();
		nurse.setPhone(phoneValid);
		assertEquals(phoneValid, nurse.getPhone());

	}

	/**
	 * test set get invalid phone number
	 */
	@Test
	public void testSetGetPhoneInvalid() {
		Nurse nurse = new Nurse();
		nurse.setPhone(phoneInvalid);
		assertEquals(phoneInvalid, nurse.getPhone());
	}

	/**
	 * test set get valid title
	 */
	@Test
	public void testSetGetTitleValid() {
		Nurse nurse = new Nurse();
		nurse.setTitle(titleValid);
		assertEquals(titleValid, nurse.getTitle());

	}

	/**
	 * test set get invalid title
	 */
	@Test
	public void testSetGetTitleInvalid() {
		Nurse nurse = new Nurse();
		nurse.setTitle(titleInvalid);
		assertEquals(titleInvalid, nurse.getTitle());

	}

	/**
	 * test set get valid first name
	 */
	@Test
	public void testSetGetFirstNameValid() {
		Nurse nurse = new Nurse();
		nurse.setFirstName(firstnameValid);
		assertEquals(firstnameValid, nurse.getFirstName());
	}

	/**
	 * test set get invalid first name
	 */
	@Test
	public void testSetGetFirstNameInvalid() {
		Nurse nurse = new Nurse();
		nurse.setFirstName(firstnameInvalid);
		assertEquals(firstnameInvalid, nurse.getFirstName());
	}

	/**
	 * test set get valid last name
	 */
	@Test
	public void testSetGetLastNameValid() {
		Nurse nurse = new Nurse();
		nurse.setLastName(lastnameValid);
		assertEquals(lastnameValid, nurse.getLastName());

	}

	/**
	 * test set get invalid last name
	 */
	@Test
	public void testSetGetLastNameInvalid() {
		Nurse nurse = new Nurse();
		nurse.setLastName(lastnameInvalid);
		assertEquals(lastnameInvalid, nurse.getLastName());

	}

	/**
	 * test set get valid nhs number
	 */
	@Test
	public void testSetGetNhsNumberValid() {
		Nurse nurse = new Nurse();
		nurse.setNhsNumber(nhsNumberValid);
		assertEquals(nhsNumberValid, nurse.getNhsNumber());

	}

	/**
	 * test set get invalid nhs number
	 */
	@Test
	public void testSetGetNhsNumberInvalid() {
		Nurse nurse = new Nurse();
		nurse.setNhsNumber(nhsNumberInvalid);
		assertEquals(nhsNumberInvalid, nurse.getNhsNumber());

	}

	/**
	 * test set get valid street number
	 */
	@Test
	public void testSetGetStreetNumberValid() {
		Nurse nurse = new Nurse();
		nurse.setStreetNumber(streetNumberValid);
		assertEquals(streetNumberValid, nurse.getStreetNumber());

	}

	/**
	 * test set get invalid street number
	 */
	@Test
	public void testSetGetStreetNumberInvalid() {
		Nurse nurse = new Nurse();
		nurse.setStreetNumber(streetNumberInvalid);
		assertEquals(streetNumberInvalid, nurse.getStreetNumber());

	}

	/**
	 * test set get valid street name
	 */
	@Test
	public void testSetGetStreetNameValid() {
		Nurse nurse = new Nurse();
		nurse.setStreetName(streetNameValid);
		assertEquals(streetNameValid, nurse.getStreetName());

	}

	/**
	 * test set get invalid street name
	 */
	@Test
	public void testSetGetStreetNameInvalid() {
		Nurse nurse = new Nurse();
		nurse.setStreetName(streetNameInvalid);
		assertEquals(streetNameInvalid, nurse.getStreetName());

	}

	/**
	 * test set get valid city
	 */
	@Test
	public void testSetGetCityValid() {
		Nurse nurse = new Nurse();
		nurse.setId(idValid);
		assertEquals(idValid, nurse.getId());

	}

	/**
	 * test set get invalid city
	 */
	@Test
	public void testSetGetCityInvalid() {
		Nurse nurse = new Nurse();
		nurse.setId(idInvalid);
		assertEquals(idInvalid, nurse.getId());

	}

	/**
	 * test set get valid postcode
	 */
	@Test
	public void testSetGetPostCodeValid() {
		Nurse nurse = new Nurse();
		nurse.setPostCode(postCodeValid);
		assertEquals(postCodeValid, nurse.getPostCode());

	}

	/**
	 * test set get invalid postcode
	 */
	@Test
	public void testSetGetPostCodeInvalid() {
		Nurse nurse = new Nurse();
		nurse.setPostCode(postCodeInvalid);
		assertEquals(postCodeInvalid, nurse.getPostCode());

	}
}

