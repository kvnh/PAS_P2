package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DbUtil class is used to close database ResultSet, Statement and Connection objects
 * A check is made for non-null references before calling close() instance method to avoid a NullPointerException.
 * In the calling method, these methods are called from a finally block in order to release all resources.
 * 
 * @author KHackett
 *
 */
public class DbUtil {

	/**
	 * method to close Connection object
	 * @param connection
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	/**
	 * method to close Statement object
	 * @param statement
	 */
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	/**
	 * method to close ResultSet object
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

}
