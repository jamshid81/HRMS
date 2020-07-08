package com.hrms.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class Review {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void review() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_skill");
		ResultSetMetaData data = rs.getMetaData();

		for (int i = 1; i <= data.getColumnCount(); i++) {
			String columnName = data.getColumnName(i);
			System.out.println(columnName);
		}
		List<String> list = new ArrayList<>();
		while (rs.next()) {
			list.add(rs.getObject("id").toString());
			list.add(rs.getObject("name").toString());
			list.add(rs.getObject("description").toString());
			
		}
		System.out.println(list);
		rs.close();
		st.close();
		con.close();
	}
	
}
