package objects;

import static org.junit.Assert.*;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import app.Status;

public class TestPatient {

	String bloodTypeValid, bloodTypeInvalid, allergiesValid, allergiesInvalid,
			firstnameValid, firstnameInvalid, lastnameValid, lastnameInvalid,
			postCodeValid, postCodeInvalid, titleValid, titleInvalid,
			streetNameValid, streetNameInvalid, cityValid, cityInvalid,
			nhsNumberValid, nhsNumberInvalid, streetNumberValid,
			streetNumberInvalid, timeEnteredValid, timeEnteredInvalid;
	boolean waitingTime, previouslyInQueue;
	Status triage;
	DateTime dateTime;
	Date date;

	@Before
	public void setUp() throws Exception {

		bloodTypeValid = "validBloodType";
		bloodTypeInvalid = "InvalidBloodType";
		allergiesValid = "validAllergies";
		allergiesInvalid = "invalidAllergies";
		firstnameValid = "ValidfirstName";
		firstnameInvalid = "invalidFirstname";
		lastnameValid = "validLastname";
		lastnameInvalid = "InvalidLastname";
		postCodeValid = "validPostcode";
		postCodeInvalid = "invalidPostcode";
		titleValid = "validTitle";
		titleInvalid = "invalidTitle";
		streetNameValid = "validStreetname";
		streetNameInvalid = "invalidStreetname";
		cityValid = "validCity";
		cityInvalid = "invalidCity";
		nhsNumberValid = "validNhsNum";
		nhsNumberInvalid = "invalidNhsNum";
		streetNumberValid = "validStreetNumber";
		streetNumberInvalid = "invalidStreetnumber";
		timeEnteredValid = "validTimeEntered";
		timeEnteredInvalid = "nvalidTimeEntered";

		triage = null;
		waitingTime = true;
		previouslyInQueue = true;

	}

	/**
	 * default constructor
	 */

	@Test
	public void testPatientConstructorDefault() {
		Patient patient = new Patient();
		assertNotNull(patient);
	}

	/**
	 * non default constructor
	 */
	@Test
	public void testPatientConstructorNonDefault() {
		Patient patient = new Patient(bloodTypeValid, allergiesValid,
				firstnameValid, lastnameValid, postCodeValid, titleValid,
				streetNameValid, cityValid, true, true, nhsNumberValid,
				streetNumberValid, null);
		assertNotNull(patient);

	}

	/**
	 * set get triage
	 */
	@Test
	public void testSetGetTriage() {
		Patient patient = new Patient();
		patient.setTriage(null);
		assertEquals(null, patient.getTriage());
	}

	/**
	 * set patient previously in queue
	 */
	@Test
	public void testSetGetPreviouslyInQueue() {
		Patient patient = new Patient();
		patient.setPreviouslyInQueue(true);
		assertEquals(true, patient.isPreviouslyInQueue());

	}

	/**
	 * set get valid blood type
	 */

	@Test
	public void testSetGetBloodTypeValid() {
		Patient patient = new Patient();
		patient.setBloodType(bloodTypeValid);
		assertEquals(bloodTypeValid, patient.getBloodType());
	}

	/**
	 * set get invalid blood type
	 */

	@Test
	public void testSetGetBloodTypeInvalid() {
		Patient patient = new Patient();
		patient.setBloodType(bloodTypeInvalid);
		assertEquals(bloodTypeInvalid, patient.getBloodType());
	}

	/**
	 * set valid allergies
	 */
	@Test
	public void testSetAllergiesValid() {
		Patient patient = new Patient();
		patient.setAllergies(allergiesValid);
		assertEquals(allergiesValid, patient.getAllergies());
	}

	/**
	 * set invalid allergies
	 */
	@Test
	public void testSetAllergiesInvalid() {
		Patient patient = new Patient();
		patient.setAllergies(allergiesInvalid);
		assertEquals(allergiesInvalid, patient.getAllergies());
	}

	/**
	 * set time entered valid
	 */
	@Test
	public void testSetTimeEntered() {
		Patient patient = new Patient();
		patient.setTimeEntered(dateTime);
		assertEquals(dateTime, patient.getTimeEntered());
	}

	/**
	 * set get valid title
	 */
	@Test
	public void testSetGetTitleValid() {
		Patient patient = new Patient();
		patient.setTitle(titleValid);
		assertEquals(titleValid, patient.getTitle());

	}

