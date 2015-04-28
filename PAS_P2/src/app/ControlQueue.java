package app;

import java.util.Iterator;

import controllers.QueueTabPageController;
import objects.Patient;

public class ControlQueue implements Runnable {

	@Override
	public void run() {
		Iterator<Patient> it = Queue.queue.iterator();
		System.out.println("thread running");
		while (it.hasNext()) {
			System.out.println("in while");
			// sort queue
			Queue.sortQueue();
			
			// refresh button method should be added here
			//QueueTabPageController qt = new QueueTabPageController();
			//qt.displayQueue(Queue.queue);

			// about to take off element
			if (Queue.queue.isEmpty()) {
				System.out.println("List Empty");
			} else {
				System.out.println("Add to treatment room");
				Queue.addToTreatmentRoon();
				System.out.println("tracer");

			}
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				System.out.println("Problems");
			}
		}
	}

}
