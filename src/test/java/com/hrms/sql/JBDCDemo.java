package com.hrms.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JBDCDemo {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	//jdbc:driver typ:hostname:port/db name
	String dbUrl ="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";//we get the hostname and port from mysql DB
	
	@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");// we check if connection is established
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");
		
		rs.next();
		String firstname = rs.getString("emp_firstname");
		System.out.println(firstname);
		rs.next();
		//if we dont know that the result is integer or string we do getObject and convert it to string
		String firstname2 = rs.getObject("emp_firstname").toString();
		System.out.println(firstname2);
		while(rs.next()) {
			String allData = rs.getObject("emp_firstname").toString();
			System.out.println(allData);
			
		}
		rs.close();
		st.close();
		conn.close();
	}
}
