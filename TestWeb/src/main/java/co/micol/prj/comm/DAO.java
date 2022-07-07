package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO { 

	public Connection conn;
	public PreparedStatement psmt; // 쿼리문 실행하고 결과를 받아오는
	public ResultSet rs; // 결과값을 여기다 담아준다.

	public void getConnect() {
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버가 있어야 디비랑 소통할수있다. 앱이 바로 디비랑 소통을 못함. 앱에 드라이버가 로드됨
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // connection객체가 만들어짐
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disConnect() { // 오픈한 순서의 반대로 닫는다
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
