package objects;

import app.Status;

/**
 * class to represent a patient in the PAS
 * 
 * @author KHackett
 *
 */
public class Patient extends Person {

	/**
	 * Boolean to represent Patient has been in the queue previously
	 */
	private boolean previouslyInQueue;

	/**
	 * Boolean to represent Patient waiting time
	 */
	private boolean waitingTime;

	/**
	 * String to represent Patient blood type
	 */
	private String bloodType;

	/**
	 * String to represent Patient allergies
	 */
	private String allergies;

	/**
	 * Enum to represent triage status
	 */
	private Status triage;

	/**
	 * default constructor
	 */
	public Patient() {
	}

	/**
	 * constructor with args
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Patient(String nhsNumber, String title, String firstName, String lastName, String streetNumber,
			String streetName, String city, String postCode, boolean previouslyInQueue, boolean waitingTime,
			String bloodType, String allergies, Status triage) {
		super(nhsNumber, title, firstName, lastName, streetNumber, streetName, city, postCode);
		this.previouslyInQueue = previouslyInQueue;
		this.waitingTime = waitingTime;
		this.bloodType = bloodType;
		this.allergies = allergies;
		this.triage = triage;
	}

	/**
	 * 
	 * @return the triage
	 */
	public Status getTriage() {
		return triage;
	}

	/**
	 * 
	 * @param triage
	 *            the triage to set
	 */
	public void setTriage(Status triage) {
		this.triage = triage;
	}

	/**
	 * method to allow comparison of patients by triage status
	 * 
	 * @param p
	 * @return
	 */
	public int compareTriage(Patient p) {

		Status compare = p.triage;

		if (this.triage.equals(compare)) {
			// if triage status is same, add to next slot in queue
			return 0;
		} else if (this.triage.compareTo(compare) > 0) {
			// if triage status is greater add above
			return 1;

		} else {
			// if triage status is less, add below.
			return -1;
		}
	}

	/**
	 * @return the beenInQueue
	 */
	public boolean isPreviouslyInQueue() {
		return previouslyInQueue;
	}

	/**
	 * @param beenInQueue
	 *            the beenInQueue to set
	 */
	public void setPreviouslyInQueue(boolean previouslyInQueue) {
		this.previouslyInQueue = previouslyInQueue;
	}

	/**
	 * @return the waitingTime
	 */
	public boolean isWaitingTime() {
		return waitingTime;
	}

	/**
	 * @param waitingTime
	 *            the waitingTime to set
	 */
	public void setWaitingTime(boolean waitingTime) {
		this.waitingTime = waitingTime;
	}

	/**
	 * @return the bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType
	 *            the bloodType to set
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @return the allergies
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies
	 *            the allergies to set
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	/**
	 * toString method to output patient information to screen
	 */
	public String toString() {
		return "Patient Name: " + this.getFirstName() + " " + this.getLastName() + "\nTriage status: " + this.triage;
	}

}
