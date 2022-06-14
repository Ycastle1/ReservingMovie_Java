package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.CustomerDTO;

public class CustomerDAO {
	public Connection connectDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹� �ε�.
			System.out.println("driver connected");
			
			String url = "jdbc:mysql://localhost:3306/reservemoviedb?serverTimezome=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			con = DriverManager.getConnection(url, user, password); //  ���� ��ü ������.
			System.out.println("DB schema connected");
			
		} catch (ClassNotFoundException e) {
			System.out.println("x1.class");
		} catch (SQLException e) {
			System.out.println("x2.sql");
		}
		
		return con;
	}
	
	public void registerCustomer(CustomerDTO customer) {
		Connection con = connectDB();
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO customertbl ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
	

			pstmt.setString(1, customer.getCustomerId());
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3, customer.getCustomerName());
			pstmt.setString(4, customer.getCustomerEmail());
			pstmt.setString(5, customer.getCustomerPhoneNumber());
    		
    		if (pstmt.executeUpdate() == 1) 
    			System.out.println("Register O");
    		else
    					System.out.println("Register X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
	
	public boolean login(String id, String pw) {
		String sql = "SELECT * FROM customertbl where customerId = '" + id + "'";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String correctPassword = rs.getString("customerPassword");
				if (pw.equals(correctPassword)) {		
					System.out.println("good");			
					return true;
				}
				else {
					System.out.println("password");
					return false;
				}
			}				
			else {		
				System.out.println("id");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return false;
		}
	}
	
	public String getCustomerNameById(String id) {
		String sql = "SELECT * FROM customertbl where customerId = '" + id + "';";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String name = rs.getString("customerName");
				return name;
			}				
			else {		
				System.out.println("class");
				return "-1";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return "-1";
		}
	}
}
