package businessLayer;

import java.sql.SQLException;

import dataAccessLayer.QueueDA;
import objects.Patient;

/**
 * Business Layer between Queue and Data Access
 * @author Andrew Walmsley
 *
 */
public class QueueBAL {

	public void addToQueueTableBAL(Patient p) throws SQLException{
		QueueDA.addToQueueTable(p);
	}
	
	public void removeFromQueueTableBAL(Patient p) throws SQLException{
	
		QueueDA.removeFromQueueTable(p);
	}

	public void displayQueueDataBAL(Patient p) throws SQLException{
		QueueDA.displayQueueData(p);
	}
	
}
	
	
	

