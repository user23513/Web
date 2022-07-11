package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource { //DAO 싱글톤클래스 ->  
	private static DataSource dataSource = new DataSource(); //인스턴스 생성
	private Connection conn;
	
	private DataSource() {} //남들이 나를 생성하지 못하도록 -> private 생성자를 만들고
	 
	
	public static DataSource getInstance() { //인스턴스를 리턴한다.
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "micol", "1234");
			System.out.println("DB 연결 성공!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패!!");
		}
		
		return conn;
	}
}
