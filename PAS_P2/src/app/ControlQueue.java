package app;

import java.util.Iterator;

import controllers.QueueTabPageController;
import objects.Patient;

public class ControlQueue implements Runnable {

	@Override
	public void run() {
		Iterator<Patient> it = Queue.queue.iterator();

		while (it.hasNext()) {
			
			// sort queue
			Queue.sortQueue(Queue.queue);
			
			// refresh button method should be added here
			

			// about to take off element
			if (Queue.queue.isEmpty()) {
				System.out.println("List Empty");
			} else {
				Queue.addToTreatmentRoon();

			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Problems");
			}
		}
	}

}
