package com.hrms.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class InClassTask {

	// display the information from nationality table,
	// but display id “nationality id”, name = “nationality”

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void nationalityTableTask() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select* from ohrm_nationality");
		ResultSetMetaData cellData = rs.getMetaData();

		List<Map<String, String>> listOfMaps = new ArrayList<>();
		Map<String, String> mapOfData;
		while (rs.next()) {
			mapOfData = new LinkedHashMap<>();
			for (int i = 1; i < cellData.getColumnCount(); i++) {

				mapOfData.put("nationality id", rs.getObject(i).toString());
				mapOfData.put("nationality", rs.getObject(i).toString());

			}
			listOfMaps.add(mapOfData);
		}
		System.out.println(listOfMaps);
		rs.close();
		st.close();
		con.close();
	}

}
