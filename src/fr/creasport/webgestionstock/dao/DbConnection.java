package fr.creasport.webgestionstock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private String url = "jdbc:mysql://127.0.0.1:3306/videotheque2";
	private String user = "root";
	private String passwd = "";
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
