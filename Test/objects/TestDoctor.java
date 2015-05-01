package objects;

import static org.junit.Assert.*;

import java.util.Date;

import objects.Doctor;

import org.junit.Before;
import org.junit.Test;

public class TestDoctor {

	String firstnameValid, firstnameInvalid, lastnameValid, lastnameInvalid,
			postCodeValid, postCodeInvalid, streetNumberValid,
			streetNumberInvalid, streetNameValid, streetNameInvalid, cityValid,
			cityInvalid, titleValid, titleInvalid, nhsNumberValid,
			nhsNumberInvalid, specialityValid, specialityInvalid;

	int idValid, idInvalid, phoneValid, phoneInvalid;

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
		specialityValid = "validSpeciality";
		specialityInvalid = "invalidSpeciality";

		idValid = 1;
		idInvalid = 0;
		phoneValid = 2;
		phoneInvalid = 3;

	}

	/**
	 * default constructor
	 */
	@Test
	public void testDoctorConstuctorDefault() {
		Doctor doctor = new Doctor();
		assertNotNull(doctor);

	}

	/**
	 * non default constructor with args
	 */
	@Test
	public void testDoctorNonDefaultConstructor() {
		Doctor doctor = new Doctor(titleValid, firstnameValid, lastnameValid,
				postCodeValid, null, streetNameValid, streetNumberValid,
				cityValid, nhsNumberValid, idValid, phoneValid, postCodeValid);

		assertNotNull(doctor);
		

	}

	/**
	 * test set get valid id
	 */
	@Test
	public void testSetGetIdValid() {
		Doctor doctor = new Doctor();
		doctor.setId(idValid);
		assertEquals(idValid, doctor.getId());
	}

	/**
	 * test set get for invalid id
	 */
	@Test
	public void testSetGetIdInvalid() {
		Doctor doctor = new Doctor();
		doctor.setId(idInvalid);
		assertEquals(idInvalid, doctor.getId());

	}

	/**
	 * test set get valid phone number
	 */
	@Test
	public void testSetGetPhoneValid() {
		Doctor doctor = new Doctor();
		doctor.setPhone(phoneValid);
		assertEquals(phoneValid, doctor.getPhone());
	}

	@Test
	public void testSetGetPhoneInvalid() {
		Doctor doctor = new Doctor();
		doctor.setId(phoneInvalid);
		assertEquals(phoneInvalid, doctor.getId());
	}

	/**
	 * test set get valid title
	 */

	@Test
	public void testSetGetValidTitle() {
		Doctor doctor = new Doctor();
		doctor.setTitle(titleValid);
		assertEquals(titleValid, doctor.getTitle());
	}

	/**
	 * test set get invalid title
	 */

	@Test
	public void testSetGetInvalidTitle() {
		Doctor doctor = new Doctor();
		doctor.setTitle(titleInvalid);
		assertEquals(titleInvalid, doctor.getTitle());

	}

	/**
	 * test set get valid first name
	 */
	@Test
	public void testSetGetFirstNameValid() {
		Doctor doctor = new Doctor();
		doctor.setFirstName(firstnameValid);
		assertEquals(firstnameValid, doctor.getFirstName());
	}

	/**
	 * test set get invalid first name
	 */
	@Test
	public void testSetGetFirstNameInvalid() {
		Doctor doctor = new Doctor();
		doctor.setFirstName(firstnameInvalid);
		assertEquals(firstnameInvalid, doctor.getFirstName());
	}

	/**
	 * test set get valid last name
	 */
	@Test
	public void testSetGetLastNameValid() {
		Doctor doctor = new Doctor();
		doctor.setLastName(lastnameValid);
		assertEquals(lastnameValid, doctor.getLastName());

	}

	/**
	 * test set get invalid last name
	 */
	@Test
	public void testSetGetLastNameInvalid() {
		Doctor doctor = new Doctor();
		doctor.setLastName(lastnameInvalid);
		assertEquals(lastnameInvalid, doctor.getLastName());

	}

	/**
	 * test set get valid nhs number
	 */
	@Test
	public void testSetGetNhsNumberValid() {
		Doctor doctor = new Doctor();
		doctor.setNhsNumber(nhsNumberValid);
		assertEquals(nhsNumberValid, doctor.getNhsNumber());

	}

	/**
	 * test set get invalid nhs number
	 */
	@Test
	public void testSetGetNhsNumberInvalid() {
		Doctor doctor = new Doctor();
		doctor.setNhsNumber(nhsNumberInvalid);
		assertEquals(nhsNumberInvalid, doctor.getNhsNumber());
	}

	/**
	 * test set get valid street name
	 */
	@Test
	public void testSetGetStreetNameValid() {
		Doctor doctor = new Doctor();
		doctor.setStreetName(streetNameValid);
		assertEquals(streetNameValid, doctor.getStreetName());

	}

	/**
	 * test set get invalid street name
	 */
	@Test
	public void testSetGetStreetNameInvalid() {
		Doctor doctor = new Doctor();
		doctor.setStreetName(streetNameInvalid);
		assertEquals(streetNameInvalid, doctor.getStreetName());

	}

	/**
	 * test set get valid city
	 */
	@Test
	public void testSetGetCityValid() {
		Doctor doctor = new Doctor();
		doctor.setCity(cityValid);
		assertEquals(cityValid, doctor.getCity());
	}

	/**
	 * test set get invalid city
	 */
	@Test
	public void testSetGetCityInvalid() {
		Doctor doctor = new Doctor();
		doctor.setCity(cityInvalid);
		assertEquals(cityInvalid, doctor.getCity());
	}

	/**
	 * test set get valid post code
	 */
	@Test
	public void testSetGetPostCodeValid() {
		Doctor doctor = new Doctor();
		doctor.setPostCode(postCodeValid);
		assertEquals(postCodeValid, doctor.getPostCode());
	}

	/**
	 * test set get invalid post code
	 */
	@Test
	public void testSetGetPostCodeInvalid() {
		Doctor doctor = new Doctor();
		doctor.setPostCode(postCodeInvalid);
		assertEquals(postCodeInvalid, doctor.getPostCode());
	}

	/**
	 * test set get valid speciality
	 */
	public void testSetGetSpecialityValid() {
		Doctor doctor = new Doctor();
		doctor.setSpeciality(specialityValid);
		assertEquals(specialityValid, doctor.getSpeciality());
	}

	/**
	 * test set get invalid speciality
	 */
	public void testSetGetSpecialityInvalid() {
		Doctor doctor = new Doctor();
		doctor.setSpeciality(specialityInvalid);
		assertEquals(specialityInvalid, doctor.getSpeciality());
	}

}
