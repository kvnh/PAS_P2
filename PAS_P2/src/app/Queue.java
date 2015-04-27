package app;
import java.util.Collections;
import java.util.LinkedList;
import objects.Patient;
import sortQueue.PatientComparator;
import sortQueue.PatientInQueueComparator;
import sortQueue.PatientTriageComparator;
import sortQueue.PatientWaitTimeComparator;

/**
 * Class to hold queue methods
 * 
 * @author FTaylor, CGollogly, LConnolly
 *
 */
public class Queue {

	/**
	 * linked list of patient objects to represent queue
	 */
	public static LinkedList<Patient> queue = new LinkedList<Patient>();

	/**
	 * linked list to represent treatment rooms
	 */
	public static LinkedList<Patient> inTreatment = new LinkedList<Patient>();

	/**
	 * linkedList to represent holding area
	 */
	public static LinkedList<Patient> holdingArea = new LinkedList<Patient>();

	/**
	 * int constant to represent maximum size of queue
	 */
	private static final int QUEUE_MAX = 10;

	/**
	 * int constant to represent max size of treatment room (as its an array, it
	 * begins at 0 therefore 4 = 5 rooms)
	 */
	private static final int TREATMENT_MAX = 4;
	

	/**
	 * method to add a patient to the queue
	 * 
	 * @param patient
	 */

	/**
	 * array to represent 5 treatment rooms
	 */
	private static final TreatmentRoom[] treat = new TreatmentRoom[TREATMENT_MAX];

	/**
	 * method to add patient object to queue
	 * @param patient
	 */
	public static void addToQueue(Patient patient) {

		// check to see if queue already contains this patient to prevent
		// duplicate addition
		if (queue.contains(patient)) {

			System.out.println("Patient is already in the Queue");

		}

		// check to see if queue is full
		else if (queue.size() < QUEUE_MAX) {
			// add patient if there is room in queue
			queue.add(patient);
			
		} else {
			// queue may be full
			System.out.println("Queue is full");
			// alert on call team and hospital manager
			MailClient.contactOnCall();
			MailClient.contactHospitalManager();
		}

	}

	/**
	 * method to remove a patient from the queue
	 * 
	 * @param p
	 */
	public static void removefromQueue(Patient p) {

		// remove patient from queue
		queue.remove(p);

	}

	/**
	 * method to display the queue
	 * 
	 * @param queue
	 */
	public static void viewQueue(LinkedList<Patient> queue) {

		// sort queue by requirement criteria
		sortQueue();
	

	}

	/**
	 * method to sort queue by: 1-have they been in queue before 2-have they
	 * waited for more than 25 mins 3-by triage status
	 */
	public static void sortQueue() {

		Collections.sort(queue, new PatientComparator(new PatientInQueueComparator(), new PatientWaitTimeComparator(),
				new PatientTriageComparator()));

	}

	/**
	 * method to check if treatment is free and remove from queue
	 */
	public static void addToTreatmentRoon() {

		// find if a treatment room is free
		for (int i = 0; i < treat.length; i++) {
			treat[i] = new TreatmentRoom();
			if (treat[i].isAvailable()) {

				// if free, add patient to treatment room
				treat[i].setPatient(queue.getFirst());
				// add patient to inTreatment list for future sorting...
				inTreatment.add(queue.getFirst());
				// remove patient from front of queue
				queue.removeFirst();

				// set treatment room to unavailable
				treat[i].setAvailable(false);

			} else {
				System.out.println("Treatment room is not available");

			}

		}

		// add patient from holding area to queue
		if (queue.size() != QUEUE_MAX) {

			queue.addLast(holdingArea.getFirst());
			// clear holding area
			holdingArea.removeFirst();
		}
	}

	/**
	 * Doctor checks patient out of treatment room
	 * 
	 * @param p
	 */
	public static void checkoutPatient(Patient p) {

		inTreatment.remove(p);

		// cycle through treatment rooms
		for (int i = 0; i < treat.length; i++) {

			// find treatment room that patient is in...
			if (treat[i].getPatient() == p) {

				treat[i].setPatient(null);
				treat[i].setAvailable(true);

			}

		}

	}

	/**
	 * method to add emergency patient to treatment room and remove patient from
	 * treatment room and then add to queue. Remove last patient in queue to
	 * holding area.
	 */
	public static void addEmergencyPatient() {

		// sort patients in treatment room by triage status
		Collections.sort(inTreatment, new PatientComparator(new PatientWaitTimeComparator(),
				new PatientTriageComparator()));

		// remove patient of lowest priority
		inTreatment.remove(inTreatment.getLast());

		// add patient back into queue
		queue.addFirst(inTreatment.getLast());

		// if queue is at limit, remove last patient in queue to holding area
		if (queue.size() == QUEUE_MAX) {

			holdingArea.add(queue.getLast());
			queue.remove(queue.getLast());

		}

	}

}