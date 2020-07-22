package com.hrms.sql;

import java.sql.*;
import java.util.*;


import org.junit.Test;

import com.hrms.utiles.DBUtils;

public class MetaData extends DBUtils {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	//@Test
	public void metaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();//this line is needed to initalize the dataBaseMetadata
		String driverName = dbMetaData.getDriverName();
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);

	}

	// query =display all the info about employee whose emp_number is 14688
	@Test
	public void rsMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select emp_firstname from hs_hr_employees where employee_id = 730462");
		
	
		ResultSetMetaData rsMetadata = rs.getMetaData();
		
		
		int colNumbers = rsMetadata.getColumnCount();
//		System.out.println(colNumbers);
	
		
		String colName1 = rsMetadata.getColumnName(1);
		System.out.println(colName1);
//		while (rs.next()) {
//			for (int i = 1; i <= colNumbers; i++) {
//				String colNames = rsMetadata.getColumnName(1);
//				String columnValue= rs.getString("emp_firstname");
//				System.out.println(colNames+" = "+ columnValue);
//				
//			}
		
		while (rs.next()) {
		for (int i = 1; i <= colNumbers; i++) {
			String colNames = rsMetadata.getColumnName(i);
			String columnValue= rs.getString(i);
			System.out.println(colNames+" = "+ columnValue);
			
		}
	
		}
		closeConnection();

	}
}
