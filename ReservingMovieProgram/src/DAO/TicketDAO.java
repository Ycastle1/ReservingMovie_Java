package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.TicketDTO;

public class TicketDAO {
	
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
	
	public void addTicketTblColumns(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		sql.append("INSERT INTO tickettbl VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ticket.getCustomerName());
			pstmt.setString(2, ticket.getCustomerId());
			pstmt.setString(3, ticket.getSeatNumber());
			pstmt.setString(4, ticket.getTheatherName());
			pstmt.setString(5, ticket.getRoomNumber());  	
			pstmt.setString(6, ticket.getMovieName());  	
			pstmt.setString(7, ticket.getDate());  	
			pstmt.setString(8, ticket.getScreenTime());  	
			pstmt.setLong(9, ticket.getCost());  	
			pstmt.setLong(10, ticket.getPersonCount());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("Add O");
    		else
    			System.out.println("Add X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
	
	public ResultSet getReservationResultSet(String id) {
		String sql = "SELECT * FROM tickettbl where customerId = '" + id + "';";
		Connection con = connectDB();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return rs;
		}
	}
	
	
	
	public ResultSet getReservationTicket(String id) {
		String sql = "SELECT * FROM tickettbl where customerId = '" + id + "';";
		Connection con = connectDB();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql");
			return rs;
		}
	}
	
	public String getRoomName(TicketDTO ticket) {
		String sql = "SELECT * FROM theathertbl where theatherName = '" + ticket.getTheatherName() + "' AND "
				+ "movieName = '" + ticket.getMovieName() + "' AND date = '" + ticket.getDate() + "' AND "
				+ "screenTime = '" + ticket.getScreenTime() + "';";
		Connection con = connectDB();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				String roomNumber = rs.getString("roomnumber");
				return roomNumber;
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
	
	public void updateTicketTblColumns(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		sql.append("UPDATE tickettbl SET seatnumber = ? WHERE (customername = ? AND customerid =  ? AND theathername = ? AND roomnumber = ? AND moviename =  ? AND date = ? AND"
				+ " screentime =  ? AND cost = ? personcount = ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ticket.getSeatNumber());
			pstmt.setString(2, ticket.getCustomerName());
			pstmt.setString(3, ticket.getCustomerId());
			pstmt.setString(4, ticket.getTheatherName());
			pstmt.setString(5, ticket.getRoomNumber());  	
			pstmt.setString(6, ticket.getMovieName());  	
			pstmt.setString(7, ticket.getDate());  	
			pstmt.setString(8, ticket.getScreenTime());  	
			pstmt.setLong(9, ticket.getCost());  	
			pstmt.setLong(10, ticket.getPersonCount());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("Add O");
    		else
    			System.out.println("Add X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
	
	public boolean deleteTicketTblColumns(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		sql.append("DELETE FROM tickettbl WHERE (customerName = ? AND customerid =  ? AND seatnumber = ? AND theatherName =  ? AND roomnumber =  ? AND moviename = ? AND date = ? AND screentime = ? AND cost =  ? AND personcount = ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ticket.getCustomerName());
			pstmt.setString(2, ticket.getCustomerId());
			pstmt.setString(3, ticket.getSeatNumber());
			pstmt.setString(4, ticket.getTheatherName());
			pstmt.setString(5, ticket.getRoomNumber());  	
			pstmt.setString(6, ticket.getMovieName());  	
			pstmt.setString(7, ticket.getDate());  	
			pstmt.setString(8, ticket.getScreenTime());  	
			pstmt.setLong(9, ticket.getCost());  	
			pstmt.setLong(10, ticket.getPersonCount());  	
			
			if (pstmt.executeUpdate() == 1) {
    			System.out.println("Delete O");
				return true;
			}
    		else {
    			System.out.println("Delete X");
				return false;
    		}
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
				return false;
			}
	}
}
