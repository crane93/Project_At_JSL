package Dao;

import java.sql.*;

public class DBCon {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/java";
	String id = "root";
	String pw = "1234";

	Connection con = null;

	public DBCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println("DataBase에 접속할 수 없습니다");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}
}