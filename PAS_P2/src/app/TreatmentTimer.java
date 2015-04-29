package app;

import objects.Patient;

import org.joda.time.DateTime;

public class TreatmentTimer {

	public static void treatmentRoomTimer() {

		if (Queue.inTreatment.size()!= 0) {

			for (TreatmentRoom tr : TreatmentRoom.treat) {

				System.out.println("in for...");
				
				System.out.println(tr.getTimeEntered());
				
				 DateTime d =  DateTime.now();
				

				if (tr.getTimeEntered().equals(d.minusMinutes(1))) {

					System.out.println("in if...");
					Queue.inTreatment.remove(tr);
					 //tr.setPatient(null);
					//TreatmentRoom.treat

					// Queue.checkoutPatient();

				} else {
					System.out.println("in else...");

				}

			}

		}
		System.out.println("leaving treatment timer...");
	}	
}
