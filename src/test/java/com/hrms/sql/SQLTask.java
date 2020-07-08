package com.hrms.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SQLTask {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";// we get the hostname and port from mysql DB

	@Test
	public void abc1() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");// we check if connection is established
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");

		List<String> list = new ArrayList<>();

		while (rs.next()) {
			list.add(rs.getObject("job_title").toString());
		}
		System.out.println(list);
		for (String data : list) {
			System.out.println(data);
		}

	}

}
