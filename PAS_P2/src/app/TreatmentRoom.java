package app;

import org.joda.time.DateTime;
import objects.Patient;

/**
 * class to represent a treatment room in the A&E
 * each treatment room can contain a reference to a patient
 * 
 * @author KHackett
 *
 */
public class TreatmentRoom {

	/**
	 * the maximum amount of treatment rooms allowed
	 */
	private static final int TREATMENT_MAX = 5;
	
	/**
	 * constant to initialize the treatment room timer in days
	 */
	public static final int TREATMENT_ROOM_TIMER = 30;

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
	 * Date time to represent time patient enters treatment room
	 */
	private DateTime timeEntered;

	/**
	 * default constructor
	 */
	public TreatmentRoom() {
	}

	/**
	 * constructor with arguments
	 * 
	 * @param isAvailable
	 * @param patient
	 * @param roomNum
	 * @param timeEntered
	 */
	public TreatmentRoom(boolean isAvailable, Patient patient, int roomNum, DateTime timeEntered) {
		super();
		this.isAvailable = isAvailable;
		this.patient = patient;
		this.roomNum = roomNum;
		this.timeEntered = timeEntered;
	}

	/**
	 * method to create treatment rooms and initialize with time values
	 */
	public static void createTreatmentRooms() {
		// iterate through each treatment room
		for (int i = 0; i < treat.length; i++) {
			treat[i] = new TreatmentRoom();
			// set each one to available
			treat[i].setAvailable(true);
			// initialize a time value for each
			treat[i].setTimeEntered(DateTime.now().plusDays(TREATMENT_ROOM_TIMER));
		}
	} // end of createTreatmentRooms method

	/**
	 * check if the room is available or not
	 * 
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
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
	 * @param patient the patient to set
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

	/**
	 * @return the timeEntered
	 */
	public DateTime getTimeEntered() {
		return this.timeEntered;
	}

	/**
	 * @param timeEntered the timeEntered to set
	 */
	public void setTimeEntered(DateTime timeEntered) {
		this.timeEntered = timeEntered;
	}

}