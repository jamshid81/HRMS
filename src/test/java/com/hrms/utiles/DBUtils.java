package com.hrms.utiles;

import java.sql.*;
import java.util.*;

public class DBUtils {

	public static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static ResultSetMetaData rsMetaData;
	private static List<Map<String, String>> listOfData;

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
	 * this method will execute the query and store the data inside the list of maps
	 * by the given sql query
	 * @param sqlQuery
	 * @return <-- List<Map<String, String>>
	 */
	public static List<Map<String, String>> storeDataFromDB(String sqlQuery) {
		try {
			getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sqlQuery);
			rsMetaData = rs.getMetaData();
			listOfData = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> mapOfData = new LinkedHashMap<>();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					mapOfData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());

				}
				listOfData.add(mapOfData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfData;
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
