package app;

public class TreatmentTimer {

	/**
	 * method to remove patient from treatment room after a certain time period
	 */
	public static void treatmentRoomTimer() {

		// check that there are patient(s) in treatment
		if (Queue.inTreatment.size() != 0) {

			for (TreatmentRoom tr : TreatmentRoom.treat) {

				System.out.println("in for...");

				System.out.println(tr.getTimeEntered());

				// check times....
				if ((tr.getKickout().isBeforeNow())) {

					System.out.println("in if...");

					// remove patient
					Queue.checkoutPatient(tr);

				} else {
					System.out.println("in else...");

				}

			}

		}
		System.out.println("leaving treatment timer...");
	}

	/**
	 * method to extend treatment time by 5 minutes
	 * 
	 * @param t
	 */
//	public static void extendTreatment(TreatmentRoom t) {
//
//		// increase kick out time by 5 minutes
//		t.setKickout(t.getKickout().minusMinutes(2));
//
//	}
}
