package app;

import java.util.Iterator;
import objects.Patient;

/**
 * class to kick off the thread
 * @author KHackett
 *
 */
public class ControlQueue implements Runnable {

	@Override
	public void run() {
		Iterator<Patient> it = Queue.queue.iterator();
		// While there is a patient in the queue, enter the while loop
		while ((it.hasNext()) || (Queue.queue.size() == 0)) {
			// run method to sort queue
			Queue.sortQueue();
			if (Queue.queue.isEmpty() && TreatmentRoom.treat.length == 0) {
				System.out.println("Queue empty and treatmentRoom empty");
			} else // otherwise if there are patients in the queue + treatment area 
			{
				// Add an emergency patient to on call area if treatment rooms have 5 emergency patients
				Queue.onCallArea();
				// Add a patient to the treatment room
				Queue.addToTreatmentRoom();
				// Add an emergency patient to the the treatment room
				Queue.addEmergencyPatient();
				// Check how long patient has been in the treatment room
				TreatmentTimer.treatmentRoomTimer();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} // end of run method

}
