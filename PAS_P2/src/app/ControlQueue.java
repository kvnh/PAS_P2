package app;

import java.util.Iterator;
import objects.Patient;

public class ControlQueue implements Runnable {

	@Override
	public void run() {
		Iterator<Patient> it = Queue.queue.iterator();
		System.out.println("thread running");
		while ((it.hasNext()) || (Queue.queue.size() == 0)) {
			System.out.println("in while");
			// sort queue
			Queue.sortQueue();

			// about to take off element
			if (Queue.queue.isEmpty() && TreatmentRoom.treat.length == 0) {
				System.out.println("Queue empty and treatmentRoom empty");
			} else {
				System.out.println("Add to treatment room");
				Queue.addToTreatmentRoom();
				System.out.println("Add emergency patient");
				Queue.addEmergencyPatient();
				TreatmentTimer.treatmentRoomTimer();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Problems");
			}
		}
		System.out.println("exiting while loop");
	}

}
