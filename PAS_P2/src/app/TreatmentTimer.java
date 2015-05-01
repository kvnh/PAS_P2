package app;

/**
 * class to handle the time validation for a patient in the treatment room
 * @author KHackett
 *
 */
public class TreatmentTimer {

	/**
	 * method to remove patient from treatment room after a certain time period
	 */
	public static void treatmentRoomTimer() {
		// check that there are patient(s) in treatment
		if (Queue.inTreatment.size() != 0) {
			for (TreatmentRoom tr : TreatmentRoom.treat) {
				System.out.println(tr.getTimeEntered());
				// check times....
				if (((tr.getTimeEntered().plusMinutes(1)).isBeforeNow())) {
					// remove patient
					Queue.checkoutPatient(tr);
				} else {
					// patient still has time in treatment
				}
			}
		}
	} // end of treatmentRoomTimer method

	/**
	 * method to extend treatment time by 5 minutes
	 * @param t
	 */
	public static void extendTreatment(TreatmentRoom t) {
		// increase kick out time by 5 minutes
		t.setTimeEntered(t.getTimeEntered().plusMinutes(2));
	} // end of extendTreatment method
}