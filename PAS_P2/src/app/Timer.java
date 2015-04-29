package app;

public class Timer implements Runnable {
	
	@Override
	public void run() {

		boolean go = true;
		
		for (int loop = 60000; loop > 1; loop--){
			
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
