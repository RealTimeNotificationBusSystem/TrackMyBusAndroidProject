package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drives are loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection connect() {
		Connection con = null;

		try {
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/trackmybus?"
							+ "user=root&password=root");
			System.out.println("Database is connected successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void disConnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
