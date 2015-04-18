package app;

import java.util.LinkedList;

import objects.Patient;

public class Queue implements Comparable<Patient> {

	/**
	 * linked list of patient objects to represent queue
	 */
	public static LinkedList<Patient> queue = new LinkedList<Patient>();

	/**
	 * method to add a patient to the queue
	 * 
	 * @param p
	 */
	public static LinkedList<Patient> addToQueue(Patient p) {

		// check to see if queue already contains this patient
		if (queue.contains(p)) {
			// prevent patient from being added to queue
			//queue.
		}
		// check to see if queue is full
		if (queue.size() < 10) {
			// add patient if there is room in queue
			queue.add(p);
		} else {
			// queue may be full
			System.out.println("Queue is full");
			// alert on call team and hospital manager
		}

		return queue;
		//test.displayQueue(queue);
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
	 * overriden method to allow comparison by triage status
	 */
	@Override
	public int compareTo(Patient o) {
		return 0;
	}

}