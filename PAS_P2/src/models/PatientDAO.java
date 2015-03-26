package models;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javafx.collections.FXCollections;
//import app.Patient;

/**
 * PatientDAO class implements the Data Access Object (DAO) pattern which encapsulates access to the data source.
 * This class defines methods for each query, where we first create a connection object using ConnectionFactory 
 * (by calling ConnectionFactory.getConnection()). 
 * From this connection object we create statement and execute queries. 
 * @author KHackett
 *
 */
public class PatientDAO {

//	private Connection connection;
//    private Statement statement;
	
	/**
	 * default constructor
	 */
	public PatientDAO() {
	}
	
//	public Patient searchPatient(String firstNameValue, String lastNameValue)throws SQLException{
//		// String query = "SELECT * FROM employee WHERE emp_id=" + employeeId;
//		
//		String query = "SELECT * FROM patient WHERE firstName ='" + firstNameValue + "' AND lastName = '"
//				+ lastNameValue + "'";
//		System.out.println("Inserting\n" + query);
//		
//		data = FXCollections.observableArrayList();
//		
//        ResultSet rs = null;
//        Patient patient = null;
//        try {
//            connection = ConnectionFactory.getConnection();
//            statement = connection.createStatement();
//            rs = statement.executeQuery(query);
//            . . . .
//            . . . .
//        } finally {
//            DbUtil.close(rs);
//            DbUtil.close(statement);
//            DbUtil.close(connection);
//        }
//        return employee;
//	}
	
}