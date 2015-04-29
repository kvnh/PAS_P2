package app;

import controllers.DoctorAssessmentPageController;

public class Timer implements Runnable {
	
	@Override
	public void run() {

		boolean go = true;
		
		for (int loop = 600000; loop > 1; loop--){
			
			//check if patient has left treatment room
			
//			if ()
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Stopping...");
				go = false;
				break;
			}
			
			System.out.println(loop);
		}

	}
}
