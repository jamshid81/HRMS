package com.hrms.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class PracticeWithSQL {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void getMetaData() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		DatabaseMetaData db = con.getMetaData();
		System.out.println(db.getDriverName());
		System.out.println(db.getDatabaseProductVersion());

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where employee_id = 730462");
//				String columnValue=rs.getString("emp_firstname");
//				System.out.println(columnValue);

		ResultSetMetaData rSMetadata = rs.getMetaData();

		int columnNumber = rSMetadata.getColumnCount();
		String colName = rSMetadata.getColumnName(1);

		System.out.println(columnNumber);
		//System.out.println(colName);

		while (rs.next()) {
			for (int i = 1; i <= columnNumber; i++) {
				String columnName=rSMetadata.getColumnName(i);
				String columnValue=rs.getString(i);
				System.out.println(columnName+" = "+columnValue);
			}
		}
	}

}
