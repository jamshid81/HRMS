package com.hrms.utiles;

import java.sql.*;

public class DBUtils {

	private static Connection con;
	private static Statement st;
	private static ResultSet rs;

	/**
	 * this method will establish a connection with db
	 */
	public static void getConnection() {
		try {
			con = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will close the connection with db
	 */
	public static void closeConnection() {
		try {
			if (rs != null) {
					rs.close();
			}
			if (st != null) {
					st.close();
			}
			if (con != null) {
					con.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
