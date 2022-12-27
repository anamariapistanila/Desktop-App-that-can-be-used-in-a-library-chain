package Controller;

import java.sql.*;
import java.util.logging.Logger;
import java.sql.DriverManager;

public class ConnectionDB {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(ConnectionDB.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/librarie";
	private static final String USER = "root";
	private static final String PASS = "dimamida99";

	private static Connection con = null;
	
	

	private ConnectionDB() {
		try {
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static Connection getConnection() {

		try {
			if (con == null) {
				con = DriverManager.getConnection(DBURL, USER, PASS);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return con;
	}

	public static void close(Connection connection) {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
