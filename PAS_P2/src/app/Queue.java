package app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import dataAccessLayer.QueueDA;
import objects.Patient;
import sortQueue.PatientComparator;
import sortQueue.PatientInQueueComparator;
import sortQueue.PatientTriageComparator;
import sortQueue.PatientWaitTimeComparator;

public class Queue  {

	/**
	 * linked list of patient objects to represent queue
	 */
	public static LinkedList<Patient> queue = new LinkedList<Patient>();

	/**
	 * method to add a patient to the queue
	 * 
	 * @param patient
	 */
	public static void addToQueue(Patient patient) {

		// check to see if queue already contains this patient to prevent
		// duplicate addition
		if (queue.contains(patient)) {

			System.out.println("Patient is already in the Queue");

		}

		// check to see if queue is full
		else if (queue.size() < 10) {
			// add patient if there is room in queue
			queue.add(patient);

			// add patient details to database
			QueueDA.addToQueueTable(patient);

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

		// remove details from database
		QueueDA.removeFromQueueTable(p);
	}

	/**
	 * method to display the queue
	 * 
	 * @param queue
	 */
	public static void viewQueue(LinkedList<Patient> queue) {

		// sort queue by requirement criteria
		sortQueue();
		// create iterator for the queue
		ListIterator<Patient> listIterator = queue.listIterator();
		while (listIterator.hasNext()) {

			// count to progress through queue linked list
			int count = 0;

			// call method to display patient information in database
			QueueDA.displayQueueData(queue.get(count));

			count++;

		}

	}
	
	/**
	 * method to sort queue by:
	 * 1-have they been in queue before
	 * 2-have they waited for more than 25 mins
	 * 3-by triage status
	 */
	public static void sortQueue(){
		
	    Collections.sort(queue, new PatientComparator(
	            new PatientInQueueComparator(),
	            new PatientWaitTimeComparator(),
	            new PatientTriageComparator())
	     );
	
	}


}