	/**
	 * set get invalid title
	 */
	@Test
	public void testSetGetTitleInvalid() {
		Patient patient = new Patient();
		patient.setTitle(titleInvalid);
		assertEquals(titleInvalid, patient.getTitle());

	}

	/**
	 * set get valid first name
	 */
	@Test
	public void testSetGetFirstName() {
		Patient patient = new Patient();
		patient.setFirstName(firstnameValid);
		assertEquals(firstnameValid, patient.getFirstName());
	}

	/**
	 * set get invalid first name
	 */
	@Test
	public void testSetGetFirstNameInvalid() {
		Patient patient = new Patient();
		patient.setFirstName(firstnameInvalid);
		assertEquals(firstnameInvalid, patient.getFirstName());
	}

	/**
	 * set get valid last name
	 */
	@Test
	public void testSetGetLastNameValid() {
		Patient patient = new Patient();
		patient.setLastName(lastnameValid);
		assertEquals(lastnameValid, patient.getLastName());
	}

	/**
	 * set get invalid last name
	 */
	@Test
	public void testSetGetLastNameInvalid() {
		Patient patient = new Patient();
		patient.setLastName(lastnameInvalid);
		assertEquals(lastnameInvalid, patient.getLastName());
	}

	/**
	 * set get valid nhs
	 */
	@Test
	public void testSetGetNhsNumberValid() {
		Patient patient = new Patient();
		patient.setNhsNumber(nhsNumberValid);
		assertEquals(nhsNumberValid, patient.getNhsNumber());

	}

	/**
	 * set get invalid nhs
	 */
	@Test
	public void testSetGetNhsNumberInvalid() {
		Patient patient = new Patient();
		patient.setNhsNumber(nhsNumberInvalid);
		assertEquals(nhsNumberInvalid, patient.getNhsNumber());

	}

	/**
	 * set get valid street name
	 */
	@Test
	public void testSetGetStreetNameValid() {
		Patient patient = new Patient();
		patient.setStreetName(streetNameValid);
		assertEquals(streetNameValid, patient.getStreetName());
	}

	/**
	 * set get invalid street name
	 */
	@Test
	public void testSetGetStreetNameInvalid() {
		Patient patient = new Patient();
		patient.setStreetName(streetNameInvalid);
		assertEquals(streetNameInvalid, patient.getStreetName());
	}

	/**
	 * test set get valid city
	 */
	@Test
	public void testSetGetCityValid() {
		Patient patient = new Patient();
		patient.setCity(cityValid);
		assertEquals(cityValid, patient.getCity());
	}

	/**
	 * test set get invalid city
	 */
	@Test
	public void testSetGetCityInvalid() {
		Patient patient = new Patient();
		patient.setCity(cityInvalid);
		assertEquals(cityInvalid, patient.getCity());
	}

	/**
	 * test set get valid postcode
	 */
	@Test
	public void testSetGetPostCodeValid() {
		Patient patient = new Patient();
		patient.setPostCode(postCodeValid);
		assertEquals(postCodeValid, patient.getPostCode());
	}

	/**
	 * test set get invalid postcode
	 */
	@Test
	public void testSetGetPostCodeInvalid() {
		Patient patient = new Patient();
		patient.setPostCode(postCodeValid);
		assertEquals(postCodeValid, patient.getPostCode());
	}

	/**
	 * test set get time received
	 */
	@Test
	public void testSetTimeRecieved() {
		Patient patient = new Patient();
		patient.setTimeRecieved(date);
		assertEquals(date, patient.getTimeRecieved());

	}

	/**
	 * set get new time received
	 */
	@Test
	public void testSetNewTimeRecieved() {
		Patient patient = new Patient();
		patient.setTimeRecieved(date);
		assertEquals(date, patient.getTimeRecieved());

	}

	/**
	 * test set get time entered
	 */
	@Test
	public void testSetTimeEnteredStringValid() {
		Patient patient = new Patient();
		patient.setTimeEnteredString(timeEnteredValid);
		assertEquals(timeEnteredValid, patient.getTimeEnteredString());

	}

	/**
	 * test set get time entered
	 */
	@Test
	public void testSetTimeEnteredStringInvalid() {
		Patient patient = new Patient();
		patient.setTimeEnteredString(timeEnteredInvalid);
		assertEquals(timeEnteredInvalid, patient.getTimeEnteredString());

	}

}
