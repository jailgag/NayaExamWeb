package com.naya.exam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	//연결만 담당 상글톤 패턴적용!!!
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "KH";
	private static final String PASSWORD = "KH";
	
	//싱글톤은 객체를 한번만 만들어서 사용!!
	private static JDBCTemplate instance;
	
	private JDBCTemplate() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static JDBCTemplate getInstance() {
		if(instance ==null)
			instance = new JDBCTemplate();
		return instance;
	}
	public static Connection getConnection() throws SQLException {  //임포트 또안됨...근데 다시 됨....
		Connection conn =DriverManager.getConnection(URL, USERNAME,PASSWORD);
		return conn;
	}
	
}
