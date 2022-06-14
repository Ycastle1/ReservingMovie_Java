package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.SeatDTO;
import DTO.TicketDTO;

public class SeatDAO {
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
	
	public boolean checkReserved(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		ResultSet rs1;
		System.out.println(ticket.getDate());
		sql.append("SELECT * FROM seattbl where theathername = ? AND ");
		sql.append("roomnumber = ? AND ");
		sql.append("moviename = ? AND ");
		sql.append("screentime = ? AND ");
		sql.append("date = ? AND ");
		sql.append("seatnumber = ?;");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, ticket.getTheatherName());
			System.out.println(ticket.getTheatherName());
			pstmt.setString(2, ticket.getRoomNumber());
			System.out.println(ticket.getRoomNumber());
			pstmt.setString(3, ticket.getMovieName());
			System.out.println(ticket.getMovieName());
			pstmt.setString(4, ticket.getScreenTime());
			System.out.println(ticket.getScreenTime());
			pstmt.setString(5, ticket.getDate());  	
			System.out.println(ticket.getDate());
			pstmt.setString(6, ticket.getSeatNumber());  	
			System.out.println(ticket.getSeatNumber());
			
			rs1 = pstmt.executeQuery();
			rs1.next();
			int result = rs1.getInt("reserved");
			if (result == 1) {		
				System.out.println("예약되어있음");			
				return true;
			}
			else {
				System.out.println("예매 가능");
				return false;
			}	
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
	}
	
	public void reserveSeat(SeatDTO seatDto) {
		
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		
		sql.append("UPDATE reservemoviedb.seattbl SET reserved = 1 where(theathername = ? AND ");
		sql.append("movieName =  ? AND ");
		sql.append("date = ? AND ");
		sql.append("screenTime = ? AND ");
		sql.append("seatnumber = ?);");
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, seatDto.getTheatherName());
			pstmt.setString(2, seatDto.getMovieName());
			pstmt.setString(3, seatDto.getDate());
			pstmt.setString(4, seatDto.getScreenTime());
			pstmt.setString(5, seatDto.getSeatNumber());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("Reserve O");
    		else
    			System.out.println("Reserve X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
	
	public void refundSeat(TicketDTO ticket) {
		StringBuilder sql = new StringBuilder();
		Connection con = connectDB();
		
		sql.append("UPDATE reservemoviedb.seattbl SET reserved = 0 where(theathername = ? AND ");
		sql.append("movieName =  ? AND ");
		sql.append("date = ? AND ");
		sql.append("screenTime = ? AND ");
		sql.append("seatnumber = ?);");
		System.out.println(ticket.getSeatNumber());
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, ticket.getTheatherName());
			pstmt.setString(2, ticket.getMovieName());
			pstmt.setString(3, ticket.getDate());
			pstmt.setString(4, ticket.getScreenTime());
			pstmt.setString(5, ticket.getSeatNumber());  	
			
			if (pstmt.executeUpdate() == 1) 
    			System.out.println("return O");
    		else
    			System.out.println("return X");
	    	} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed, SQL");
			}
	}
}
