package app;

import objects.Patient;

/**
 * class to represent a treatment room in the PAS
 * @author KHackett
 *
 */
public class TreatmentRoom {

	/**
	 * boolean to state if the room is available or not
	 */
	private boolean isAvailable;

	/**
	 * patient that will occupy the treatment room
	 */
	private Patient patient;

	/**
	 * default constructor
	 */
	public TreatmentRoom() {

	}

	/**
	 * constructor with arguments
	 * @param roomNum
	 * @param isAvailable
	 * @param patient
	 */
	public TreatmentRoom(boolean isAvailable, Patient patient) {
		super();
		this.setAvailable(isAvailable);
		this.patient = patient;
	}

	/**
	 * check if the room is available or not
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = true;
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

}
