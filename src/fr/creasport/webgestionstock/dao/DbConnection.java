package fr.creasport.webgestionstock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private String url = "jdbc:mysql://10.1.3.74:3306/creasport";
	private String user = "creasport";
	private String passwd = "creasport";
	private static Connection connect;

	private DbConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {

			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() throws ClassNotFoundException {
		if (connect == null) {
			new DbConnection();
		}
		return connect;
	}
}
