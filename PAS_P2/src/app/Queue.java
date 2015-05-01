package app;

import java.util.Collections;
import java.util.LinkedList;

import org.joda.time.DateTime;

import objects.Patient;
import sortQueue.PatientComparator;
import sortQueue.PatientEntryComparator;
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

	public static LinkedList<Patient> tempQueue = new LinkedList<Patient>();

	public static LinkedList<Patient> onCall = new LinkedList<Patient>();

	/**
	 * linked list to represent treatment rooms
	 */
	public static final LinkedList<Patient> inTreatment = new LinkedList<Patient>();

	/**
	 * linked list to represent treatment rooms
	 */
	public static LinkedList<Patient> sortTreatment;

	/**
	 * linkedList to represent holding area
	 */
	public static LinkedList<Patient> holdingArea = new LinkedList<Patient>();

	/**
	 * int constant to represent maximum size of queue
	 */
	private static final int QUEUE_MAX = 10;

	/**
	 * method to add patient object to queue
	 * 
	 * @param patient
	 */
	public static void addToQueue(Patient patient) {

		// check to see if queue is full
		if (queue.size() < QUEUE_MAX) {
			// add patient if there is room in queue
			queue.add(patient);
			Queue.checkStatusCode();
			System.out.println("Patient added to queue");
		} else if ((queue.getFirst().getTriage() != Status.NOT_ASSESSED)
				&& (inTreatment.size() == 5)) {
			// alert on call team and hospital manager
			MailClient.contactOnCall();
			MailClient.contactHospitalManager();

			onCallMax();
		} else {

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
	 * method to sort queue by: 1-have they been in queue before 2-have they
	 * waited for more than 25 mins 3-by triage status
	 */
	public static void sortQueue() {

		Collections.sort(queue, new PatientComparator(
				new PatientInQueueComparator(),
				new PatientWaitTimeComparator(), new PatientTriageComparator(),
				new PatientEntryComparator()));

		// initialise counter
		int count = 0;

		// go through queue
		for (Patient p : queue) {

			// if 2 patients have been waiting more than 30 mins, alert hospital
			// manager
			if (p.getTimeEntered().plusMinutes(30).isBeforeNow()) {

				count++;

				if (count == 2) {

					// alert hospital manager
					MailClient.contactHospitalManager();

				}
			}
		}
	}

	/**
	 * method to check if treatment is free and remove from queue
	 */
	public static void addToTreatmentRoom() {
		// find if a treatment room is free

		for (int i = 0; i < TreatmentRoom.treat.length; i++) {

			if ((TreatmentRoom.treat[i].isAvailable())
					&& (inTreatment.size() <= 4)
					&& (Queue.queue.size() != 0)
					&& (Queue.queue.getFirst().getTriage() != Status.NOT_ASSESSED)) {

				// add patient to inTreatment list for future sorting...
				inTreatment.add(queue.getFirst());
				System.out.println("taken to treatment queue");

				// remove patient from front of queue
				queue.poll();

				System.out.println("removed from queue");

				// if free, add patient to treatment room
				TreatmentRoom.treat[i].setPatient(inTreatment.getFirst());
				System.out.println("sent to treatment room"
						+ TreatmentRoom.treat[i]);

				// set time entered to current time
				TreatmentRoom.treat[i].setTimeEntered(DateTime.now());

				inTreatment.getLast().setTreatRoomNum(i + 1);

				// set treatment room to unavailable
				TreatmentRoom.treat[i].setAvailable(false);
				System.out.println("treatment room busy");

			} else {
				System.out.println("Treatment room is not available");

			}

		}
		System.out.println("end of for");
		for (Patient p1 : inTreatment) {
			System.out.println(p1.getFirstName() + " " + p1.getLastName());
		}
	}

	/**
	 * Doctor checks patient out of treatment room
	 * 
	 * @param p
	 */
	public static void checkoutPatient(TreatmentRoom tr) {

		inTreatment.remove();
		tr.setPatient(null);
		tr.setAvailable(true);
		tr.setTimeEntered(DateTime.now().plusDays(30));

	}

	public static void extend5mins(TreatmentRoom tr) {

		tr.setTimeEntered(tr.getTimeEntered().minusMinutes(5));
	}

	/**
	 * method to add emergency patient to treatment room and remove patient from
	 * treatment room and then add to queue. Remove last patient in queue to
	 * holding area.
	 */
	public static void addEmergencyPatient() {

		sortTreatment = new LinkedList<Patient>(inTreatment);

		tempQueue = new LinkedList<Patient>(queue);

		for (Patient p : tempQueue) {

			// check for emergency patients
			if (p.getTriage().equals(Status.EMERGENCY)) {
				System.out.println("emergency found " + p.getFirstName());
				// sortTreatment = new LinkedList<Patient>(inTreatment);

				// sort patients in treatment room by triage status
				Collections.sort(sortTreatment, new PatientComparator(
						new PatientTriageComparator(),
						new PatientWaitTimeComparator(),
						new PatientInQueueComparator()));

				// if queue is at limit, remove last patient in queue to
				// holding
				// area
				if (queue.size() == QUEUE_MAX) {

					// add patient to treatment room
					// find available treatment room
					for (int i = 0; i < TreatmentRoom.treat.length; i++) {

						if (TreatmentRoom.treat[i].isAvailable()) {

							TreatmentRoom.treat[i].setPatient(p);
							TreatmentRoom.treat[i].setAvailable(false);

						}

						holdingArea.add(queue.getLast());
						queue.remove(queue.getLast());

						// remove patient of lowest priority
						inTreatment.remove(sortTreatment.getLast());
						p.setPreviouslyInQueue(true);

						// add patient back into queue
						queue.add(sortTreatment.getLast());

						// add patient to treatment queue
						inTreatment.add(p);

						sortTreatment.remove(p);
						queue.remove(p);
					}
				} else if (inTreatment.size() == 5) {
					// add patient to treatment room
					// find available treatment room
					for (int i = 0; i < TreatmentRoom.treat.length; i++) {

						if (TreatmentRoom.treat[i].isAvailable()) {
							TreatmentRoom.treat[i].setPatient(p);
							TreatmentRoom.treat[i].setAvailable(false);

						}

					}
					queue.add(sortTreatment.getLast());
					inTreatment.remove(sortTreatment.getLast());
					p.setPreviouslyInQueue(true);
					p.setTreatRoomNum(sortTreatment.getLast().getTreatRoomNum());
					inTreatment.add(p);
					sortTreatment.remove(p);
					queue.remove(p);

				} else {

					// add patient to treatment room
					// find available treatment room
					for (int i = 0; i < TreatmentRoom.treat.length; i++) {

						if (TreatmentRoom.treat[i].isAvailable()) {
							TreatmentRoom.treat[i].setPatient(p);
							TreatmentRoom.treat[i].setAvailable(false);
						}
					}
					p.setTreatRoomNum(inTreatment.getLast().getTreatRoomNum() + 1);
					inTreatment.add(p);
					sortTreatment.remove(p);
					queue.remove(p);

				}

			} else {
				System.out.println("no emergency patients");
			}
		}

	}

	/**
	 * method to move emergency patient from queue to on call area
	 */

	public static void onCallArea() {

		LinkedList<Patient> tempQ = new LinkedList<Patient>(queue);

		int count = 0;

		// search through patients in treatment
		for (Patient p : inTreatment) {

			if (p.getTriage().equals(Status.EMERGENCY)) {

				count++;

				// all treatment rooms have emergency
				if (count == 5) {

					for (Patient p2 : tempQ) {

						if (p2.getTriage().equals(Status.EMERGENCY)
								&& (onCall.isEmpty())) {

							// add patient to on call area
							onCall.add(p2);

							System.out.println("\t\t\tTreated by on call.....");
							// remove patient from queue
							queue.remove(p2);

						} else if ((!onCall.isEmpty())
								&& (p2.getTriage().equals(Status.EMERGENCY))) {

							System.out
									.println("\t\t\tDivert to another hospital...");
							queue.remove(p2);

							// alert hospital manager
							MailClient.contactHospitalManager();
							System.out.println("\t\t\t BOOM!");

						}

						else {
							System.out.println("\t\t\thello....");
						}

					}

				} else {
					System.out.println("\t\t\tstraight through....");
				}

			}
		}
	}

	/**
	 * method to handle on call team when queue is at limit
	 */
	public static void onCallMax() {

		// get first patient in queue and add to holding area
		holdingArea.add(queue.getFirst());

		System.out.println("\t\t\t added to holding....");

		// remove first patient from queue
		queue.poll();

		// create time entered holding area
		DateTime enter = new DateTime();
		enter = DateTime.now();

		if (enter.plusMinutes(1).isBeforeNow()) {

			holdingArea.poll();

			System.out.println("\t\t\t\ton call removed....");

		}

	}

	public static String checkStatusCode() {

		String statusCode = "1";

		if (queue.size() > 0) {

			Collections.sort(queue, new PatientComparator(
					new PatientEntryComparator()));

			DateTime d = queue.getFirst().getTimeEntered();

			if (d.plusMinutes(1).isBeforeNow()) {
				statusCode = "2";

			} else if (d.plusMinutes(2).isBeforeNow()) {
				statusCode = "3";

			} else if (queue.size() == QUEUE_MAX) {
				statusCode = "4";

			}
		}
		return statusCode;

	}

}