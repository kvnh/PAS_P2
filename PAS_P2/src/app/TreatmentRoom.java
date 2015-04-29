package app;

import objects.Patient;

/**
 * class to represent a treatment room in the PAS
 * 
 * @author KHackett
 *
 */
public class TreatmentRoom {

	private static final int TREATMENT_MAX = 5;

	/**
	 * array to represent 5 treatment rooms
	 */
	public static TreatmentRoom[] treat = new TreatmentRoom[TREATMENT_MAX];

	/**
	 * boolean to state if the room is available or not
	 */
	private boolean isAvailable;

	/**
	 * patient that will occupy the treatment room
	 */
	private Patient patient;
	
	/**
	 * Treatment room number
	 */
	private int roomNum;

	/**
	 * default constructor
	 */
	public TreatmentRoom() {

	}

	/**
	 * constructor with arguments
	 * 
	 * @param roomNum
	 * @param isAvailable
	 * @param patient
	 */
	public TreatmentRoom(boolean isAvailable, Patient patient) {
		super();
		this.isAvailable = isAvailable;
		this.patient = patient;
	}

	public static void createTreatmentRooms() {
		for (int i = 0; i < treat.length; i++) {
			treat[i] = new TreatmentRoom();
			treat[i].setAvailable(true);
		}
	}

	/**
	 * check if the room is available or not
	 * 
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable
	 *            the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the roomNum
	 */
	public int getRoomNum() {
		return roomNum;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

}
