package app;

/**
 * class to handle the time validation for a patient in the treatment room
 * 
 * @author KHackett
 *
 */
public class TreatmentTimer {

	/**
	 * Constant to represent target treatment time set by trust
	 */
	public static final int TARGET_TREATMENT_TIME = 2;

	/**
	 * Constant to represent treatment time extension
	 */
	private static final int EXTENDED_TREATMENT_TIME = 5;

	/**
	 * method to remove patient from treatment room after a certain time period
	 */
	public static void treatmentRoomTimer() {
		// check that there are patient(s) in treatment
		if (Queue.inTreatment.size() != 0) {
			for (TreatmentRoom tr : TreatmentRoom.treat) {

				// check times....
				if (((tr.getTimeEntered().plusMinutes(TARGET_TREATMENT_TIME))
						.isBeforeNow())) {
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
	 * 
	 * @param t
	 */
	public static void extendTreatment(TreatmentRoom t) {
		// increase kick out time by 5 minutes
		t.setTimeEntered(t.getTimeEntered().plusMinutes(
				TARGET_TREATMENT_TIME + EXTENDED_TREATMENT_TIME));
	} // end of extendTreatment method
}