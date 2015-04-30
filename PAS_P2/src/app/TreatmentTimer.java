package app;

public class TreatmentTimer {

	public static void treatmentRoomTimer() {

		if (Queue.inTreatment.size() != 0) {

			for (TreatmentRoom tr : TreatmentRoom.treat) {

				System.out.println("in for...");

				System.out.println(tr.getTimeEntered());

				if ((tr.getTimeEntered().plusMinutes(3)).isBeforeNow()) {

					System.out.println("in if...");

					Queue.checkoutPatient(tr);

				} else {
					System.out.println("in else...");

				}

			}

		}
		System.out.println("leaving treatment timer...");
	}
}
