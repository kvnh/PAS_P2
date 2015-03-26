package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory class implements the Singleton pattern  defining database 
 * connection configuration statements and methods to make connection to the database.
 * Therefore we can create one object of this class and create many Connection objects (one factory, many objects).
 * @author KHackett
 *
 */
public class ConnectionFactory {

	// static reference to itself
	private static ConnectionFactory connectionFactory = new ConnectionFactory();

	// private constructor (Singleton pattern implementation)
	private ConnectionFactory() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:src/models/pas.db");
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	public static Connection getConnection() {
		return connectionFactory.createConnection();
	}

}