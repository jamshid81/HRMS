package com.hrms.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class SQLHwork {
	// hw get the resultset metadata store it in the arraylist and retrieve it from arraylist; also, get column type name get the table names
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";// jdbc:driverType:hostname:port/db name
	// 1. creat a method to establish metaData connection, Statement, execute guery,and creat result
	@Test
	public void metaData() throws SQLException {
		Connection connectToSql = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData metaDataDbase = connectToSql.getMetaData();
		System.out.println("The driver name is " + metaDataDbase.getDriverName());
		System.out.println("The version of the database is " + metaDataDbase.getDatabaseProductVersion());
		Statement statement = connectToSql.createStatement();
		ResultSet result = statement.executeQuery("select * from hs_hr_emp_dependents");
		ResultSetMetaData mResult = result.getMetaData();
		System.out.println("There are " + mResult.getColumnCount() + " columns in this table");
		System.out.println("The name of this table is " + mResult.getTableName(1));
		System.out.println("The first Column title is " + mResult.getColumnName(1));
		for (int i = 1; i < mResult.getColumnCount(); i++) {
			String colNames = mResult.getColumnName(i);
			System.out.print("|" + colNames + "|");
		}
		ArrayList<String> listOfData = new ArrayList<>();
		while (result.next()) {
			listOfData.add(result.getObject("ed_name").toString());

		}
		for (String dNames : listOfData)
			System.out.println("|" + dNames + "|");

		// Just for fun I am elemenating duplicate names
		Set<String> elemenateDuplicateNameSet = new TreeSet<>(listOfData);
		System.out.println(elemenateDuplicateNameSet);

	}

}
