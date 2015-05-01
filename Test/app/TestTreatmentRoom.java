package app;

import static org.junit.Assert.*;

//import java.util.LinkedList;

import objects.Patient;

import org.junit.Before;
import org.junit.Test;

public class TestTreatmentRoom {

	int invalidRoomNumUpper, invalidRoomNumLower, validRoomNum1, validRoomNum2,
			validRoomNum3, validRoomNum4, validRoomNum5;
	boolean isAvailable, isNotAvailable;

	Patient patient;

	/*
	 * Patient p1 = new Patient(); Patient p2 = new Patient(); Patient p3 = new
	 * Patient(); Patient p4 = new Patient(); Patient p5 = new Patient();
	 * Patient p6 = new Patient(); Patient p7 = new Patient(); Patient p8 = new
	 * Patient(); Patient p9 = new Patient(); Patient p10 = new Patient();
	 * Patient p11 = new Patient();
	 */

	Queue queue;

	@Before
	public void setUp() throws Exception {

		invalidRoomNumLower = 0;
		invalidRoomNumUpper = 6;
		validRoomNum1 = 1;
		validRoomNum2 = 2;
		validRoomNum3 = 3;
		validRoomNum4 = 4;
		validRoomNum5 = 5;
		isAvailable = true;
		isNotAvailable = false;

	}

	/**
	 * default constructor
	 */
	@Test
	public void testTreatmentRoomDefaultConstuctor() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		assertNotNull(treatmentRoom);
	}

	/**
	 * non default constructor with args
	 */
	@Test
	public void testTreatmentRoomNonDefaultConstructor() {
		TreatmentRoom treatmentRoom = new TreatmentRoom(isAvailable, patient, validRoomNum1, null);
		assertNotNull(treatmentRoom);

		assertEquals(patient, treatmentRoom.getPatient());
		assertEquals(isAvailable, treatmentRoom.isAvailable());
	}

	/**
	 * set get valid room number
	 */
	@Test
	public void testSetGetRoomNumValid1() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(validRoomNum1);
		assertEquals(validRoomNum1, treatmentRoom.getRoomNum());

	}

	/**
	 * set get valid room number
	 */
	@Test
	public void testSetGetRoomNumValid2() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(validRoomNum2);
		assertEquals(validRoomNum2, treatmentRoom.getRoomNum());
	}

	/**
	 * set get valid room number
	 */
	@Test
	public void testSetGetRoomNumValid3() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(validRoomNum3);
		assertEquals(validRoomNum3, treatmentRoom.getRoomNum());

	}

	/**
	 * set get valid room number
	 */
	@Test
	public void testSetGetRoomNumValid4() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(validRoomNum4);
		assertEquals(validRoomNum4, treatmentRoom.getRoomNum());

	}

	/**
	 * set get valid room number
	 */
	@Test
	public void testSetGetRoomNumValid5() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(validRoomNum5);
		assertEquals(validRoomNum5, treatmentRoom.getRoomNum());

	}

	/**
	 * set get room number invalid lower
	 */
	@Test
	public void testSetGetRoomNumInvalidLower() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(invalidRoomNumLower);
		assertEquals(invalidRoomNumLower, treatmentRoom.getRoomNum());
		System.out.println("Invalid Room");
	}

	/**
	 * test set get room number invalid upper
	 */
	@Test
	public void testSetGetRoomNumInvalidUpper() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setRoomNum(invalidRoomNumUpper);
		assertEquals(invalidRoomNumUpper, treatmentRoom.getRoomNum());
		System.out.println("Invalid Room");

	}

	/**
	 * test set get is available
	 */
	@Test
	public void testSetGetIsAvailable() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setAvailable(true);
		assertEquals(true, treatmentRoom.isAvailable());

	}

	/**
	 * test set get is not available
	 */
	@Test
	public void testSetGetIsNotAvailable() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setAvailable(false);

	}

	/**
	 * test set get patient
	 */
	@Test
	public void TestSetGetPatient() {
		TreatmentRoom treatmentRoom = new TreatmentRoom();
		treatmentRoom.setPatient(patient);
		assertEquals(patient, treatmentRoom.getPatient());

	}
}

// //another way to testValidTreatmentRooms possibly
// @Test
// public void testsetRoomValid() {
//
// LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();
//
// TreatmentRoom room1 = new TreatmentRoom();
// TreatmentRoom room2 = new TreatmentRoom();
// TreatmentRoom room3 = new TreatmentRoom();
// TreatmentRoom room4 = new TreatmentRoom();
// TreatmentRoom room5 = new TreatmentRoom();
//
// treat.add(room1);
// treat.add(room2);
// treat.add(room3);
// treat.add(room4);
// treat.add(room5);
//
// room1.setPatient(p1);
// room2.setPatient(p2);
// room3.setPatient(p3);
// room4.setPatient(p4);
// room5.setPatient(p5);
//
// assertEquals(p1, room1.getPatient());
// assertEquals(p2, room2.getPatient());
// assertEquals(p3, room3.getPatient());
// assertEquals(p4, room4.getPatient());
// assertEquals(p5, room5.getPatient());
//
// }
// //invalid treatment rooms
// @Test
// public void testsetRoomInvalid() {
//
// LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();
//
// TreatmentRoom room1 = new TreatmentRoom();
// TreatmentRoom room2 = new TreatmentRoom();
// TreatmentRoom room3 = new TreatmentRoom();
// TreatmentRoom room4 = new TreatmentRoom();
// TreatmentRoom room5 = new TreatmentRoom();
//
// treat.add(room1);
// treat.add(room2);
// treat.add(room3);
// treat.add(room4);
// treat.add(room5);
//
// room1.setPatient(p1);
// room2.setPatient(p2);
//
// assertNotEquals(p1, room2);
// assertNotEquals(p2, room1);
// }
//

