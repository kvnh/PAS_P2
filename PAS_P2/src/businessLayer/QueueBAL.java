package businessLayer;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import dataAccessLayer.QueueDA;
import objects.Patient;

/**
 * Business Layer between Queue and Data Access
 * @author Andrew Walmsley
 *
 */
public class QueueBAL {
	
	
	/**
	 * New method to DAL
	 * Adds patient to list
	 */
	public void addToInQueueBAL(Patient p) throws SQLException{
		QueueDA.addToInQueue(p);
	}
	
	public ObservableList<Patient> selectAllInQueueBAL() throws SQLException{
		return QueueDA.selectAllData();
	}
	
	

	/**
	 * May remove this method as it is no longer needed
	 * @param p
	 * @throws SQLException
	 */
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
	
	
	

