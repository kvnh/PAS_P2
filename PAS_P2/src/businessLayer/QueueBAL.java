package businessLayer;

import dataAccessLayer.QueueDA;
import objects.Patient;

/**
 * Business Layer between Queue and Data Access
 * @author Andrew Walmsley
 *
 */
public class QueueBAL {

	public void addToQueueTableBAL(Patient p){
		QueueDA.addToQueueTable(p);
	}
	
	public void removeFromQueueTableBAL(Patient p){
	
		QueueDA.removeFromQueueTable(p);
	}

	public void displayQueueDataBAL(Patient p){
		QueueDA.displayQueueData(p);
	}
	
}
	
	
	

