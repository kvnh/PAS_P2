package app;

import java.util.Collections;
import java.util.LinkedList;

import org.joda.time.DateTime;

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

	public static LinkedList<Patient> tempQueue = new LinkedList<Patient>();

	public static LinkedList<Patient> checkOutQueue = new LinkedList<Patient>();

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

		// check to see if queue already contains this patient to prevent
		// duplicate addition
		// if (queue.contains(patient)) {

		// System.out.println("Patient is already in the Queue");

		// }

		// check to see if queue is full
		if (queue.size() < QUEUE_MAX) {
			// add patient if there is room in queue
			queue.add(patient);
			System.out.println("Patient added to queue");
		} else {
			// add patient from holding area to queue

			// queue.addLast(holdingArea.getFirst());
			// clear holding area
			// holdingArea.removeFirst();

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
	 * method to sort queue by: 1-have they been in queue before 2-have they
	 * waited for more than 25 mins 3-by triage status
	 */
	public static void sortQueue() {

		Collections
				.sort(queue, new PatientComparator(
						new PatientInQueueComparator(),
						new PatientWaitTimeComparator(),
						new PatientTriageComparator()));

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

				// System.out.println("patient added" +
				// queue.get(i).getFirstName())
				inTreatment.getLast().setTreatRoomNum(i + 1);
				// TreatmentRoom.treat[i].setRoomNum(i);
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

		checkOutQueue = new LinkedList<Patient>(inTreatment);

		System.out.println("before checkout for...");
		for (Patient p : checkOutQueue) {
			System.out.println("entered checkout for...");
			if (tr.getPatient() == p) {
				System.out.println("detected patient to checkout");
				inTreatment.remove(p);
				tr.setAvailable(true);
				tr.setTimeEntered(DateTime.now().plusDays(30));

			}
		}

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
				}  else if (inTreatment.size() == 5) {
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
					p.setTreatRoomNum(inTreatment.getLast().getTreatRoomNum()+1);
					inTreatment.add(p);
					sortTreatment.remove(p);
					queue.remove(p);

				}

			} else {
				System.out.println("no emergency patients");
			}
		}

		// ListIterator<Patient> it = queue.listIterator();
		// if (it.hasNext()) {
		// Patient item = it.next();
		// }
	}
}